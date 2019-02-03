package ru.trandefil.tm.util;

import ru.trandefil.tm.entity.User;
import ru.trandefil.tm.service.TerminalService;
import ru.trandefil.tm.api.UserService;

import static ru.trandefil.tm.util.UserInputUtil.*;

public class UserLoginUtil {

    public static User login(UserService userService, TerminalService terminalService) {
            final String userName = getNotNullString(terminalService, "enter user name");
            final String userPass = getNotNullString(terminalService, "enter user password");
            final User user = userService.getLoginUser(userName, userPass);
            if (user != null) {
                return user;
            }
            System.out.println("wrong user name or password.");
    }

}
