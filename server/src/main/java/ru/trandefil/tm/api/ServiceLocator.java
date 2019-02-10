package ru.trandefil.tm.api;

import ru.trandefil.tm.entity.User;

public interface ServiceLocator {

    ProjectService getProjectService();

    TaskService getTaskService();

    UserService getUserService();

    SessionService getSessionService();

}
