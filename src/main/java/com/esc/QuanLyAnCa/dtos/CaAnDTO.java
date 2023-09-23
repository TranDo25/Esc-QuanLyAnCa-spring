package com.esc.QuanLyAnCa.dtos;

import lombok.Data;

import java.time.LocalDateTime;
       

@Data
public class CaAnDTO {
    private String caAnId;
    private LocalDateTime thoiGianBatDau;
    private LocalDateTime thoiGianKetThuc;
    private LocalDateTime createdDate;
    private String createdBy;
    private LocalDateTime modifiedDate;
    private String modifiedBy;
}
