package org.yesilbilisim.backend.controller;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yesilbilisim.backend.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
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
}
