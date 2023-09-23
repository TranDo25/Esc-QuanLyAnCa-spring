package com.esc.QuanLyAnCa.dtos;

import lombok.Data;

import java.time.LocalDateTime;
       

@Data
public class NhanVienDTO {
    private String nhanVienId;
    private String nhanVienCode;
    private String nhanVienName;
    private String username;
    private String password;
    private String quyen;
    private Boolean trangThai;
    private String phone;
    private String email;
    private String diaChi;
    private LocalDateTime ngaySinh;
    private String phongBanId;
    private String roleId;
    private LocalDateTime createdDate;
    private String createdBy;
    private LocalDateTime modifiedDate;
    private String modifiedBy;
}
