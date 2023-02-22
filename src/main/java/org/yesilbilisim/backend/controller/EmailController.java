package org.yesilbilisim.backend.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yesilbilisim.backend.dto.request.EmailRequest;
import org.yesilbilisim.backend.entity.Mails.Email;
import org.yesilbilisim.backend.service.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/register")
    public ResponseEntity<Email> register(@Valid @RequestBody EmailRequest email) {
        return new ResponseEntity<>(emailService.register(email), HttpStatus.OK);
    }
}
