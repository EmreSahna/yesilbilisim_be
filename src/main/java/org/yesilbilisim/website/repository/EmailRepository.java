package org.yesilbilisim.website.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yesilbilisim.website.model.EmailModel;

public interface EmailRepository extends JpaRepository<EmailModel,Long> {
}
