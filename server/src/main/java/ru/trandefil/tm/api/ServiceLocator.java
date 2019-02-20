package ru.trandefil.tm.api;

public interface ServiceLocator {

    ProjectService getProjectService();

    TaskService getTaskService();

    UserService getUserService();
}
