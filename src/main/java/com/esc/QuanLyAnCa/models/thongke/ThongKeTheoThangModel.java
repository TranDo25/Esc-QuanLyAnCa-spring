package com.esc.QuanLyAnCa.models.thongke;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThongKeTheoThangModel {
    private String PhongBanName;
    private double TongTienCaPhong;
   private List<ItemThongKeTheoThang> DsThongKe;
}