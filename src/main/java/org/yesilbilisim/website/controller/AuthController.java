package org.yesilbilisim.website.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yesilbilisim.website.dto.request.LoginRequest;
import org.yesilbilisim.website.dto.response.LoginResponse;
import org.yesilbilisim.website.dto.response.ValidateResponse;
import org.yesilbilisim.website.service.AuthService;

@RestController
@RequestMapping("/login")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/user")
    public ResponseEntity<LoginResponse> loginAdmin(@RequestBody LoginRequest loginRequest){
        return new ResponseEntity(authService.loginAdmin(loginRequest), HttpStatus.OK);
    }

    @GetMapping("/validate")
    public ResponseEntity<ValidateResponse> validateToken(@RequestHeader("Authorization") String token){
        return new ResponseEntity(authService.validateToken(token), HttpStatus.OK);
    }
}
