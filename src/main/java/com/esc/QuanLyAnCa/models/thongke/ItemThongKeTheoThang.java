package com.esc.QuanLyAnCa.models.thongke;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemThongKeTheoThang {
    private String HoTen;
    private int SlCa1;
    private int SlCa2;
    private int SlCa3;
    private int TongSoLuong;
    private double ThanhTien;

}
