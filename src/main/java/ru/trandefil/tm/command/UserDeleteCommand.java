package ru.trandefil.tm.command;

import ru.trandefil.tm.entity.User;
import ru.trandefil.tm.locator.ServiceLocator;
import ru.trandefil.tm.service.inMemory.TerminalService;
import ru.trandefil.tm.service.UserService;

import static ru.trandefil.tm.util.UserInputUtil.*;

public class UserDeleteCommand extends AbstractCommand {
    public UserDeleteCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    @Override
    public String command() {
        return "user-delete";
    }

    @Override
    public String description() {
        return "delete user";
    }

    @Override
    public void execute() {
        final UserService userService = serviceLocator.getUserService();
        final TerminalService terminalService = serviceLocator.getTerminalService();
        final String userName = getNotNullString(terminalService, "enter user name for remove");
        final User userForRemove = userService.getByName(userName);
        if (userForRemove == null) {
            System.out.format("user with name %s doesn't exist", userName);
            return;
        }
        userService.delete(userForRemove);
    }
}
