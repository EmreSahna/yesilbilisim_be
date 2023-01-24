package org.yesilbilisim.website.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yesilbilisim.website.model.BlogInfoModel;
import org.yesilbilisim.website.model.MediumPostModel;
import org.yesilbilisim.website.service.BlogService;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/medium")
    public BlogInfoModel getMediumPosts() {
        return blogService.getUsersMedium();
    }
}
