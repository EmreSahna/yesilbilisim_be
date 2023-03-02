package org.yesilbilisim.backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BlogResponseWithPaggination {
    private List<BlogsResponse> blogResponses;
    private int totalPages;
    private int currentPage;
}
