package com.esc.QuanLyAnCa.dtos;

import lombok.Data;

import java.time.LocalDateTime;
       

@Data
public class SuatAnDTO {
    private String suatAnId;
    private String nhanVienId;
    private LocalDateTime createdDate;
    private String createdBy;
    private LocalDateTime modifiedDate;
    private String modifiedBy;
}
