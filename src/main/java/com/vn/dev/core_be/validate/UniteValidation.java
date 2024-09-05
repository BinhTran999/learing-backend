package com.vn.dev.core_be.validate;

import java.util.Calendar;
import java.util.Date;

public class UniteValidation {
    public static boolean validPhone(String phoneNumber){
        return phoneNumber == null || !phoneNumber.matches("^[0-9]{10}$");
    }

    public static boolean validEmail(String email){
        return email == null || !email.matches("[a-zA-Z0-9.]+@[a-z]+\\.[a-z]+");
    }

    public static boolean vaildBirth(Date birth){
        Calendar cal = Calendar.getInstance();
        cal.setTime(birth);
        Date current = new Date();
        Calendar calNow = Calendar.getInstance();
        calNow.setTime(current);
        boolean b1 = cal.get(Calendar.YEAR) >= 1950 && cal.get(Calendar.YEAR) < calNow.get(Calendar.YEAR);
        boolean b2 = cal.get(Calendar.MONTH) + 1 < calNow.get(Calendar.MONTH) + 1 && cal.get(Calendar.YEAR) == calNow.get(Calendar.YEAR);
        boolean b3 = (cal.get(Calendar.MONTH) + 1 == calNow.get(Calendar.MONTH) + 1) &&
                (cal.get(Calendar.DAY_OF_MONTH) < calNow.get(Calendar.DAY_OF_MONTH)) && cal.get(Calendar.YEAR) == calNow.get(Calendar.YEAR);
        return b1||b2||b3;
    }
}
