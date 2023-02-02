package org.yesilbilisim.website.service;

import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.yesilbilisim.website.model.BlogInfoModel;
import org.yesilbilisim.website.model.MediumPostModel;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.stream.Collectors;

@Service
public class BlogService {
    @Value("${medium.username}")
    private String username;

    @Value("${medium.url}")
    private String mediumUrl;

    private final RestTemplate restTemplate;

    public BlogService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public SyndFeed getRss() {
        String rssUrl = mediumUrl + username;
        String rssContent = restTemplate.getForObject(rssUrl, String.class);
        InputStream is = new ByteArrayInputStream(rssContent.getBytes());
        SyndFeed feed = null;
        try {
            feed = new SyndFeedInput().build(new XmlReader(is));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return feed;
    }

    public BlogInfoModel getUsersMedium() {
        SyndFeed feed = getRss();
        return BlogInfoModel.builder()
            .posts(
                feed.getEntries().stream().map(
                    entry -> MediumPostModel.builder()
                        .title(entry.getTitle())
                        .description(entry.getContents().get(0).getValue().split("<p>")[1].split("<\\/p>")[0])
                        .link(entry.getLink())
                        .pubDate(entry.getPublishedDate().toString())
                        .image(entry.getContents().get(0).getValue().split("src=\"")[1].split("\"")[0])
                        .build()
                    ).collect(Collectors.toList())
            )
            .username(feed.getTitle().split("by")[1].split("on")[0].trim())
            .profileLink(feed.getLink())
            .profileImage(feed.getImage().getUrl())
        .build();
    }
}
