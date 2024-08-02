package com.vn.dev.core_be.dto.base.request;

import com.vn.dev.core_be.enums.TypeSort;

public class ApiListBaseRequest extends ApiBaseRequest {
    protected String orderBy = "serial";
    protected TypeSort orderDirection = TypeSort.ASC;
    protected int page = 0;
    protected int size = 15;
}
