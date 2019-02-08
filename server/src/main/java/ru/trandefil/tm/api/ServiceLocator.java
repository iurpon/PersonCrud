package ru.trandefil.tm.api;

import ru.trandefil.tm.entity.User;

public interface ServiceLocator {

    ProjectService getProjectService();

    TaskService getTaskService();

    UserService getUserService();

    User getLoggedUser();

    void setLoggedUser(User loggedUser);

}
