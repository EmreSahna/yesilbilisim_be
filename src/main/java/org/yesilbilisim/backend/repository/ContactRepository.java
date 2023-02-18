package org.yesilbilisim.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yesilbilisim.backend.entity.Contacts.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
