package com.esc.QuanLyAnCa.models.dangkycaan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DangKyCaNhanModel {
    private String idNhanVien;
    private int soLuongCa1;
    private int soLuongCa2;
    private int soLuongCa3;
}
