package org.yesilbilisim.website.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yesilbilisim.website.model.ContactModel;

public interface ContactRepository extends JpaRepository<ContactModel, Long> {
}
