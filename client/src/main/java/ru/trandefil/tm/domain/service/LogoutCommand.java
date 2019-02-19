package ru.trandefil.tm.domain.service;

import ru.trandefil.tm.api.ServiceLocator;
import ru.trandefil.tm.domain.AbstractCommand;
import ru.trandefil.tm.generated.Session;
import ru.trandefil.tm.generated.UserEndPoint;

public class LogoutCommand extends AbstractCommand {

    public LogoutCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    public LogoutCommand() {
    }

    @Override
    public String command() {
        return "logout";
    }

    @Override
    public String description() {
        return "logout user from system.";
    }

    @Override
    public void execute() {
        final UserEndPoint userEndPoint = getServiceLocator().getUserEndPoint();
        Session session = getServiceLocator().getSession();
        userEndPoint.userLogout(session);
        getServiceLocator().setSession(null);
    }

    @Override
    public boolean secure() {
        return true;
    }

}
