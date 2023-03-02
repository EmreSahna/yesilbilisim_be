package org.yesilbilisim.backend.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yesilbilisim.backend.dto.request.BlogRequest;
import org.yesilbilisim.backend.dto.response.BlogResponse;
import org.yesilbilisim.backend.dto.response.BlogResponseWithPaggination;
import org.yesilbilisim.backend.dto.response.BlogsNavigatorResponse;
import org.yesilbilisim.backend.dto.response.BlogsResponse;
import org.yesilbilisim.backend.entity.Blogs.Blog;
import org.yesilbilisim.backend.service.BlogService;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/id/{blogId}")
    public ResponseEntity<BlogResponse> getBlogById(@PathVariable String blogId) {
        return new ResponseEntity<>(blogService.getBlog(blogId), HttpStatus.OK);
    }

    @GetMapping("/id/all")
    public ResponseEntity<BlogResponseWithPaggination> getBlogs(Pageable pageable) {
        return new ResponseEntity<>(blogService.getBlogs(pageable), HttpStatus.OK);
    }

    @GetMapping("/navigator")
    public ResponseEntity<List<BlogsNavigatorResponse>> getBlogsNavigator(){
        return new ResponseEntity<>(blogService.getBlogsNavigator(), HttpStatus.OK);
    }

}
