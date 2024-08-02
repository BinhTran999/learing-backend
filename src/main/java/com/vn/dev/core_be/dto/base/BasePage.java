package com.vn.dev.core_be.dto.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BasePage<T extends BaseDto> extends BaseDto {
    protected  Integer page;
    protected Integer totalPage;

    protected Long totalRecord;
    protected List<T> data;
}
