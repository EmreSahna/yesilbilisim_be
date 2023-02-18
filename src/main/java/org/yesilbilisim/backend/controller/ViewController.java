package org.yesilbilisim.backend.controller;

import org.springframework.web.bind.annotation.*;
import org.yesilbilisim.backend.dto.request.CardViewRequest;
import org.yesilbilisim.backend.dto.request.ImageViewRequest;
import org.yesilbilisim.backend.dto.response.CardPageResponse;
import org.yesilbilisim.backend.dto.response.CardViewResponse;
import org.yesilbilisim.backend.dto.response.HomepageResponse;
import org.yesilbilisim.backend.entity.Views.CardView;
import org.yesilbilisim.backend.entity.Views.ImageView;
import org.yesilbilisim.backend.service.ViewService;

import java.util.List;

@RestController
@RequestMapping("/view")
public class ViewController {
    private final ViewService viewService;

    public ViewController(ViewService viewService) {
        this.viewService = viewService;
    }

    @PostMapping("/create-card")
    public CardView createCard(@RequestBody CardViewRequest cardViewRequest) {
        return viewService.createCard(cardViewRequest);
    }

    @PostMapping("/create-image")
    public ImageView createImage(@RequestBody ImageViewRequest imageViewRequest) {
        return viewService.createImage(imageViewRequest);
    }

    @GetMapping("/solutions")
    public List<CardViewResponse> getSolutions() {
        return viewService.getSolutions();
    }

    @GetMapping("/services")
    public List<CardViewResponse> getServices() {
        return viewService.getServices();
    }

    @GetMapping("/homepage")
    public HomepageResponse getHomepage() {
        return viewService.getHomepage();
    }

    @GetMapping("/card/{id}")
    public CardPageResponse getService(@PathVariable String id) {
        return viewService.getCardView(id);
    }
}
