package com.esc.QuanLyAnCa.models.thongke;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThongKeTheoNgayDTO {
    private String tenCa;
    private int tongSoSuat;
    private double tongTienTrongCa;
    private List<ItemThongKeTheoNgay> dsDky;
}
