package org.yesilbilisim.backend.service;

import org.yesilbilisim.backend.dto.request.CardViewRequest;
import org.yesilbilisim.backend.dto.request.ImageViewRequest;
import org.yesilbilisim.backend.dto.response.HomepageResponse;
import org.yesilbilisim.backend.entity.Views.CardView;
import org.yesilbilisim.backend.entity.Views.ImageView;

import java.util.List;

public interface ViewService {
    List<CardView> getSolutions();

    CardView createCard(CardViewRequest cardViewRequest);

    List<CardView> getServices();

    ImageView createImage(ImageViewRequest imageViewRequest);

    HomepageResponse getHomepage();
}