package com.esc.QuanLyAnCa.entities;

import jakarta.persistence.*;
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

    @Column(name = "PhongBanCode")
    private String phongBanCode;

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
