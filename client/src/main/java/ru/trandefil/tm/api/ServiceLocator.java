package ru.trandefil.tm.api;

import ru.trandefil.tm.domain.AbstractCommand;
import ru.trandefil.tm.generated.*;
import ru.trandefil.tm.service.TerminalService;

import java.util.Map;

public interface ServiceLocator {

    TerminalService getTerminalService();

    Map<String, AbstractCommand> getCommandMap();

    ProjectEndPoint getProjectEndPoint();

    TaskEndPoint getTaskEndPoint();

    UserEndPoint getUserEndPoint();

    AdminEndPoint getAdminEndPoint();

    Session getSession();

    void setSession(Session session);

}
