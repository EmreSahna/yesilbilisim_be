package org.yesilbilisim.website.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class MediumPostModel {
    private String title;
    private String description;
    private String link;
    private String pubDate;
    private String image;
}
