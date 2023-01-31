package org.yesilbilisim.website.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FilterRequest {
    private List<String> brands;
    private List<String> categories;
    private double maxPrice;
}
