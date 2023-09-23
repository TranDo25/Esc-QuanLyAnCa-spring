package com.esc.QuanLyAnCa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Table(name = "ChiTietSuatAn")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChiTietSuatAn {
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    @Column(name = "ChiTietSuatAnId")
    private String chiTietSuatAnId;

    @Column(name = "NhanVienId")
    private String nhanVienId;

    @Column(name = "SoLuong")
    private Integer soLuong;

    @Column(name = "SuatAnId")
    private String suatAnId;

    @Column(name = "CaAnId")
    private String caAnId;

    @Column(name = "CreatedDate")
    @CreatedDate
    private Date createdDate;

    @Column(name = "CreatedBy")
    private String createdBy;

    @Column(name = "ModifiedDate")
    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @Column(name = "ModifiedBy")
    private String modifiedBy;

  }
