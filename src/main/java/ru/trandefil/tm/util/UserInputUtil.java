package ru.trandefil.tm.util;

import ru.trandefil.tm.service.TerminalService;

import java.text.ParseException;
import java.util.Date;

public class UserInputUtil {

    public static Date getDate(TerminalService scanner, String str) {
        boolean correctDate = false;
        Date date = null;
        while (!correctDate) {
            System.out.format("Enter the %s date with format dd-MM-yyyy : ", str);
            final String dateStringInput = scanner.nextLine();

            if (dateStringInput.isEmpty()) {
                return null;
            }
            try {
                date = DateFormatterUtil.parse(dateStringInput);
                correctDate = true;
            } catch (ParseException e) {
                System.out.println("Incorrect date format");
            }

        }
        return date;
    }

    public static String getNotNullString(TerminalService scanner, String incomingString) {
        System.out.format("%s : ", incomingString);
        boolean notEmptyInput = false;
        String userInput = null;
        while (!notEmptyInput) {
            userInput = scanner.nextLine();
            if ("return".equals(userInput)) {
                return null;
            }
            if (userInput.isEmpty()) {
                System.out.println("empty string doesn't valid");
                continue;
            }
            notEmptyInput = true;
        }
        return userInput;
    }
}
