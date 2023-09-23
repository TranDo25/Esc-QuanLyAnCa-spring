package com.esc.QuanLyAnCa.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
       

@Entity
@Table(name = "CaAn")
@Data
public class CaAn {
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    @Column(name = "CaAnId")
    private String caAnId;
    @Column(name = "CaAnCode")
    private String caAnCode;

    @Column(name = "ThoiGianBatDau")
    private LocalDateTime thoiGianBatDau;

    @Column(name = "ThoiGianKetThuc")
    private LocalDateTime thoiGianKetThuc;

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
