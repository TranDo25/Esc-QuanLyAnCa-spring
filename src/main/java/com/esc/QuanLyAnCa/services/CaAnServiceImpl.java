package com.esc.QuanLyAnCa.services;

import com.esc.QuanLyAnCa.entities.CaAn;
import com.esc.QuanLyAnCa.entities.ChiTietSuatAn;
import com.esc.QuanLyAnCa.entities.SuatAn;
import com.esc.QuanLyAnCa.models.dangkycaan.DangKyCaNhanModel;
import com.esc.QuanLyAnCa.models.dangkycaan.DangKyTapTheModel;
import com.esc.QuanLyAnCa.repositories.CaAnRepository;
import com.esc.QuanLyAnCa.repositories.ChiTietSuatAnRepository;
import com.esc.QuanLyAnCa.repositories.SuatAnRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class CaAnServiceImpl implements CaAnService {

    @Autowired
    private CaAnRepository caanRepository;
    @Autowired
    private SuatAnRepository suatAnRepository;
    @Autowired
    private ChiTietSuatAnRepository chiTietSuatAnRepository;


    @Override
    public CaAn save(CaAn caan) {
        return caanRepository.save(caan);
    }

    @Override
    public Optional<CaAn> find(String id) {
        return caanRepository.findById(id);
    }

    @Override
    public List<CaAn> findAll() {
        return caanRepository.findAll();
    }

    @Override
    public List<CaAn> findAll(Sort sort) {
        return caanRepository.findAll(sort);
    }

    @Override
    public Page<CaAn> findAll(Pageable pageable) {
        return caanRepository.findAll(pageable);
    }

    @Override
    public void delete(String id) {
        caanRepository.deleteById(id);
    }

    @Override
    public void delete(CaAn caan) {
        caanRepository.delete(caan);
    }

    @Override
    public void deleteAll() {
        caanRepository.deleteAll();
    }

    @Override
    public long count() {
        return caanRepository.count();
    }

    @Override
    @Transactional
    public void dangkycanhanHandler(DangKyCaNhanModel data) {
        SuatAn suatAn = SuatAn.builder().nhanVienId(data.getIdNhanVien()).createdDate(new Date()).build();
        SuatAn suatAnSaved = suatAnRepository.save(suatAn);
        //lưu ca 1
        ChiTietSuatAn chiTietSuatAnCa1 = ChiTietSuatAn.builder()
                .nhanVienId(data.getIdNhanVien())
                .soLuong(data.getSoLuongCa1())
                .suatAnId(suatAnSaved.getSuatAnId())
                .caAnId("11452b0c-768e-5ff7-0d63-eeb1d8ed8cef")
                .createdDate(new Date())
                .build();
        chiTietSuatAnRepository.save(chiTietSuatAnCa1);
        //lưu ca 2
        ChiTietSuatAn chiTietSuatAnCa2 = ChiTietSuatAn.builder()
                .nhanVienId(data.getIdNhanVien())
                .soLuong(data.getSoLuongCa2())
                .suatAnId(suatAnSaved.getSuatAnId())
                .createdDate(new Date())
                .caAnId("142cb08f-7c31-21fa-8e90-67245e8b283e").build();
        chiTietSuatAnRepository.save(chiTietSuatAnCa2);
        //lưu ca 3
        ChiTietSuatAn chiTietSuatAnCa3 = ChiTietSuatAn.builder()
                .nhanVienId(data.getIdNhanVien())
                .soLuong(data.getSoLuongCa3())
                .suatAnId(suatAnSaved.getSuatAnId())
                .createdDate(new Date())
                .caAnId("17120d02-6ab5-3e43-18cb-66948daf6128").build();
        chiTietSuatAnRepository.save(chiTietSuatAnCa3);
    }

    @Override
    @Transactional
    public void dangkytaptheHandler(DangKyTapTheModel data) {
        SuatAn suatAn = SuatAn.builder().nhanVienId(data.getIdNhanVien()).createdDate(new Date()).build();
        SuatAn suatAnSaved = suatAnRepository.save(suatAn);
        for(DangKyCaNhanModel item: data.getDanhSachDangKy()){
            ChiTietSuatAn chiTietSuatAnCa1 = ChiTietSuatAn.builder()
                    .nhanVienId(item.getIdNhanVien())
                    .soLuong(item.getSoLuongCa1())
                    .suatAnId(suatAnSaved.getSuatAnId())
                    .createdDate(new Date())
                    .caAnId("11452b0c-768e-5ff7-0d63-eeb1d8ed8cef").build();

            chiTietSuatAnRepository.save(chiTietSuatAnCa1);
            //lưu ca 2
            ChiTietSuatAn chiTietSuatAnCa2 = ChiTietSuatAn.builder()
                    .nhanVienId(item.getIdNhanVien())
                    .soLuong(item.getSoLuongCa2())
                    .suatAnId(suatAnSaved.getSuatAnId())
                    .createdDate(new Date())
                    .caAnId("142cb08f-7c31-21fa-8e90-67245e8b283e").build();
            chiTietSuatAnRepository.save(chiTietSuatAnCa2);

            //lưu ca 3
            ChiTietSuatAn chiTietSuatAnCa3 = ChiTietSuatAn.builder()
                    .nhanVienId(item.getIdNhanVien())
                    .soLuong(item.getSoLuongCa3())
                    .suatAnId(suatAnSaved.getSuatAnId())
                    .createdDate(new Date())
                    .caAnId("17120d02-6ab5-3e43-18cb-66948daf6128").build();
            chiTietSuatAnRepository.save(chiTietSuatAnCa3);
        }
    }

}