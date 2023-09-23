package com.esc.QuanLyAnCa.apis;

import com.esc.QuanLyAnCa.entities.NhanVien;
import com.esc.QuanLyAnCa.models.user.Role;
import com.esc.QuanLyAnCa.services.NhanVienService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class NhanVienController {
    private static final Logger logger = Logger.getLogger(String.valueOf(NhanVienController.class));

    @Autowired
    private NhanVienService nhanvienService;

    //paging

    @GetMapping("/paging")
    public ResponseEntity<Page<NhanVien>> getUsers(@RequestParam("pageNumber") int pageNumber,
                                                   @RequestParam("pageSize") int pageSize) {

        Page<NhanVien> users = nhanvienService.findAll(pageNumber, pageSize);
        if(users.isEmpty()){
            logger.warn("result null!");
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }


    @GetMapping("/nhanvien/filter")
    public ResponseEntity<Page<NhanVien>> searchUsers(@RequestParam(value = "maNhanVien", defaultValue = "") String nhanVienCode,
                                                      @RequestParam(name = "pageNumber", defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "") String phongBanId,
                                                      @RequestParam("nhanVienName") String nhanVienName,
                                                      @RequestParam("startDate") String startDate,
                                                      @RequestParam("endDate") String endDate,
                                                      @RequestParam(name = "pageSize", defaultValue = "10") int size) {
        if(size < 0){
            logger.error("pageSize");
        }
        if(page< 0){
            logger.error("pageNumber invalid");

        }

        Page<NhanVien> users = nhanvienService.search(nhanVienCode,
                phongBanId, nhanVienName, startDate, endDate, page, size);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/getNhanVienByUsername")
    public NhanVien getNhanVienByUsername(@Param("username") String username) {
        Optional<NhanVien> tmp = nhanvienService.getNhanVienByUsername(username);
        if(tmp.isEmpty()){
            logger.warn("no nhanvien have this username!");
        }
        return tmp.get();
    }


    @GetMapping("/nhanvien/listByDepartmentId/{id}")
    public List<NhanVien> getAllNhanVienByDepartmentId(@PathVariable(value = "id") String id) {
        var res = nhanvienService.getAllNhanVienByDepartmentId(id);
        if(res.isEmpty()){
            logger.warn("id invalid");
        }
        return nhanvienService.getAllNhanVienByDepartmentId(id);
    }

    @PutMapping("nhanvien/{id}")
    public NhanVien updateEmployee(@PathVariable String id, @RequestBody NhanVien updatedEmployee) {
        return nhanvienService.update(id, updatedEmployee);
    }

    @PostMapping("/nhanvien")
    public NhanVien save(@RequestBody NhanVien nhanvien) {
        return nhanvienService.save(nhanvien);
    }

    //lấy nhân viên theo id
    @GetMapping("/nhanvien/{id}")
    public Optional<NhanVien> getById(@PathVariable(value = "id") String id) {

        var res =nhanvienService.find(id);
        if(res.isEmpty()){
            logger.warn("id not exist");
        }
        return nhanvienService.find(id);
    }

    @GetMapping("/role")
    public Role[] getAllRoles() {

        var res = Role.values();
        if(res.length == 0){
            logger.warn("result null");
        }
        return Role.values();
    }

    //hiển thị toàn bộ nhân viên
    @GetMapping("/nhanvien")
    public List<NhanVien> getAll() {
        logger.info("get all nhanvien");
        return nhanvienService.findAll();
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