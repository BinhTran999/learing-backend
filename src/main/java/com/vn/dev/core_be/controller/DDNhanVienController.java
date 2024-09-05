package com.vn.dev.core_be.controller;

import com.vn.dev.core_be.dto.base.BasePage;
import com.vn.dev.core_be.dto.base.request.ApiDeleteRequest;
import com.vn.dev.core_be.dto.base.request.ApiRequest;
import com.vn.dev.core_be.dto.base.request.ApiSearchRequest;
import com.vn.dev.core_be.dto.base.request.PagingRequest;
import com.vn.dev.core_be.dto.base.response.ApiBaseResponse;
import com.vn.dev.core_be.dto.base.response.ApiResponseBuild;
import com.vn.dev.core_be.dto.ddnhanvien.DDNhanVienCreate;
import com.vn.dev.core_be.dto.ddnhanvien.DDNhanVienResponse;
import com.vn.dev.core_be.dto.ddnhanvien.DDNhanVienSearchEntity;
import com.vn.dev.core_be.dto.base.response.ApiObjectBaseResponse;
import com.vn.dev.core_be.dto.ddnhanvien.DDNhanVienUpdate;
import com.vn.dev.core_be.entity.BaseEntity;
import com.vn.dev.core_be.entity.DDNhanVien;
import com.vn.dev.core_be.service.DDNhanVien.DDNhanVienServiceImpl;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
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
    public ApiObjectBaseResponse<ApiObjectBaseResponse<DDNhanVienResponse>> getDetail(ApiSearchRequest<UUID> data){
        return new ApiObjectBaseResponse<>(DDNhanVienService.getNhanVienByID(data.getSearchData()));
    }

    @CrossOrigin
    @PostMapping(value = SEARCH_PATH)
    public ApiObjectBaseResponse<BasePage<DDNhanVienResponse>> search(@RequestBody ApiSearchRequest<DDNhanVienSearchEntity> searchData){
        System.out.println(searchData.getSearchData().getBirdDateFrom());
        return new ApiObjectBaseResponse<>(DDNhanVienService.search(searchData.getSearchData()));
    }

    @CrossOrigin
    @PostMapping(value = GET_ALL_PATH_PAGE)
    public ApiObjectBaseResponse<BasePage<DDNhanVienResponse>> getAll(@RequestBody PagingRequest<DDNhanVienSearchEntity> page){
        return new ApiObjectBaseResponse<>(DDNhanVienService.getAllPage(page.getReqPage().getPage()));
    }

    @PutMapping(value = UPDATE_PATH)
    @CrossOrigin
    public ApiObjectBaseResponse<ApiObjectBaseResponse<DDNhanVien>> update(@RequestBody ApiRequest<DDNhanVienUpdate> data){
        return new ApiObjectBaseResponse<>( DDNhanVienService.update(data.getData()));
    }

    @DeleteMapping(value = DELETE_PATH)
    @CrossOrigin
    public ApiBaseResponse delete(@RequestBody ApiDeleteRequest<BaseEntity> delData){
        return DDNhanVienService.delete(delData.getDelData().getId());
    }

    @PostMapping(value = CREATE_PATH)
    @CrossOrigin
    public ApiObjectBaseResponse<ApiObjectBaseResponse<DDNhanVien>> create(@RequestBody ApiRequest<DDNhanVienCreate> data){
        System.out.print(data.getData().toString());
        return new ApiObjectBaseResponse<>(DDNhanVienService.create(data.getData()));
    }
}
