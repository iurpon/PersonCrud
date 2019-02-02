package ru.trandefil.tm.util;

import ru.trandefil.tm.entity.User;
import ru.trandefil.tm.service.inMemory.TerminalService;
import ru.trandefil.tm.service.UserService;
import static ru.trandefil.tm.util.UserInputUtil.*;

public class UserLoginUtil {
    public static void login(UserService userService, TerminalService terminalService){
        System.out.println("Plz login before start work : ");
        while (true){
            final String userName = getNotNullString(terminalService,"enter user name");
            final String userPass = getNotNullString(terminalService,"enter user password");
            final User user = userService.getLoginUser(userName,userPass);
            if(user != null){
                return;
            }
            System.out.println("wrong user name or password. try again.");
        }


    }
}
