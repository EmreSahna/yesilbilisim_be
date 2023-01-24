package org.yesilbilisim.website.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class BlogInfoModel {
    private String username;
    private String profileLink;
    private String profileImage;
    private List<MediumPostModel> posts;
}
