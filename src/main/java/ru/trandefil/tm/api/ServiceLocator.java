package ru.trandefil.tm.api;

import ru.trandefil.tm.entity.User;
import ru.trandefil.tm.service.TerminalService;


public interface ServiceLocator {

    ProjectService getProjectService();

    TaskService getTaskService();

    TerminalService getTerminalService();

    UserService getUserService();

    void setLoggedUser(User loggedUser);

}
