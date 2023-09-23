package com.esc.QuanLyAnCa.services;

import com.esc.QuanLyAnCa.entities.SuatAn;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;
       
public interface SuatAnService {

    SuatAn save(SuatAn suatan);

    Optional<SuatAn> find(String id);

    List<SuatAn> findAll();

    List<SuatAn> findAll(Sort sort);

    Page<SuatAn> findAll(Pageable pageable);

    void delete(String id);

    void delete(SuatAn suatan);

    void deleteAll();

    long count();

}