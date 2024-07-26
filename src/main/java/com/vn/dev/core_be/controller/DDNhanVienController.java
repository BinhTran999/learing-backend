package com.vn.dev.core_be.controller;

import com.vn.dev.core_be.entity.DDNhanVien;
import com.vn.dev.core_be.repository.DDNhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.vn.dev.core_be.controller.Endpoints.PATH_VARIABLE_ID;
import static com.vn.dev.core_be.controller.Endpoints.PREFIX;

@RestController
@ResponseBody
@RequestMapping(PREFIX)
public class DDNhanVienController {

    @Autowired
    private DDNhanVienRepository nvRepository;

    @GetMapping(value = PATH_VARIABLE_ID)
    public DDNhanVien findById(@PathVariable("uuid") UUID uuid){
        return null;
    }



}
