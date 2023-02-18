package org.yesilbilisim.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yesilbilisim.backend.dto.request.ContactRequest;
import org.yesilbilisim.backend.service.ContactService;
import org.yesilbilisim.backend.service.impl.ContactServiceImpl;

@RestController
@RequestMapping("/contact")
public class ContactController {
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveContact(@RequestBody ContactRequest contactRequest) {
        return new ResponseEntity<>(contactService.createContact(contactRequest),HttpStatus.OK);
    }
}
