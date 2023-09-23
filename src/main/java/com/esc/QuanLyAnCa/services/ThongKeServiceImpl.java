package com.esc.QuanLyAnCa.services;

import com.esc.QuanLyAnCa.models.thongke.*;
import com.esc.QuanLyAnCa.repositories.NhanVienRepository;
import com.esc.QuanLyAnCa.repositories.ThongKeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Service
public class ThongKeServiceImpl implements ThongKeService {

    @Autowired
    private ThongKeRepository thongKeRepository;
    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Override
    public List<ThongKeTheoNgayDTO> getInfoThongKeTheoNgay(Date startDate, Date endDate) {
        List<ThongKeTheoNgayModel> data = thongKeRepository.getThongKeCaAnNgay(startDate, endDate);
        List<ThongKeTheoNgayDTO> res = new ArrayList<>();
        ThongKeTheoNgayDTO tmp = new ThongKeTheoNgayDTO();
        String Ca1Id = "11452b0c-768e-5ff7-0d63-eeb1d8ed8cef";
        tmp.setTenCa("Ca 1");
        int totalMeals = 0;
        double totalMoneys = 0;
        List<ItemThongKeTheoNgay> listDky = new ArrayList<>();
        for (ThongKeTheoNgayModel item : data) {
            ItemThongKeTheoNgay tmp2 = new ItemThongKeTheoNgay();
            if (item.getCaAnId().equals(Ca1Id)) {
                if(item.getSoLuong() == 0) continue;
                tmp2.setHoTen(item.getHoTenNguoiAn());
                tmp2.setSoLuong(item.getSoLuong());

                totalMeals += item.getSoLuong();
                tmp2.setThanhTien(item.getSoLuong() * 25000);
                totalMoneys += tmp2.getThanhTien();
                listDky.add(tmp2);
            }

        }
        tmp.setDsDky(listDky);
        tmp.setTongSoSuat(totalMeals);
        tmp.setTongTienTrongCa(totalMoneys);
        if (totalMeals > 0) {
            res.add(tmp);

        }


        //==================Ca 2========================
        tmp = new ThongKeTheoNgayDTO();
        String Ca2Id = "142cb08f-7c31-21fa-8e90-67245e8b283e";
        tmp.setTenCa("Ca 2");
        totalMeals = 0;
        totalMoneys = 0;
        listDky = new ArrayList<>();
        for (ThongKeTheoNgayModel item : data) {
            ItemThongKeTheoNgay tmp2 = new ItemThongKeTheoNgay();
            if (item.getCaAnId().equals(Ca2Id)) {
                if(item.getSoLuong() == 0) continue;

                tmp2.setHoTen(item.getHoTenNguoiAn());
                tmp2.setSoLuong(item.getSoLuong());
                totalMeals += item.getSoLuong();
                tmp2.setThanhTien(item.getSoLuong() * 25000);
                totalMoneys += tmp2.getThanhTien();
                listDky.add(tmp2);
            }


        }
        tmp.setDsDky(listDky);
        tmp.setTongSoSuat(totalMeals);
        tmp.setTongTienTrongCa(totalMoneys);
        if (totalMeals > 0) {
            res.add(tmp);

        }

//==================Ca 3=================
        tmp = new ThongKeTheoNgayDTO();
        String Ca3Id = "17120d02-6ab5-3e43-18cb-66948daf6128";
        tmp.setTenCa("Ca 3");
        totalMeals = 0;
        totalMoneys = 0;
        listDky = new ArrayList<>();
        for (ThongKeTheoNgayModel item : data) {
            ItemThongKeTheoNgay tmp2 = new ItemThongKeTheoNgay();

            if (item.getCaAnId().equals(Ca3Id)) {
                if(item.getSoLuong() == 0) continue;

                tmp2.setHoTen(item.getHoTenNguoiAn());
                tmp2.setSoLuong(item.getSoLuong());
                totalMeals += item.getSoLuong();
                tmp2.setThanhTien(item.getSoLuong() * 25000);
                totalMoneys += tmp2.getThanhTien();
                listDky.add(tmp2);
            }


        }
        tmp.setDsDky(listDky);
        tmp.setTongSoSuat(totalMeals);
        tmp.setTongTienTrongCa(totalMoneys);
        if (totalMeals > 0) {
            res.add(tmp);

        }

        return res;
    }

