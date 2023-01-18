package org.yesilbilisim.website.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "contact")
public class ContactModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String email;
    private String company;
    private String subject;
    private String message;
}
