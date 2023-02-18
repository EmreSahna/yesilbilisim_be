package org.yesilbilisim.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.yesilbilisim.backend.entity.Views.CardView;

import java.util.List;

public interface CardViewRepository extends JpaRepository<CardView, String> {
    @Query(value = "Select * from card_view c where c.type = 1 order by c.order_card asc", nativeQuery = true)
    List<CardView> findServices();

    @Query(value = "Select * from card_view c where c.type = 0 order by c.order_card asc", nativeQuery = true)
    List<CardView> findSolutions();

    @Query(value = "Select * from card_view c order by c.order_card ASC", nativeQuery = true)
    List<CardView> findAllByOrder();
}
