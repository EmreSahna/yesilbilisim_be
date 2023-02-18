package org.yesilbilisim.backend.service.impl;

import org.springframework.stereotype.Service;
import org.yesilbilisim.backend.dto.request.CardViewRequest;
import org.yesilbilisim.backend.dto.request.ImageViewRequest;
import org.yesilbilisim.backend.dto.response.CardViewHomepageResponse;
import org.yesilbilisim.backend.dto.response.HomepageResponse;
import org.yesilbilisim.backend.entity.Views.CardView;
import org.yesilbilisim.backend.entity.Views.ImageView;
import org.yesilbilisim.backend.entity.Views.ViewType;
import org.yesilbilisim.backend.repository.CardViewRepository;
import org.yesilbilisim.backend.repository.ImageViewRepository;
import org.yesilbilisim.backend.service.ViewService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ViewServiceImpl implements ViewService {
    private final CardViewRepository cardViewRepository;
    private final ImageViewRepository imageViewRepository;

    public ViewServiceImpl(CardViewRepository cardViewRepository, ImageViewRepository imageViewRepository) {
        this.cardViewRepository = cardViewRepository;
        this.imageViewRepository = imageViewRepository;
    }

    @Override
    public CardView createCard(CardViewRequest cardViewRequest) {
        return cardViewRepository.save(CardView.builder()
            .title(cardViewRequest.getTitle())
            .cardContent(cardViewRequest.getCardContent())
            .icon(cardViewRequest.getIcon())
            .type(ViewType.valueOf(cardViewRequest.getType()))
        .build());
    }

    @Override
    public ImageView createImage(ImageViewRequest imageViewRequest) {
        return imageViewRepository.save(ImageView.builder()
            .image(imageViewRequest.getImage())
            .type(ViewType.valueOf(imageViewRequest.getType()))
        .build());
    }

    @Override
    public List<CardView> getSolutions() {
        return cardViewRepository.findSolutions();
    }

    @Override
    public List<CardView> getServices() {
        return cardViewRepository.findServices();
    }

    @Override
    public HomepageResponse getHomepage() {
        return HomepageResponse.builder()
            .sliders(imageViewRepository.findAllByType(ViewType.Carousel).stream().map(imageView -> imageView.getImage()).collect(Collectors.toList()))
            .companies(imageViewRepository.findAllByType(ViewType.Company).stream().map(imageView -> imageView.getImage()).collect(Collectors.toList()))
            .cards(cardViewRepository.findAll().stream().map(cardView -> CardViewHomepageResponse.builder()
                    .title(cardView.getTitle())
                    .icon(cardView.getIcon())
                    .build()).collect(Collectors.toList())
            )
        .build();
    }
}
