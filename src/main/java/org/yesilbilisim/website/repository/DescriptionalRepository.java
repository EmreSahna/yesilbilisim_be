package org.yesilbilisim.website.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yesilbilisim.website.model.DescriptionalImageModel;


public interface DescriptionalRepository extends JpaRepository<DescriptionalImageModel, Long> {
}
