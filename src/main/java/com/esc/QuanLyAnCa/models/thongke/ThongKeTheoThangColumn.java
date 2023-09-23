package com.esc.QuanLyAnCa.models.thongke;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThongKeTheoThangColumn {
    private String IDChiTietSuatAn;
    private String IDNguoiAn;
    private int SoLuong;
    private String SuatAnId;
    private String CaAnId;
    private String ID_NDK;
    private Date CreatedDate;
    private String IDNhanVien;
    private String hoTenNguoiAn;
    private String PhongBanId;
    private Date ThoiGianBatDau;
    private Date ThoiGianKetThuc;
    private String PhongBanName;
}
