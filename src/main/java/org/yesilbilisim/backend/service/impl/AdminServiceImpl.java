package org.yesilbilisim.backend.service.impl;

import org.springframework.stereotype.Service;
import org.yesilbilisim.backend.repository.EmailRepository;
import org.yesilbilisim.backend.service.AdminService;
import org.yesilbilisim.backend.util.GenerateFileWithStrings;

@Service
public class AdminServiceImpl implements AdminService {

    private final EmailRepository emailRepository;

    public AdminServiceImpl(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    @Override
    public byte[] getMailSection() {
        GenerateFileWithStrings generateFileWithStrings = new GenerateFileWithStrings();
        String[] strings = emailRepository.findAll().stream().map(email -> email.getEmail()).toArray(String[]::new);
        return generateFileWithStrings.generateFile(strings);
    }
}
