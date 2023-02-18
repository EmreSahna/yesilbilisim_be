package org.yesilbilisim.backend.service.impl;

import org.springframework.stereotype.Service;
import org.yesilbilisim.backend.dto.request.ContactRequest;
import org.yesilbilisim.backend.entity.Contacts.Contact;
import org.yesilbilisim.backend.repository.ContactRepository;
import org.yesilbilisim.backend.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public String createContact(ContactRequest contactRequest) {
        contactRepository.save(Contact.builder()
            .fullName(contactRequest.getFullName())
            .email(contactRequest.getEmail())
            .company(contactRequest.getCompany())
            .subject(contactRequest.getSubject())
            .message(contactRequest.getMessage())
        .build());
        return "Contact created successfully";
    }
}
