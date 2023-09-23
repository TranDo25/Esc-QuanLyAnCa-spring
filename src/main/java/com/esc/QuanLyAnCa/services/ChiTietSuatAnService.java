package com.esc.QuanLyAnCa.services;

import com.esc.QuanLyAnCa.entities.ChiTietSuatAn;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface ChiTietSuatAnService {

    ChiTietSuatAn save(ChiTietSuatAn chitietsuatan);

    Optional<ChiTietSuatAn> find(String id);

    List<ChiTietSuatAn> findAll();

    List<ChiTietSuatAn> findAll(List<String> ids);

    List<ChiTietSuatAn> findAll(Sort sort);

    Page<ChiTietSuatAn> findAll(Pageable pageable);

    void delete(String id);

    void delete(List<ChiTietSuatAn> chitietsuatan);

    void delete(ChiTietSuatAn chitietsuatan);

    void deleteAll();

    long count();

}