package org.yesilbilisim.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yesilbilisim.backend.entity.Mails.Email;

public interface EmailRepository extends JpaRepository<Email,Long> {
}
