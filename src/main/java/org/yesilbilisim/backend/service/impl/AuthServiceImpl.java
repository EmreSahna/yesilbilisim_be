package org.yesilbilisim.backend.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.yesilbilisim.backend.dto.request.LoginRequest;
import org.yesilbilisim.backend.dto.response.TokenResponse;
import org.yesilbilisim.backend.security.User;
import org.yesilbilisim.backend.service.AuthService;
import org.yesilbilisim.backend.service.JwtService;

@Service
public class AuthServiceImpl implements AuthService {
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthServiceImpl(JwtService jwtService, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public TokenResponse authenticate(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        var jwtToken = jwtService.generateToken(user);
        return TokenResponse.builder()
                .token(jwtToken)
                .build();
    }
}
