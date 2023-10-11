package com.esc.QuanLyAnCa.entities;

import com.esc.QuanLyAnCa.core.validate.PhoneNumber;
import com.esc.QuanLyAnCa.core.validate.ValidDate;
import com.esc.QuanLyAnCa.models.user.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @GeneratedValue(strategy = GenerationType.UUID)
    private String nhanVienId;
    @NotBlank(message = "thiếu nhanVienCode")
    @Size(min = 6, message = "mã nhân viên phải ít nhất 6 ký tự")
    @Column(name = "NhanVienCode")
    private String nhanVienCode;
    @NotBlank(message = "thiếu NhanVienName")
    @Size(min = 6, message = "tên nhân viên phải ít nhất 6 ký tự")
    @Column(name = "NhanVienName")
    private String nhanVienName;
    @NotBlank(message = "thiếu tên đăng nhập")
    @Size(min = 6, message = "Tên đăng nhập phải ít nhất 6 ký tự")
    @Column(name = "Username")
    private String username;
    @NotBlank(message = "thiếu password")
    @Size(min = 6, message = "password phải ít nhất 6 ký tự")
    @Column(name = "Password")
    private String password;
    @NotBlank(message = "thiếu quyền")
    @Column(name = "Quyen")
    private String quyen;
    @NotBlank(message = "thiếu trạng thái")
    @Column(name = "TrangThai")
    private Boolean trangThai;
    @NotBlank(message = "thiếu số điện thoại")
    @PhoneNumber(message = "số điện thoại không hợp lệ")
    @Column(name = "Phone")
    private String phone;
    @NotBlank(message = "thiếu email")
    @Email(message = "email không hợp lệ")
    @Column(name = "Email")
    private String email;
    @NotBlank(message = "thiếu nhanVienCode")
    @Size(min = 6, message = "Tên đăng nhập phải ít nhất 6 ký tự")
    @Column(name = "DiaChi")
    private String diaChi;
    @NotBlank(message = "thiếu ngày sinh")
    @ValidDate(message="định dạng ngày không hợp lệ")
    @Column(name = "NgaySinh")
    private LocalDateTime ngaySinh;
    @NotBlank(message = "thiếu phòng ban")
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
    @NotBlank(message = "thiếu role")
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
