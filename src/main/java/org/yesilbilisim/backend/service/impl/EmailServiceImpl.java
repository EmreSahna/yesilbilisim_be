package org.yesilbilisim.backend.service.impl;

import org.springframework.stereotype.Service;
import org.yesilbilisim.backend.dto.request.EmailRequest;
import org.yesilbilisim.backend.entity.Mails.Email;
import org.yesilbilisim.backend.repository.EmailRepository;
import org.yesilbilisim.backend.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {
    private final EmailRepository emailRepository;

    public EmailServiceImpl(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    @Override
    public Email register(EmailRequest email) {
        return emailRepository.save(Email.builder()
            .email(email.getEmail())
        .build());
    }
}
