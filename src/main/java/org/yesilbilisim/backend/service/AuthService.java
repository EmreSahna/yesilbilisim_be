package org.yesilbilisim.backend.service;

import org.yesilbilisim.backend.dto.request.LoginRequest;
import org.yesilbilisim.backend.dto.response.TokenResponse;

public interface AuthService {
    TokenResponse authenticate(LoginRequest request);
}