package com.vn.dev.core_be.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestParam;

@Getter
@AllArgsConstructor

public class Paging {
    private int page;

    private int size;

    private String sort;

    public Paging(){
        this.page = 0;
        this.size = 15;
        this.sort = "name";
    }

    public Pageable toPageable() {
        return PageRequest.of(this.page, this.size, Sort.by(this.sort));
    }

}
