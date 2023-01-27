package org.yesilbilisim.website.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yesilbilisim.website.dto.request.EmailRequest;
import org.yesilbilisim.website.model.EmailModel;
import org.yesilbilisim.website.service.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/register")
    public ResponseEntity<EmailModel> register(@RequestBody EmailRequest email) {
        return new ResponseEntity<>(emailService.register(email), HttpStatus.OK);
    }
}
