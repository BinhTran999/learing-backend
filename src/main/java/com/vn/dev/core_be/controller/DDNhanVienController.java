package com.vn.dev.core_be.controller;

import com.vn.dev.core_be.dto.base.BasePage;
import com.vn.dev.core_be.dto.base.response.ApiBaseResponse;
import com.vn.dev.core_be.dto.base.response.ApiResponseBuild;
import com.vn.dev.core_be.dto.ddnhanvien.DDNhanVienCreate;
import com.vn.dev.core_be.dto.ddnhanvien.DDNhanVienSearchEntity;
import com.vn.dev.core_be.dto.base.response.ApiObjectBaseResponse;
import com.vn.dev.core_be.dto.ddnhanvien.DDNhanVienUpdate;
import com.vn.dev.core_be.entity.DDNhanVien;
import com.vn.dev.core_be.service.DDNhanVien.DDNhanVienServiceImpl;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.vn.dev.core_be.controller.Endpoints.*;

@RestController
//@ResponseBody
@RequestMapping(PREFIX)
@Tag(name = "Dữ liệu nhân viên.", description = "Dữ liệu về nhân viên APIs")
@SecurityRequirement(name = "Auth Provider")
@ApiResponses(value = {
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiResponseBuild.class))
        }), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Yêu cầu không hợp lệ", content = {
        @Content(schema = @Schema(implementation = ApiResponseBuild.class), mediaType = "application/json")
}), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", description = "Lỗi xác thực tài khoản", content = {
        @Content(schema = @Schema(implementation = ApiResponseBuild.class), mediaType = "application/json")
}), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Yêu cầu không tồn tại", content = {
        @Content(schema = @Schema(implementation = ApiResponseBuild.class), mediaType = "application/json")
}), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Lỗi trong quá trình xử lý", content = {
        @Content(schema = @Schema(implementation = ApiResponseBuild.class), mediaType = "application/json")
})
})
public class DDNhanVienController {

    @Autowired
    private DDNhanVienServiceImpl DDNhanVienService;

    @GetMapping(value = DETAIL_PATH)
    public ApiObjectBaseResponse<DDNhanVien> getDetail(@PathVariable("uuid") UUID uuid){
        System.out.println(uuid);
        return DDNhanVienService.getNhanVienByID(uuid);
    }

    @PostMapping
    public BasePage<DDNhanVien> search(DDNhanVienSearchEntity searchData){
        return DDNhanVienService.search(searchData);
    }

    @GetMapping(value = GET_ALL_PATH)
    public ApiObjectBaseResponse<BasePage<DDNhanVien>> getAll(){
        return new ApiObjectBaseResponse<>(DDNhanVienService.getAll());
    }

    @PutMapping(value = UPDATE_PATH)
    public ApiObjectBaseResponse<DDNhanVien> update(@PathVariable("uuid") UUID uuid, DDNhanVienUpdate data){
        return DDNhanVienService.update(uuid, data);
    }

    @DeleteMapping(value = DELETE_PATH)
    public ApiBaseResponse delete(@PathVariable("uuid") UUID uuid){
        return DDNhanVienService.delete(uuid);
    }

    @GetMapping(value = CREATE_PATH)
    public ApiObjectBaseResponse<DDNhanVien> create(DDNhanVienCreate data){
        return DDNhanVienService.create(data);
    }
}
