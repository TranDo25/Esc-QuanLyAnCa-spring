package com.esc.QuanLyAnCa.repositories;

import com.esc.QuanLyAnCa.models.thongke.ThongKeCaNhanColumn;
import com.esc.QuanLyAnCa.models.thongke.ThongKeCaNhanModel;
import com.esc.QuanLyAnCa.models.thongke.ThongKeTheoNgayModel;
import com.esc.QuanLyAnCa.models.thongke.ThongKeTheoThangColumn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class ThongKeRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<ThongKeCaNhanColumn> getThongKeCaAnCaNhan(Date startDate, Date endDate, String userId) throws ParseException {

        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("Sp_ThongKeSuatAnCaNhan")
                .declareParameters(new SqlParameter[]{
                        new SqlParameter("startDate", Types.DATE),
                        new SqlParameter("endDate", Types.DATE),
                        new SqlParameter("userId", Types.CHAR),


                })
                .returningResultSet("thongkecanhan", new RowMapper<ThongKeCaNhanColumn>() {
                    @Override
                    public ThongKeCaNhanColumn mapRow(ResultSet rs, int rowNum) throws SQLException {
                        ThongKeCaNhanColumn tmp = new ThongKeCaNhanColumn();
                        tmp.setNhanVienId(rs.getString("NhanVienId"));
                        tmp.setCreatedDate(rs.getDate("CreatedDate"));
                        tmp.setIDChiTietSuatAn(rs.getString("IDChiTietSuatAn"));
                        tmp.setSoLuong(rs.getInt("SoLuong"));
                        tmp.setSuatAnId(rs.getString("SuatAnId"));
                        tmp.setCaAnId(rs.getString("CaAnId"));


                        return tmp;
                    }

                });

        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("startDate", startDate);
        mapSqlParameterSource.addValue("endDate", endDate);
        mapSqlParameterSource.addValue("userId", userId);
        Map<String, Object> results = simpleJdbcCall.execute(mapSqlParameterSource);
        List<ThongKeCaNhanColumn> thongKeCaNhanModels = (List<ThongKeCaNhanColumn>) results.get("thongkecanhan");

        return thongKeCaNhanModels;

    }
    public List<ThongKeTheoNgayModel> getThongKeCaAnNgay(Date startDate, Date endDate) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("Sp_ThongKeCaAnNgay")
                .declareParameters(new SqlParameter[]{
                        new SqlParameter("DateStart", Types.DATE),
                        new SqlParameter("DateEnd", Types.DATE),

                })
                .returningResultSet("return_data", new RowMapper<ThongKeTheoNgayModel>() {
                    @Override
                    public ThongKeTheoNgayModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                        ThongKeTheoNgayModel tmp = new ThongKeTheoNgayModel();
                        tmp.setThongKeTheoNgayId(rs.getString("ThongKeTheoNgayId"));
                        tmp.setIdNguoiAn(rs.getString("IdNguoiAn"));
                        tmp.setSoLuong(rs.getInt("SoLuong"));
                        tmp.setSuatAnId(rs.getString("SuatAnId"));
                        tmp.setCaAnId(rs.getString("CaAnId"));
                        tmp.setID_NDK(rs.getString("ID_NDK"));
                        tmp.setCreatedDate(rs.getDate("CreatedDate"));
                        tmp.setHoTenNguoiAn(rs.getString("hoTenNguoiAn"));
                        tmp.setPhongBanId(rs.getString("PhongBanId"));
                        tmp.setPhongBanName(rs.getString("PhongBanName"));
                        tmp.setThoiGianBatDau(rs.getDate("ThoiGianBatDau"));
                        tmp.setThoiGianKetThuc(rs.getDate("ThoiGianKetThuc"));
                        return tmp;
                    }

                });


        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("DateStart", startDate);
        mapSqlParameterSource.addValue("DateEnd", endDate);
        Map<String, Object> results = simpleJdbcCall.execute(mapSqlParameterSource);
        List<ThongKeTheoNgayModel> thongKeTheoNgayModelList =
                (List<ThongKeTheoNgayModel>) results.get("return_data");

        return thongKeTheoNgayModelList;

    }

    public List<ThongKeTheoThangColumn> getThongKeTheoThang(int month, int year) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("Sp_ThongKeAnCaThang")
                .declareParameters(new SqlParameter[]{
                        new SqlParameter("Month", Types.INTEGER),
                        new SqlParameter("Year", Types.INTEGER),

                })
                .returningResultSet("return_data", new RowMapper<ThongKeTheoThangColumn>() {
                    @Override
                    public ThongKeTheoThangColumn mapRow(ResultSet rs, int rowNum) throws SQLException {
                        ThongKeTheoThangColumn tmp = new ThongKeTheoThangColumn();
                        tmp.setIDChiTietSuatAn(rs.getString("IDChiTietSuatAn"));
                        tmp.setIDNguoiAn(rs.getString("IDNguoiAn"));
                        tmp.setSoLuong(rs.getInt("SoLuong"));
                        tmp.setSuatAnId(rs.getString("SuatAnId"));
                        tmp.setCaAnId(rs.getString("CaAnId"));
                        tmp.setID_NDK(rs.getString("ID_NDK"));
                        tmp.setCreatedDate(rs.getDate("CreatedDate"));
                        tmp.setIDNhanVien(rs.getString("IDNhanVien"));
                        tmp.setHoTenNguoiAn(rs.getString("hoTenNguoiAn"));
                        tmp.setPhongBanId(rs.getString("PhongBanId"));
                        tmp.setThoiGianBatDau(rs.getDate("ThoiGianBatDau"));
                        tmp.setThoiGianKetThuc(rs.getDate("ThoiGianKetThuc"));
                        tmp.setPhongBanName(rs.getString("PhongBanName"));
                        return tmp;
                    }
                });


        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("Month", month);
        mapSqlParameterSource.addValue("Year", year);
        Map<String, Object> results = simpleJdbcCall.execute(mapSqlParameterSource);
        List<ThongKeTheoThangColumn> thongKeTheoThangColumnList =
                (List<ThongKeTheoThangColumn>) results.get("return_data");

        return thongKeTheoThangColumnList;
    }
}
