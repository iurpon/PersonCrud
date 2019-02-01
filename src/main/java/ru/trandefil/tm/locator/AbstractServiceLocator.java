package ru.trandefil.tm.locator;

import ru.trandefil.tm.service.ProjectService;
import ru.trandefil.tm.service.TaskService;

import java.util.Scanner;

public interface AbstractServiceLocator {

    ProjectService getProjectService();

    TaskService getTaskService();

    Scanner getScanner();

}
