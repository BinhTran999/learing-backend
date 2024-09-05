package com.vn.dev.core_be.utils;

import com.vn.dev.core_be.dto.base.request.ApiListBaseRequest;
import com.vn.dev.core_be.enums.TypeSort;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.UtilityClass;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestParam;

@UtilityClass
public class Paging {
    public static PageRequest buildPageRequest(ApiListBaseRequest request, int page) {
        request.setPage(page);
        if (TypeSort.DESC.equals(request.getOrderDirection())) {
            return PageRequest.of(request.getPage(), request.getSize(), Sort.by(request.getOrderBy()).descending());
        }
        return PageRequest.of(request.getPage(), request.getSize(), Sort.by(request.getOrderBy()).ascending());
    }

}
