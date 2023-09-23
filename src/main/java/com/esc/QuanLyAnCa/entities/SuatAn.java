package com.esc.QuanLyAnCa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Table(name = "SuatAn")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SuatAn {
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    @Column(name = "SuatAnId")
    private String suatAnId;

    @Column(name = "NhanVienId")
    private String nhanVienId;

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
