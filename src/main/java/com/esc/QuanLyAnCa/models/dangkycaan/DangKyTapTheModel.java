package com.esc.QuanLyAnCa.models.dangkycaan;

import com.esc.QuanLyAnCa.entities.NhanVien;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DangKyTapTheModel {
    private String idNhanVien;
    private ArrayList<DangKyCaNhanModel> danhSachDangKy = new ArrayList<>();

}
