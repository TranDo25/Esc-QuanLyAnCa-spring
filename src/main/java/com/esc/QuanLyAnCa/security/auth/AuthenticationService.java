package com.esc.QuanLyAnCa.security.auth;

import com.esc.QuanLyAnCa.entities.NhanVien;
import com.esc.QuanLyAnCa.models.user.Role;
import com.esc.QuanLyAnCa.repositories.NhanVienRepository;
import com.esc.QuanLyAnCa.security.config.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final NhanVienRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
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

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword())
        );
        var user  = repository.findByUsername(request.getUsername())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();

    }

    public boolean verifyToken(String token) {
        return jwtService.isTokenExpired(token);
    }
}
