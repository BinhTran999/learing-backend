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
public class BasePage<T> extends BaseDto {
    protected Integer page;
    protected Integer size;
    protected Long totalRecord;
    protected List<T> data;
    protected int totalPage;
}
