package org.yesilbilisim.website.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yesilbilisim.website.model.TitledImageModel;

public interface TitledRepository extends JpaRepository<TitledImageModel, Long> {
}
