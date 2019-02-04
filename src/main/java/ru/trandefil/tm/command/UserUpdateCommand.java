package ru.trandefil.tm.command;

import ru.trandefil.tm.entity.User;
import ru.trandefil.tm.api.ServiceLocator;
import ru.trandefil.tm.service.TerminalService;
import ru.trandefil.tm.api.UserService;

import static ru.trandefil.tm.util.UserInputUtil.*;

public class UserUpdateCommand extends AbstractCommand {

    public UserUpdateCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    @Override
    public String command() {
        return "user-update";
    }

    @Override
    public String description() {
        return "update user";
    }

    @Override
    public void execute() {
        final UserService userService = getServiceLocator().getUserService();
        final TerminalService terminalService = getServiceLocator().getTerminalService();
        final String userName = getNotNullString(terminalService, "enter user name for update");
        final User userForUpdate = userService.getByName(userName);
        if (userForUpdate == null) {
            System.out.format("user with name %s doesn't exist");
            return;
        }
        final String newUserName = getNotNullString(terminalService, "enter new user name");
        final String newPassword =
                hashPassword(getNotNullString(terminalService, "enter new user password"));
        final User updated = new User(userForUpdate.getId(), newUserName, newPassword);
        userService.delete(userForUpdate);
        userService.save(updated);
    }

    @Override
    public boolean secure() {
        return true;
    }

}
