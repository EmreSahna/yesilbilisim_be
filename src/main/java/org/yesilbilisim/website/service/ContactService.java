package org.yesilbilisim.website.service;

import org.springframework.stereotype.Service;
import org.yesilbilisim.website.dto.request.ContactRequest;
import org.yesilbilisim.website.model.ContactModel;
import org.yesilbilisim.website.repository.ContactRepository;

@Service
public class ContactService {
    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public String createContact(ContactRequest contactRequest) {
        contactRepository.save(ContactModel.builder()
            .fullName(contactRequest.getFullName())
            .email(contactRequest.getEmail())
            .company(contactRequest.getCompany())
            .subject(contactRequest.getSubject())
            .message(contactRequest.getMessage())
        .build());
        return "Contact created successfully";
    }
}
