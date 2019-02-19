package ru.trandefil.tm.domain.service;

import ru.trandefil.tm.domain.AbstractCommand;
import ru.trandefil.tm.generated.Session;
import ru.trandefil.tm.generated.UserEndPoint;
import ru.trandefil.tm.service.TerminalService;

import static ru.trandefil.tm.util.UserInputUtil.getNotNullString;

public class RegistryCommand extends AbstractCommand {

    public RegistryCommand() {
    }

    @Override
    public String command() {
        return "registry";
    }

    @Override
    public String description() {
        return "registry new user";
    }

    @Override
    public void execute() {
        final UserEndPoint userEndPoint = getServiceLocator().getUserEndPoint();
        final TerminalService terminalService = getServiceLocator().getTerminalService();
        final String userName = getNotNullString(terminalService, "enter login name");
        final String userPassword = getNotNullString(terminalService, "enter login password");
        final Session session = userEndPoint.registry(userName, userPassword);
        if (session == null) {
            System.out.println("bad registry.");
            return;
        }
        System.out.println("Welcome");
        getServiceLocator().setSession(session);
    }

    @Override
    public boolean secure() {
        return false;
    }

}
