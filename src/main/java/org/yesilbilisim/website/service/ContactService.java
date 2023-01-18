package org.yesilbilisim.website.service;

import org.springframework.stereotype.Service;
import org.yesilbilisim.website.repository.ContactRepository;

@Service
public class ContactService {
    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }
}
