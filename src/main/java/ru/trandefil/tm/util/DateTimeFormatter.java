package ru.trandefil.tm.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

public class DateTimeFormatter {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy");

    public static Date  parse(String dateString) throws ParseException {
        return simpleDateFormat.parse(dateString);
    }

    public static String format(Date date){
        return simpleDateFormat.format(date);
    }
}
