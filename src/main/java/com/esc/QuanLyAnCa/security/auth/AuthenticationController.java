package com.esc.QuanLyAnCa.security.auth;

import com.esc.QuanLyAnCa.dtos.JwtResponse;
import com.esc.QuanLyAnCa.security.config.JwtService;
import com.esc.QuanLyAnCa.security.model.*;
import com.esc.QuanLyAnCa.services.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;
    @Autowired
    private RefreshTokenService refreshTokenService;
    @Autowired
    private JwtService jwtService;

    @PostMapping("/refreshToken")
    public JwtResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
       return  refreshTokenService.findByToken(refreshTokenRequest.getToken())
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshToken::getNhanVien)
                .map(nhanVien -> {
                    String accessToken = jwtService.generateToken(nhanVien);
                    return JwtResponse.builder()
                            .accessToken(accessToken)
                            .token(refreshTokenRequest.getToken())
                            .build();
                }).orElseThrow(()->new RuntimeException(
                        "Refresh token is not in database"
               ));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<JwtResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @GetMapping("/verifyToken")
    public ResponseEntity<Boolean> authorization(
            @RequestBody String token
    ) {
        return ResponseEntity.ok(service.verifyToken(token));
    }
}
