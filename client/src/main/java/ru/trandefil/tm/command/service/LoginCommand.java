package ru.trandefil.tm.command.service;

import ru.trandefil.tm.api.ServiceLocator;
import ru.trandefil.tm.command.AbstractCommand;
import ru.trandefil.tm.generated.Session;
import ru.trandefil.tm.generated.UserEndPoint;
import ru.trandefil.tm.service.TerminalService;

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
        final TerminalService terminalService = getServiceLocator().getTerminalService();
        final String userName = getNotNullString(terminalService, "login name");
        final String userPassword = getNotNullString(terminalService, "login password");
        final UserEndPoint userEndPoint = getServiceLocator().getUserEndPoint();
        final Session session = userEndPoint.getSession(userName,userPassword);
        if(session == null){
            System.out.println("session is null");
            return;
        }
        getServiceLocator().setSession(session);
    }

    @Override
    public boolean secure() {
        return false;
    }

}
