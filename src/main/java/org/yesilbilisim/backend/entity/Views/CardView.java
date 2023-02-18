package org.yesilbilisim.backend.entity.Views;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "card_view")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CardView {
    @Id
    @GeneratedValue(generator = "route-id")
    @GenericGenerator(name = "route-id", strategy = "org.yesilbilisim.backend.util.RouteIdGenerator")
    private String id;
    private String title;
    @Column(length = 10000)
    private String cardContent;
    private String icon;
    private ViewType type;
    private int orderCard;
}
