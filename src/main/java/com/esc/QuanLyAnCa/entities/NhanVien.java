package com.esc.QuanLyAnCa.entities;

import com.esc.QuanLyAnCa.models.user.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;


@Entity
@Table(name = "NhanVien")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class NhanVien implements UserDetails {
    @Id
    @Column(name = "NhanVienId")
    @GeneratedValue(strategy=GenerationType.UUID)
    private String nhanVienId;

    @Column(name = "NhanVienCode")
    private String nhanVienCode;

    @Column(name = "NhanVienName")
    private String nhanVienName;

    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "Quyen")
    private String quyen;

    @Column(name = "TrangThai")
    private Boolean trangThai;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Email")
    private String email;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "NgaySinh")
    private LocalDateTime ngaySinh;

    @Column(name = "PhongBanId")
    private String phongBanId;


    @Column(name = "CreatedDate")
    @CreatedDate
    private LocalDateTime createdDate;

    @Column(name = "CreatedBy")
    private String createdBy;

    @Column(name = "ModifiedDate")
    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @Column(name = "ModifiedBy")
    private String modifiedBy;
    @Column(name = "Role")
    @Enumerated(EnumType.STRING)
    private Role role;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return this.username;
    }
    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
