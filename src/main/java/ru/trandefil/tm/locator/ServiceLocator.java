package ru.trandefil.tm.locator;

import ru.trandefil.tm.service.ProjectService;
import ru.trandefil.tm.service.TaskService;
import ru.trandefil.tm.service.TerminalService;
import ru.trandefil.tm.service.UserService;


public interface ServiceLocator {

    ProjectService getProjectService();

    TaskService getTaskService();

    TerminalService getTerminalService();

    UserService getUserService();

}
