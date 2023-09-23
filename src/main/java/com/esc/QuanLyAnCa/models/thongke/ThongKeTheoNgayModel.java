package com.esc.QuanLyAnCa.models.thongke;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThongKeTheoNgayModel {
    private String ThongKeTheoNgayId;
    private String IdNguoiAn;
    private int SoLuong;
    private String SuatAnId;
    private String CaAnId;
    private String ID_NDK;
    private Date CreatedDate;
    private String hoTenNguoiAn;
    private String PhongBanId;
    private String PhongBanName;
    private Date ThoiGianBatDau;
    private Date ThoiGianKetThuc;

}
