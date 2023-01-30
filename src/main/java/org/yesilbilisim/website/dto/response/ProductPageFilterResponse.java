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
public class ProductPageFilterResponse {
    private List<BrandResponse> brands;
    private List<CategoryResponse> categories;
    private double maxPrice;
}