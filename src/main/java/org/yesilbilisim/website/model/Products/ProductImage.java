package org.yesilbilisim.website.model.Products;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.yesilbilisim.website.model.ImageModel;

@Entity
@Data
@Table(name = "product_image")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ProductImage extends ImageModel {
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Product product;
}
