package org.yesilbilisim.backend.controller;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yesilbilisim.backend.dto.request.BlogRequest;
import org.yesilbilisim.backend.entity.Blogs.Blog;
import org.yesilbilisim.backend.service.AdminService;
import org.yesilbilisim.backend.service.BlogService;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;
    private final BlogService blogService;

    public AdminController(AdminService adminService, BlogService blogService) {
        this.adminService = adminService;
        this.blogService = blogService;
    }

    @GetMapping("/isvalid")
    public String isValid() {
        return "true";
    }

    @GetMapping("/mail")
    public ResponseEntity<Resource> getMailSection() {
        byte[] dosyaIcerigi = adminService.getMailSection();
        ByteArrayResource dosyaKaynak = new ByteArrayResource(dosyaIcerigi);

        return ResponseEntity.ok()
                .contentLength(dosyaIcerigi.length)
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .header("Content-Disposition", "attachment; filename=\"mails.txt\"")
                .body(dosyaKaynak);
    }

    @PostMapping("/blog")
    public ResponseEntity<Blog> createBlog(@RequestBody BlogRequest blogRequest) {
        return new ResponseEntity<>(blogService.createBlog(blogRequest), HttpStatus.CREATED);
    }
}
