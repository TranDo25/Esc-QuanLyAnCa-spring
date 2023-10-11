package com.esc.QuanLyAnCa.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
       

@Entity
@Table(name = "PhongBan")
@Data
public class PhongBan {
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    @Column(name = "PhongBanId")
    private String phongBanId;
    @NotBlank(message = "thiếu mã phòng ban")
    @Size(min = 6, message = "mã phòng ban tối thiểu 6 ký tự")
    @Column(name = "PhongBanCode")
    private String phongBanCode;
    @NotBlank(message = "thiếu tên phòng ban")
    @Size(min = 6, message = "tên phòng ban tối thiểu 6 ký tự")
    @Column(name = "PhongBanName")
    private String phongBanName;

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

   }
