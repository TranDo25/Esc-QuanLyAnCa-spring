package com.esc.QuanLyAnCa.apis;

import com.esc.QuanLyAnCa.models.dangkycaan.DangKyCaNhanModel;
import com.esc.QuanLyAnCa.models.dangkycaan.DangKyTapTheModel;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class DangKyCaAnController {

    private static final Logger logger = Logger.getLogger(String.valueOf(DangKyCaAnController.class));

    //tạo hai request post add form đăng ký cá nhân và đăng ký tập th
    @PostMapping("/dangkycanhan")
    public ResponseEntity<String> dangKyCaNhan(@RequestBody DangKyCaNhanModel dangKyCaNhanModel) {

        if(dangKyCaNhanModel.getSoLuongCa1()+dangKyCaNhanModel.getSoLuongCa2()+dangKyCaNhanModel.getSoLuongCa3() == 0){
            logger.error("invalid request");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("số ca đăng ký không hợp lệ");
        }


        try {
            logger.info("dang ky thanh cong");
            return ResponseEntity.ok("Đăng ký ca ăn thành công");
        } catch (Exception e) {
            logger.error("dang ky that bai");

            // Xử lý lỗi nếu có
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Đăng ký ca ăn thất bại");
        }
    }
    @PostMapping("/dangkytapthe")
    public ResponseEntity<String> dangKyTapThe(@RequestBody DangKyTapTheModel dangKyTapTheModel) {
        for(DangKyCaNhanModel item: dangKyTapTheModel.getDanhSachDangKy()){
            if(item.getSoLuongCa3()+item.getSoLuongCa2()+item.getSoLuongCa1() == 0){
                logger.error("invalid request");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("số ca đăng ký không hợp lệ");

            }
        }
        try {
            logger.info("dang ky thanh cong");
            return ResponseEntity.ok("Đăng ký ca ăn thành công");
        } catch (Exception e) {
            logger.info("dang ky that bai");

            // Xử lý lỗi nếu có
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Đăng ký ca ăn thất bại");
        }
    }
}
