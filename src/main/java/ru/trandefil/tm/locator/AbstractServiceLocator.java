package ru.trandefil.tm.locator;

import ru.trandefil.tm.service.ProjectService;
import ru.trandefil.tm.service.TaskService;

public interface AbstractServiceLocator {

    ProjectService getProjectService();

    TaskService getTaskService();

}