    @Override
    public List<ThongKeCaNhanModel> getInfoThongKeCaNhan(Date startDate, Date endDate, String userId) throws ParseException {
        List<ThongKeCaNhanColumn> data = thongKeRepository.getThongKeCaAnCaNhan(startDate, endDate, userId);
        List<ThongKeCaNhanModel> res = new ArrayList<>();
        HashSet<String> hashSetNgayDky = new HashSet<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//tạo bộ ngày riêng biệt để lọc theo ngày
        for (ThongKeCaNhanColumn item : data) {
            Date dateTmp = item.getCreatedDate();
            String ngayThangNam = dateFormat.format(dateTmp);
            hashSetNgayDky.add(ngayThangNam);
        }
        for (String uniqueNgayThangNam : hashSetNgayDky) {
            ThongKeCaNhanModel itemInRes = new ThongKeCaNhanModel();
            int SoLuongCa1 = 0;
            int SoLuongCa2 = 0;
            int SoLuongCa3 = 0;
            itemInRes.setNgayDK(uniqueNgayThangNam);
            for (ThongKeCaNhanColumn item : data) {
                Date dateTmp = item.getCreatedDate();
                String ngayThangNam = dateFormat.format(dateTmp);
                if (ngayThangNam.equals(uniqueNgayThangNam)) {
                    switch (item.getCaAnId()) {
                        case "11452b0c-768e-5ff7-0d63-eeb1d8ed8cef":
                            SoLuongCa1 += item.getSoLuong();
                            break;
                        case "17120d02-6ab5-3e43-18cb-66948daf6128":
                            SoLuongCa2 += item.getSoLuong();
                            break;
                        case "142cb08f-7c31-21fa-8e90-67245e8b283e":
                            SoLuongCa3 += item.getSoLuong();
                            break;
                    }
                }
            }
            itemInRes.setSoLuongCa1(SoLuongCa1);
            itemInRes.setSoLuongCa2(SoLuongCa2);
            itemInRes.setSoLuongCa3(SoLuongCa3);


            res.add(itemInRes);
        }


        return res;
    }

    @Override
    public List<ThongKeTheoThangModel> getInfoThongKeTheoThang(int month, int year) {
        List<ThongKeTheoThangColumn> data = thongKeRepository.getThongKeTheoThang(month, year);
        List<ThongKeTheoThangModel> res = new ArrayList<>();
        HashSet<String> dsPhongBanName = new HashSet<>();
        for (ThongKeTheoThangColumn item : data) {
            dsPhongBanName.add(item.getPhongBanName());
        }
        for (String itemPhongBanName : dsPhongBanName) {
            //trong vòng for này duyệt từng phòng ban
            List<ItemThongKeTheoThang> dsThongKe = new ArrayList<>();
            double tongTienCaPhong = 0;
            HashSet<String> dsIdNhanVien = new HashSet<>();
            for (ThongKeTheoThangColumn item : data) {
                if (item.getPhongBanName().equals(itemPhongBanName)) {
                    dsIdNhanVien.add(item.getIDNhanVien());
                }
            }

            //có được hashset tên các nhân viên thuộc vào phòng ban đó, bây giò
            //cần duyệt lại trong danh sách data để với mỗi tên nhân viên, tính
            //tổng số lượng ca 1, ca 2, ca 3
            //muốn tính tổng được thì phải đi qua danh sách data nhiều lần

            for (String itemIdNhanVien : dsIdNhanVien) {
                int tongSoCa1 = 0;
                int tongSoCa2 = 0;
                int tongSoCa3 = 0;
                ItemThongKeTheoThang itemThongKeTheoThang = new ItemThongKeTheoThang();
                String NhanVienNameTmp = "";
                for (ThongKeTheoThangColumn item : data) {
                    if (itemIdNhanVien.equals(item.getIDNhanVien())) {
                        switch (item.getCaAnId()) {
                            case "11452b0c-768e-5ff7-0d63-eeb1d8ed8cef":
                                tongSoCa1 += item.getSoLuong();
                                break;
                            case "142cb08f-7c31-21fa-8e90-67245e8b283e":
                                tongSoCa2 += item.getSoLuong();
                                break;
                            case "17120d02-6ab5-3e43-18cb-66948daf6128":
                                tongSoCa3 += item.getSoLuong();
                                break;
                        }
                    }
                }
                //set ItemThongKeTheoThang
                itemThongKeTheoThang.setHoTen(String.valueOf(nhanVienRepository.findById(itemIdNhanVien).get().getNhanVienName()));
                itemThongKeTheoThang.setSlCa1(tongSoCa1);
                itemThongKeTheoThang.setSlCa2(tongSoCa2);
                itemThongKeTheoThang.setSlCa3(tongSoCa3);
                itemThongKeTheoThang.setTongSoLuong(tongSoCa1 + tongSoCa2 + tongSoCa3);
                itemThongKeTheoThang.setThanhTien(itemThongKeTheoThang.getTongSoLuong() * 25000);
                tongTienCaPhong += itemThongKeTheoThang.getThanhTien();
//xong đoạn này là tính được 1 ItemThongKeTheoThang, cần nạp n vào model cấp giữa
                //đoạn này là tính được 1 hàng

                //danh sách này sẽ được tạo mới khi duyệt đến từng phòng ban một
                //tại đây chỉ có id nhân viên là chung
                dsThongKe.add(itemThongKeTheoThang);


            }
            //xong vòng for trên là lấy ra được thông tin của 1 phòng ban
            //cần phải hoàn thiện model để lưu vào res
            //chỗ này các item dựa vào phòng ban
            ThongKeTheoThangModel thongKeTheoThangModel = new ThongKeTheoThangModel();
            thongKeTheoThangModel.setPhongBanName(itemPhongBanName);
            thongKeTheoThangModel.setTongTienCaPhong(tongTienCaPhong);
            thongKeTheoThangModel.setDsThongKe(dsThongKe);
            res.add(thongKeTheoThangModel);
        }
        return res;

    }
}
