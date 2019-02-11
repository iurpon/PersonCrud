package ru.trandefil.tm.command.user;

import ru.trandefil.tm.command.AbstractCommand;
import ru.trandefil.tm.api.ServiceLocator;

public class UserCreateCommand extends AbstractCommand {

    public UserCreateCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    public UserCreateCommand() {
    }

    @Override
    public String command() {
        return "user-create";
    }

    @Override
    public String description() {
        return "create new user";
    }

    @Override
    public void execute() {
/*        final UserService userService = getServiceLocator().getUserService();
        final TerminalService terminalService = getServiceLocator().getTerminalService();
        final String userName = getNotNullString(terminalService, "enter user name");
        final String userPass = hashPassword(getNotNullString(terminalService, "enter user password"));
        final User user = new User(UUID.randomUUID().toString(), userName, userPass);
        userService.save(user);*/
    }

    @Override
    public boolean secure() {
        return true;
    }

}
