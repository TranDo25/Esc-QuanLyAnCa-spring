package com.esc.QuanLyAnCa.security.model;

import com.esc.QuanLyAnCa.entities.NhanVien;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RefreshToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String token;
    private LocalDateTime expiryDate;
    @OneToOne
    @JoinColumn(name="user_id", referencedColumnName = "nhanVienId")
    private NhanVien nhanVien;

}
