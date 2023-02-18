package org.yesilbilisim.backend.service;

import org.yesilbilisim.backend.dto.request.ContactRequest;

public interface ContactService {
    String createContact(ContactRequest contactRequest);
}