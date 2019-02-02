package ru.trandefil.tm.util;

import ru.trandefil.tm.service.TerminalService;

import java.text.ParseException;
import java.util.Date;

public class ValidateUserInputUtil {

    public static Date getDate(TerminalService scanner, String str) {
        boolean correctDate = false;
        Date date = null;
        while (!correctDate) {
            System.out.format("Enter the %s date with format dd-MM-yyyy : ", str);
            String dateString = scanner.nextLine();

            if (dateString.isEmpty()) {
                return null;
            }
            try {
                date = DateFormatterUtil.parse(dateString);
                correctDate = true;
            } catch (ParseException e) {
                System.out.println("Incorrect date format");
            }

        }
        return date;
    }

    public static String getNotNullString(TerminalService scanner, String requestedStringName) {
        System.out.format("%s : ", requestedStringName);
        boolean notNull = false;
        String requestString = null;
        while (!notNull) {
            requestString = scanner.nextLine();
            if ("return".equals(requestString)) {
                return null;
            }
            if (requestString.isEmpty()) {
                System.out.println("empty string isn't valid");
                continue;
            }
            notNull = true;

        }
        return requestString;
    }
}
