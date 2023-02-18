package org.yesilbilisim.backend.entity.Views;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "image_view")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageView {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String image;
    private ViewType type;
}
