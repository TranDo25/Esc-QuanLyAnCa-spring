package com.esc.QuanLyAnCa.models.thongke;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThongKeCaNhanColumn {
    private String NhanVienId;
    private Date CreatedDate;
    private String IDChiTietSuatAn;
    private int SoLuong;
    private String SuatAnId;
    private String CaAnId;
}
