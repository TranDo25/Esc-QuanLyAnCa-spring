package com.esc.QuanLyAnCa.dtos;

import lombok.Data;

import java.time.LocalDateTime;
       

@Data
public class ChiTietSuatAnDTO {
    private String chiTietSuatAnId;
    private String nhanVienId;
    private Integer soLuong;
    private String suatAnId;
    private String caAnId;
    private LocalDateTime createdDate;
    private String createdBy;
    private LocalDateTime modifiedDate;
    private String modifiedBy;
}
