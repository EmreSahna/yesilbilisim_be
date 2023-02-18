package org.yesilbilisim.backend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CardViewRequest {
    private String title;
    private String cardContent;
    private String icon;
    private String type;
    private int orderCard;
}
