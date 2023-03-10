package org.yesilbilisim.backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BlogsNavigatorResponse {
    private String thumbnailImage;
    private String createdDate;
    private String title;
    private String url;
}
