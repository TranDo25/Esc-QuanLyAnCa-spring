package com.esc.QuanLyAnCa.models.thongke;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThongKeCaNhanModel {
    private String NgayDK;
    private int SoLuongCa1;
    private int SoLuongCa2;
    private int SoLuongCa3;
}
