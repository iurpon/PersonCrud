package ru.trandefil.tm.command.user;

import ru.trandefil.tm.command.AbstractCommand;
import ru.trandefil.tm.api.ServiceLocator;

public class UserDeleteCommand extends AbstractCommand {

    public UserDeleteCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    public UserDeleteCommand() {
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
/*        final UserService userService = getServiceLocator().getUserService();
        final TerminalService terminalService = getServiceLocator().getTerminalService();
        final String userName = getNotNullString(terminalService, "enter user name for remove");
        final User userForRemove = userService.getByName(userName);
        if (userForRemove == null) {
            System.out.format("user with name %s doesn't exist", userName);
            return;
        }
        userService.delete(userForRemove);*/
    }

    @Override
    public boolean secure() {
        return true;
    }

    @Override
    public boolean isAdmin() {
        return true;
    }

}
