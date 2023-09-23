package com.esc.QuanLyAnCa.apis;

import com.esc.QuanLyAnCa.core.MessageModel;
import com.esc.QuanLyAnCa.models.thongke.ThongKeCaNhanModel;
import com.esc.QuanLyAnCa.models.thongke.ThongKeTheoNgayDTO;
import com.esc.QuanLyAnCa.models.thongke.ThongKeTheoThangModel;
import com.esc.QuanLyAnCa.services.ThongKeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/thongke")
public class ThongKeController {
    @Autowired
    private ThongKeService thongKeService;
    private static final Logger logger = Logger.getLogger(String.valueOf(ThongKeController.class));


    @GetMapping("/thongkecanhan")
    public ResponseEntity<?> getInfoThongKeCaNhan(
            @RequestParam("startDate") String startDateString,
            @RequestParam("userId") String userId,
            @RequestParam("endDate") String endDateString) throws ParseException {


        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String subStringStartDate = startDateString.substring(0, 10);
        String subStringEndDate = endDateString.substring(0, 10);
        Date startDate = new Date();
        Date endDate = new Date();
        // Chuỗi đầu ngày và cuối ngày
        String startOfDay = "00:00:00";
        String endOfDay = "00:00:00";


        // Ví dụ chuỗi ngày bắt đầu và kết thúc
        startDateString = subStringStartDate + " " + startOfDay;
        endDateString = subStringEndDate + " " + endOfDay;
        // Định dạng cho chuỗi ngày giờ
        if (startDateString.length() > 0) {
            startDate = dateFormat.parse(startDateString);

        }
        Date newEndDate = new Date();
        if (endDateString.length() > 0) {
            endDate = dateFormat.parse(endDateString);
            // Tạo một đối tượng Calendar và đặt giá trị của endDate vào đó
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(endDate);

            // Cộng thêm 1 ngày
            calendar.add(Calendar.DAY_OF_MONTH, 1);

            // Lấy ngày sau khi đã cộng thêm 1 ngày
            newEndDate = calendar.getTime();
        }
        int result = startDate.compareTo(newEndDate);

        if (result > 0) {
            MessageModel messageModel = new MessageModel().builder().devMsg("ngay bat dau lon hon ngay ket thuc")
                    .userMsg("ngày bắt đầu phải nhỏ hơn ngày kết thúc").build();
            logger.error("startDate greater than endDate");
            return new ResponseEntity<>(messageModel, HttpStatus.BAD_REQUEST);
        }
        List<ThongKeCaNhanModel> response = thongKeService.getInfoThongKeCaNhan(startDate, newEndDate, userId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/thongketheongay")
    public ResponseEntity<?> getInfoThongKeTheoNgay(
            @RequestParam("startDate") String startDateString,
            @RequestParam("endDate") String endDateString) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDate = new Date();
        Date endDate = new Date();
        String startOfDay = "00:00:00";
        String endOfDay = "00:00:00";


        // Ví dụ chuỗi ngày bắt đầu và kết thúc
        startDateString = startDateString + " " + startOfDay;
        endDateString = endDateString + " " + endOfDay;
        // Định dạng cho chuỗi ngày giờ
        if (startDateString.length() > 0) {
            startDate = dateFormat.parse(startDateString);

        }
        Date newEndDate = new Date();

        if (endDateString.length() > 0) {
            endDate = dateFormat.parse(endDateString);
            // Tạo một đối tượng Calendar và đặt giá trị của endDate vào đó
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(endDate);

            // Cộng thêm 1 ngày
            calendar.add(Calendar.DAY_OF_MONTH, 1);

            // Lấy ngày sau khi đã cộng thêm 1 ngày
            newEndDate = calendar.getTime();
        }
        int result = startDate.compareTo(newEndDate);

        if (result > 0) {
            MessageModel messageModel = new MessageModel().builder().devMsg("startDate greater than endDate")
                    .userMsg("ngày bắt đầu phải nhỏ hơn ngày kết thúc").build();
            logger.error("startDate greater than endDate");
            return new ResponseEntity<>(messageModel, HttpStatus.BAD_REQUEST);
        }
        List<ThongKeTheoNgayDTO> response = thongKeService.getInfoThongKeTheoNgay(startDate, newEndDate);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/thongketheothang")
    public ResponseEntity<?> getInfoThongKeTheoThang(
            @RequestParam("month") int month,
            @RequestParam("year") int year
    ) {
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        int currentMonth = currentDate.getMonthValue();

        if (year > currentYear || (year == currentYear && month > currentMonth)) {
            // Nếu month và year vượt quá tháng và năm hiện tại, trả về thông báo lỗi
            MessageModel messageModel = MessageModel.builder()
                    .devMsg("Tháng và năm không hợp lệ")
                    .userMsg("Tháng và năm không thể vượt quá tháng và năm hiện tại")
                    .build();
            logger.error("month and date is not valid");
            return new ResponseEntity<>(messageModel, HttpStatus.BAD_REQUEST);
        }
        List<ThongKeTheoThangModel> response = thongKeService.getInfoThongKeTheoThang(month, year);
        return ResponseEntity.ok(response);
    }
}

