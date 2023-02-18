package org.yesilbilisim.backend.service.impl;

import org.springframework.stereotype.Service;
import org.yesilbilisim.backend.dto.request.BlogRequest;
import org.yesilbilisim.backend.dto.response.BlogsNavigatorResponse;
import org.yesilbilisim.backend.dto.response.BlogsResponse;
import org.yesilbilisim.backend.entity.Blogs.Blog;
import org.yesilbilisim.backend.repository.BlogRepository;
import org.yesilbilisim.backend.service.BlogService;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogServiceImpl implements BlogService {
    private final BlogRepository blogRepository;

    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public Blog createBlog(BlogRequest blogRequest) {
        LocalDateTime localDateTime = LocalDateTime.now();
        String blogMonth = Month.of(localDateTime.getMonthValue()).name();
        String blogCreated = blogMonth.substring(0,1)+blogMonth.substring(1,3).toLowerCase() + " " + localDateTime.getDayOfMonth() + ","+ localDateTime.getYear();
        return blogRepository.save(Blog.builder()
                .title(blogRequest.getTitle())
                .description(blogRequest.getDescription())
                .createdDate(blogCreated)
                .thumbnailImage(blogRequest.getThumbnailImage())
                .blogContent(blogRequest.getBlogContent())
                .build());
    }

    @Override
    public Blog getBlog(String blogId) {
        return blogRepository.findByBlogId(blogId);
    }

    @Override
    public List<BlogsResponse> getBlogs() {
        return blogRepository.findAllByOrderByCreatedDateDesc().stream().map(blog -> {
            return BlogsResponse.builder()
                    .title(blog.getTitle())
                    .createdDate(blog.getCreatedDate())
                    .description(blog.getDescription())
                    .url(blog.getBlogId())
                    .thumbnailImage(blog.getThumbnailImage())
                    .build();
        }).collect(Collectors.toList());
    }

    @Override
    public List<BlogsNavigatorResponse> getBlogsNavigator() {
        return blogRepository.findTop3ByOrderByCreatedDateDesc().stream().map(blog -> {
            return BlogsNavigatorResponse.builder()
                    .title(blog.getTitle())
                    .url(blog.getBlogId())
                    .build();
        }).collect(Collectors.toList());
    }
}
