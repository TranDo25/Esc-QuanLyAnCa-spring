package com.esc.QuanLyAnCa.services;

import com.esc.QuanLyAnCa.entities.CaAn;
import com.esc.QuanLyAnCa.models.dangkycaan.DangKyCaNhanModel;
import com.esc.QuanLyAnCa.models.dangkycaan.DangKyTapTheModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;
       

public interface CaAnService {

    CaAn save(CaAn caan);

    Optional<CaAn> find(String id);

    List<CaAn> findAll();

    List<CaAn> findAll(Sort sort);

    Page<CaAn> findAll(Pageable pageable);

    void delete(String id);

    void delete(CaAn caan);

    void deleteAll();

    long count();

    void dangkycanhanHandler(DangKyCaNhanModel data);

    void dangkytaptheHandler(DangKyTapTheModel data);
}