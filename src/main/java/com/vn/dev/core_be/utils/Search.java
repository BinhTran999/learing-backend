package com.vn.dev.core_be.utils;

import com.vn.dev.core_be.enums.Gender;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Search {
    public static String getGender(Gender gender){
        if (Gender.MALE.equals(gender)){
            return "MALE";
        }
        return "FEMALE";
    }
}
