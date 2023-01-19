package org.yesilbilisim.website.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@Table(name = "descriptional_image")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class DescriptionalImageModel extends ImageModel {
    private String title;
    @Column(length = 1000)
    private String description;
}
