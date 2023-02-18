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
public class HomepageResponse {
    private List<String> sliders;
    private List<String> companies;
    private List<CardViewHomepageResponse> cards;
}
