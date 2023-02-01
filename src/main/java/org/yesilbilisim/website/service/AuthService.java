package org.yesilbilisim.website.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.yesilbilisim.website.dto.request.LoginRequest;
import org.yesilbilisim.website.dto.response.LoginResponse;
import org.yesilbilisim.website.dto.response.ValidateResponse;

@Service
public class AuthService {
    @Value("${admin.username}")
    private String username;

    @Value("${admin.password}")
    private String password;

    public LoginResponse loginAdmin(LoginRequest loginRequest) {
        if(!loginRequest.getUsername().equals(username) || !loginRequest.getPassword().equals(password)) {
            throw new RuntimeException("Login failed");
        }
        return LoginResponse.builder()
                .message("Başarıyla giriş yapıldı! Yönlendiriliyor...")
                .token("token")
                .build();
    }

    public ValidateResponse validateToken(String token) {
        if(!token.equals("Bearer token")){
            return ValidateResponse.builder()
                    .valid(false)
                    .build();
        }

        return ValidateResponse.builder()
                .valid(true)
                .build();
    }
}
