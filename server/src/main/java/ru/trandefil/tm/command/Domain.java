package ru.trandefil.tm.command;

import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.entity.Task;
import ru.trandefil.tm.entity.User;

import java.util.List;

public class Domain {

    private List<Project> projectList;

    private List<User> userList;

    private List<Task> taskList;

    public Domain() {
    }

    public Domain(List<Project> projectList, List<User> userList, List<Task> taskList) {
        this.projectList = projectList;
        this.userList = userList;
        this.taskList = taskList;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

}
