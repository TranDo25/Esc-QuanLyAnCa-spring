package com.esc.QuanLyAnCa.security.auth;

import com.esc.QuanLyAnCa.dtos.JwtResponse;
import com.esc.QuanLyAnCa.entities.NhanVien;
import com.esc.QuanLyAnCa.security.model.RefreshToken;
import com.esc.QuanLyAnCa.models.user.Role;
import com.esc.QuanLyAnCa.repositories.NhanVienRepository;
import com.esc.QuanLyAnCa.security.config.JwtService;
import com.esc.QuanLyAnCa.security.model.AuthenticationRequest;
import com.esc.QuanLyAnCa.security.model.AuthenticationResponse;
import com.esc.QuanLyAnCa.security.model.RegisterRequest;
import com.esc.QuanLyAnCa.services.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final NhanVienRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    @Autowired
    private RefreshTokenService refreshTokenService;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = NhanVien.builder()
                .nhanVienName(request.getFullname())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public JwtResponse authenticate(AuthenticationRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        if (authentication.isAuthenticated()) {
            RefreshToken refreshToken = refreshTokenService.createRefreshToken(request.getUsername());
            var user = repository.findByUsername(request.getUsername())
                    .orElseThrow();
            var jwtToken = jwtService.generateToken(user);
            return JwtResponse.builder()
                    .accessToken(jwtToken)
                    .token(refreshToken.getToken()).build();
        }


        return null;
    }

    public boolean verifyToken(String token) {
        return jwtService.isTokenExpired(token);
    }
}
