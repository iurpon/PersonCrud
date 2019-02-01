package ru.trandefil.tm.locator;

import ru.trandefil.tm.service.ProjectService;
import ru.trandefil.tm.service.TaskService;
import ru.trandefil.tm.service.TerminalService;



public interface AbstractServiceLocator {

    ProjectService getProjectService();

    TaskService getTaskService();

    TerminalService getTermanalService();

}
