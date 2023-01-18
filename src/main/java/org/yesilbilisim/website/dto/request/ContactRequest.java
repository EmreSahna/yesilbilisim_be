package org.yesilbilisim.website.dto.request;

import lombok.Data;

@Data
public class ContactRequest {
    private String fullName;
    private String email;
    private String company;
    private String subject;
    private String message;
}
