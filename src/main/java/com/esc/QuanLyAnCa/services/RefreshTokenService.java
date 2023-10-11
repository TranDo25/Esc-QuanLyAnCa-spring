package com.esc.QuanLyAnCa.services;

import com.esc.QuanLyAnCa.security.model.RefreshToken;
import com.esc.QuanLyAnCa.repositories.NhanVienRepository;
import com.esc.QuanLyAnCa.repositories.RefreshTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class RefreshTokenService {
    @Autowired
    private RefreshTokenRepository refreshTokenRepository;
    @Autowired
    private NhanVienRepository nhanVienRepository;

    public RefreshToken createRefreshToken(String username) {
        RefreshToken refreshToken = RefreshToken.builder().nhanVien(nhanVienRepository.findByUsername(username).get())
                .token(UUID.randomUUID().toString())
                .expiryDate(LocalDateTime.now().plusMinutes(10))
                .build();
        return refreshTokenRepository.save(refreshToken);
    }

    public Optional<RefreshToken> findByToken(String token) {
        Optional<RefreshToken> byToken = refreshTokenRepository.findByToken(token);
        return byToken;
    }
    public RefreshToken verifyExpiration(RefreshToken token){
        if(token.getExpiryDate().compareTo(LocalDateTime.now())<0){
            refreshTokenRepository.delete(token);
            throw new RuntimeException(token.getToken()+" refresh token was expired. Please make a new sign in request");
        }
        return token;
    }
}
