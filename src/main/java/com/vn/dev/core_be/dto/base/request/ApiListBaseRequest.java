package com.vn.dev.core_be.dto.base.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.vn.dev.core_be.enums.TypeSort;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiListBaseRequest extends ApiBaseRequest {
    protected String orderBy = "order";
    protected TypeSort orderDirection = TypeSort.ASC;
    protected int page = 0;
    protected int size = 15;
}
