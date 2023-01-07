package org.yesilbilisim.website.config;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.yesilbilisim.website.model.ImageModel;
import org.yesilbilisim.website.repository.ImageRepository;

@Component
@AllArgsConstructor
public class MyRunner implements CommandLineRunner {
    private final ImageRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();

        repository.save(ImageModel.builder()
                .name("logo")
                .path("img/logo.png")
                .build());

        repository.save(ImageModel.builder()
                .name("logo")
                .path("img/logo_2.png")
                .build());
    }
}