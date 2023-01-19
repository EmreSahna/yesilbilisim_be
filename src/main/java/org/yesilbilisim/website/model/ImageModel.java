package org.yesilbilisim.website.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@Table(name = "image")
@SuperBuilder
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor
@AllArgsConstructor
public class ImageModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image_generator")
    @SequenceGenerator(name = "image_generator", sequenceName = "image_seq", allocationSize = 1)
    private Long id;
    private String folder;
    private String filename;
}
