package ru.trandefil.tm.command.service;

import ru.trandefil.tm.api.ServiceLocator;
import ru.trandefil.tm.command.AbstractCommand;
import ru.trandefil.tm.generated.User;
import ru.trandefil.tm.generated.UserEndPoint;
import ru.trandefil.tm.service.TerminalService;
import ru.trandefil.tm.util.UserInputUtil;

import static ru.trandefil.tm.util.UserInputUtil.getNotNullString;

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
        TerminalService terminalService = getServiceLocator().getTerminalService();
        String userName = getNotNullString(terminalService,"login name");
        String userPassword = getNotNullString(terminalService,"login password");
        UserEndPoint userEndPoint = getServiceLocator().getUserEndPoint();
//        User logged = userEndPoint.
    }

    @Override
    public boolean secure() {
        return false;
    }

}
