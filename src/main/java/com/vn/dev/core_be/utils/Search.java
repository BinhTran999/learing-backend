package com.vn.dev.core_be.utils;

import com.vn.dev.core_be.entity.DDNhanVien;
import com.vn.dev.core_be.enums.Gender;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@UtilityClass
public class Search {
    public static String getGender(String gender){
//        if (Gender.NONE.equals(gender)){
//            return null;
//        }
//        if (Gender.MALE.equals(gender)){
//            return "MALE";
//        }
//        return "FEMALE";
        if (gender.equals("NONE")){
            return null;
        }
        return gender;
    }

    public List<DDNhanVien> filterDataByPage(List<DDNhanVien> data, int page, int size){
        List<DDNhanVien> res = new ArrayList<>();
        int  i = 0;
        while (i < 15 & size*page + i < data.size()){
            res.add(data.get(page*size + i));
            i++;
        }
        return res;
    }
}
