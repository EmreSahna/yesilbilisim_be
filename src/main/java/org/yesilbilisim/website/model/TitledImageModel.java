package org.yesilbilisim.website.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@Table(name = "titled_image")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class TitledImageModel extends ImageModel {
    private String title;
}
