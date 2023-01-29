package org.yesilbilisim.website.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductPageResponse {
    private int currentPage;
    private int totalElements;
    private int totalPages;
    private List<ProductResponse> products;
}
