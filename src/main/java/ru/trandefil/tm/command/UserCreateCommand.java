package ru.trandefil.tm.command;

import ru.trandefil.tm.entity.User;
import ru.trandefil.tm.locator.ServiceLocator;
import ru.trandefil.tm.service.TerminalService;
import ru.trandefil.tm.service.UserService;

import java.util.UUID;

import static ru.trandefil.tm.util.UserInputUtil.*;

public class UserCreateCommand extends AbstractCommand {
    public UserCreateCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
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
        final UserService userService = serviceLocator.getUserService();
        final TerminalService terminalService = serviceLocator.getTerminalService();
        final String userName = getNotNullString(terminalService,"enter user name");
        final String userPass = getNotNullString(terminalService,"enter user password");
        final User user = new User(UUID.randomUUID().toString(),userName,userPass);
        userService.save(user);
    }
}
