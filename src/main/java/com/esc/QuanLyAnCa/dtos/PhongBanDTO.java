package com.esc.QuanLyAnCa.dtos;

import lombok.Data;

import java.time.LocalDateTime;
       

@Data
public class PhongBanDTO {
    private String phongBanId;
    private String phongBanCode;
    private String phongBanName;
    private LocalDateTime createdDate;
    private String createdBy;
    private LocalDateTime modifiedDate;
    private String modifiedBy;
}
