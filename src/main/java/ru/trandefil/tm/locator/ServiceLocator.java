package ru.trandefil.tm.locator;

import ru.trandefil.tm.service.ProjectService;
import ru.trandefil.tm.service.TaskService;
import ru.trandefil.tm.service.TerminalService;



public interface ServiceLocator {

    ProjectService getProjectService();

    TaskService getTaskService();

    TerminalService getTerminalService();

}
