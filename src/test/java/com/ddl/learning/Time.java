package com.ddl.learning;

import java.util.Calendar;
import java.util.Date;

public class Time {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        System.out.println(getTimesmorning());

    }
    public static Long getTimesmorning() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime().getTime();
    }
}
