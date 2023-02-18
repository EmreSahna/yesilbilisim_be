package org.yesilbilisim.backend.service;

import org.yesilbilisim.backend.dto.request.EmailRequest;
import org.yesilbilisim.backend.entity.Mails.Email;

public interface EmailService {
    Email register(EmailRequest email);
}