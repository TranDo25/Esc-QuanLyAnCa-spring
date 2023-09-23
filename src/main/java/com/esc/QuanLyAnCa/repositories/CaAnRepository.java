package com.esc.QuanLyAnCa.repositories;

import com.esc.QuanLyAnCa.entities.CaAn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CaAnRepository extends JpaRepository<CaAn, String> {

}