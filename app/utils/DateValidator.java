package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author: alexander
 * Project: tempserver-playframework
 */
public class DateValidator {

    public static Date validateDate(String start) {
        String dateFormat = "yyyy-MM-ddHH:mm";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        simpleDateFormat.setLenient(false);
        Date date;

        try {
            date = simpleDateFormat.parse(start);
        } catch (ParseException e) {
            return null;
        }

        return date;
    }
}
