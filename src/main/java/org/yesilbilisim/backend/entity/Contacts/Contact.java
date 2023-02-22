package org.yesilbilisim.backend.entity.Contacts;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    @Size(max = 30)
    private String fullName;

    @NotNull
    @NotEmpty
    private String email;

    @Size(max = 30)
    private String company;

    @NotNull
    @NotEmpty
    @Size(max = 30)
    private String subject;

    @NotNull
    @NotEmpty
    @Size(max = 500)
    private String message;
}
