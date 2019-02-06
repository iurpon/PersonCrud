package ru.trandefil.tm.api;

import ru.trandefil.tm.command.AbstractCommand;
import ru.trandefil.tm.entity.User;
import ru.trandefil.tm.service.TerminalService;

import java.util.Map;

public interface ServiceLocator {

    ProjectService getProjectService();

    TaskService getTaskService();

    TerminalService getTerminalService();

    UserService getUserService();

    void setLoggedUser(User loggedUser);

    User getLoggedUser();

    Map<String, AbstractCommand> getCommandMap();

}
