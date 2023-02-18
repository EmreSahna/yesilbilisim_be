package org.yesilbilisim.backend.dto.request;

import lombok.Data;

@Data
public class BlogRequest {
    private String title;
    private String description;
    private String blogContent;
    private String thumbnailImage;
}
