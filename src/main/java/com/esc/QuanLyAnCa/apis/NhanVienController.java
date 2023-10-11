package com.esc.QuanLyAnCa.apis;

import com.esc.QuanLyAnCa.dtos.NhanVienDTO;
import com.esc.QuanLyAnCa.entities.NhanVien;
import com.esc.QuanLyAnCa.models.user.Role;
import com.esc.QuanLyAnCa.services.NhanVienService;
import com.esc.QuanLyAnCa.services.RefreshTokenService;
import jakarta.validation.Valid;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class NhanVienController {
    private static final Logger logger = Logger.getLogger(String.valueOf(NhanVienController.class));

    @Autowired
    private NhanVienService nhanvienService;
    @Autowired
    private ModelMapper mapper;



    //paging


    @GetMapping("/nhanvien/filter")
    public ResponseEntity<Page<NhanVienDTO>> searchUsers(@RequestParam(value = "maNhanVien", defaultValue = "") String nhanVienCode,
                                                         @RequestParam(name = "pageNumber", defaultValue = "0") int page,
                                                         @RequestParam(defaultValue = "") String phongBanId,
                                                         @RequestParam("nhanVienName") String nhanVienName,
                                                         @RequestParam("startDate") String startDate,
                                                         @RequestParam("endDate") String endDate,
                                                         @RequestParam(name = "pageSize", defaultValue = "10") int size) {
        if (size < 0) {
            logger.error("pageSize");
        }
        if (page < 0) {
            logger.error("pageNumber invalid");

        }
        Page<NhanVien> users = nhanvienService.search(nhanVienCode,
                phongBanId, nhanVienName, startDate, endDate, page, size);
        Page<NhanVienDTO> dtos = (Page<NhanVienDTO>) mapper.map(users, NhanVienDTO.class);
// Assumption: dtos is a Page<NhanVienDTO> containing NhanVienDTO objects

        for (NhanVienDTO dto : dtos) {
            dto.setPassword(""); // Đặt trường password thành chuỗi rỗng
        }

        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/getNhanVienByUsername")
    public NhanVienDTO getNhanVienByUsername(@Param("username") String username) {
        Optional<NhanVien> tmp = nhanvienService.getNhanVienByUsername(username);
        if (tmp.isEmpty()) {
            logger.warn("no nhanvien have this username!");
        }
        NhanVien nv = tmp.get();
        NhanVienDTO dto = mapper.map(nv, NhanVienDTO.class);
        dto.setPassword("");
        return dto;
    }


    @GetMapping("/nhanvien/listByDepartmentId/{id}")
    public List<NhanVienDTO> getAllNhanVienByDepartmentId(@PathVariable(value = "id") String id) {
        var res = nhanvienService.getAllNhanVienByDepartmentId(id);
        if (res.isEmpty()) {
            logger.warn("id invalid");
        }
        List<NhanVien> listNV = nhanvienService.getAllNhanVienByDepartmentId(id);
        List<NhanVienDTO> dtos = listNV.stream()
                .map(nhanVien -> mapper.map(nhanVien, NhanVienDTO.class))
                .collect(Collectors.toList());
        for (NhanVienDTO dto : dtos) {
            dto.setPassword(""); // Đặt trường password thành chuỗi rỗng
        }

        return dtos;
    }

    @PutMapping("nhanvien/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable String id, @Valid @RequestBody NhanVien updatedEmployee
            , BindingResult result
    ) {
        if (result.hasErrors()) {
            // Nếu có lỗi trong dữ liệu đầu vào
            Map<String, String> errorMap = new HashMap<>();
            result.getFieldErrors().forEach(error -> errorMap.put(error.getField(), error.getDefaultMessage()));
            logger.error(errorMap);

            return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
        }
        NhanVien savedNhanVien = nhanvienService.update(id, updatedEmployee);
        NhanVienDTO dto = mapper.map(savedNhanVien, NhanVienDTO.class);
        dto.setPassword("");
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping("/nhanvien")
    public ResponseEntity<?> save(@Valid @RequestBody NhanVien nhanvien, BindingResult result) {
        if (result.hasErrors()) {
            // Nếu có lỗi trong dữ liệu đầu vào
            Map<String, String> errorMap = new HashMap<>();
            result.getFieldErrors().forEach(error -> errorMap.put(error.getField(), error.getDefaultMessage()));
            logger.error(errorMap);

            return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
        }
        NhanVien savedNhanVien = nhanvienService.save(nhanvien);
        NhanVienDTO dto = mapper.map(savedNhanVien, NhanVienDTO.class);
        dto.setPassword("");
        return new ResponseEntity<>(savedNhanVien, HttpStatus.OK);
    }

    //lấy nhân viên theo id
    @GetMapping("/nhanvien/{id}")
    public NhanVienDTO getById(@PathVariable(value = "id") String id) {

        var res = nhanvienService.find(id);
        if (res.isEmpty()) {
            logger.warn("id not exist");
        }
        Optional<NhanVien> nv = nhanvienService.find(id);
        NhanVienDTO dto = mapper.map(nv.get(), NhanVienDTO.class);
        dto.setPassword("");
        return dto;
    }

    @GetMapping("/role")
    public Role[] getAllRoles() {

        var res = Role.values();
        if (res.length == 0) {
            logger.warn("result null");
        }
        return Role.values();
    }

    //hiển thị toàn bộ nhân viên
    @GetMapping("/nhanvien")
    public List<NhanVienDTO> getAll() {
        logger.info("get all nhanvien");
        List<NhanVien> listNhanVien = nhanvienService.findAll();
        List<NhanVienDTO> dtos = listNhanVien.stream()
                .map(nhanVien -> mapper.map(nhanVien, NhanVienDTO.class))
                .collect(Collectors.toList());
        for (NhanVienDTO dto : dtos) {
            dto.setPassword(""); // Đặt trường password thành chuỗi rỗng
        }
        return dtos;
    }

    @DeleteMapping("/nhanvien/{id}")
    public void deleteById(@PathVariable(value = "id") String id) {
        nhanvienService.delete(id);
    }

    @DeleteMapping("/nhanvien")
    public void deleteAll() {
        nhanvienService.deleteAll();
    }

    @GetMapping("/nhanvien/count")
    public long count() {
        return nhanvienService.count();
    }

    //thêm api phân trang nhân viên
}