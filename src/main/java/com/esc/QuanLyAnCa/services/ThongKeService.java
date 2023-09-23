package com.esc.QuanLyAnCa.services;

import com.esc.QuanLyAnCa.models.thongke.ThongKeCaNhanModel;
import com.esc.QuanLyAnCa.models.thongke.ThongKeTheoNgayDTO;
import com.esc.QuanLyAnCa.models.thongke.ThongKeTheoThangModel;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface ThongKeService {
    List<ThongKeTheoNgayDTO> getInfoThongKeTheoNgay(Date startDate, Date endDate);

    List<ThongKeCaNhanModel> getInfoThongKeCaNhan(Date startDate, Date endDate,String userId) throws ParseException;

    List<ThongKeTheoThangModel> getInfoThongKeTheoThang(int month, int year);
}
