package com.vn.dev.core_be.controller;

import com.vn.dev.core_be.dto.ddnhanvien.request.DDNhanVienSearchEntity;
import com.vn.dev.core_be.dto.ddnhanvien.response.DDObjectBaseResponse;
import com.vn.dev.core_be.entity.DDNhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.vn.dev.core_be.controller.Endpoints.*;

@RestController
@ResponseBody
@RequestMapping(PREFIX)
public class DDNhanVienController {

//    @Autowired
//    private DDNhanVienRepository nvRepository;

    @GetMapping(value = DETAIL_PATH)
    public DDNhanVien getDetail(@PathVariable("uuid") UUID uuid){
        return null;
    }

    @PostMapping
    public Page<DDNhanVien> search(DDNhanVienSearchEntity searchData){
        return null;
    }

    @GetMapping(value = GET_ALL_PATH)
    public ResponseEntity<Page<DDNhanVien>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "15") int size,
            @RequestParam(defaultValue = "name") String sort
    ){
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return null;
    }

    @PutMapping(value = UPDATE_PATH)
    public DDObjectBaseResponse update(@PathVariable("uuid") UUID uuid){
        return null;
    }

    @DeleteMapping(value = DELETE_PATH)
    public void delete(@PathVariable("uuid") UUID uuid){
        return;
    }








}
