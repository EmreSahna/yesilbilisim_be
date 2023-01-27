package org.yesilbilisim.website.service;

import org.springframework.stereotype.Service;
import org.yesilbilisim.website.dto.request.EmailRequest;
import org.yesilbilisim.website.model.EmailModel;
import org.yesilbilisim.website.repository.EmailRepository;

@Service
public class EmailService {
    private final EmailRepository emailRepository;

    public EmailService(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    public EmailModel register(EmailRequest email) {
        return emailRepository.save(EmailModel.builder()
                .email(email.getEmail())
                .build()
        );
    }
}
