package org.yesilbilisim.backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BlogsResponse {
    private String title;
    private String url;
    private String description;
    private String thumbnailImage;
    private String createdDate;
}
