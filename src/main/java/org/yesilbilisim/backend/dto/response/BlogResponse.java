package org.yesilbilisim.backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class BlogResponse {
    private String title;
    private String description;
    private String createdDate;
    private String blogContent;
    private String tags;
}
