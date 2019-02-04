package ru.trandefil.tm.command.service;

import ru.trandefil.tm.api.ServiceLocator;
import ru.trandefil.tm.api.UserService;
import ru.trandefil.tm.command.AbstractCommand;
import ru.trandefil.tm.entity.User;
import ru.trandefil.tm.service.TerminalService;
import ru.trandefil.tm.util.UserLoginUtil;

public class LoginCommand extends AbstractCommand {

    public LoginCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    public LoginCommand() {
    }

    @Override
    public String command() {
        return "login";
    }

    @Override
    public String description() {
        return "login user into system";
    }

    @Override
    public void execute() {
        final UserService userService = getServiceLocator().getUserService();
        final TerminalService terminalService = getServiceLocator().getTerminalService();
        final User loggedUser = UserLoginUtil.login(userService, terminalService);
        getServiceLocator().setLoggedUser(loggedUser);
    }

    @Override
    public boolean secure() {
        return false;
    }

}
