package ru.trandefil.tm.command;

import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.entity.Task;
import ru.trandefil.tm.entity.User;

import java.util.List;

public class Domain {

    private List<Project> lists;

    private List<User> users;

    private List<Task> tasks;

    public Domain() {
    }

    public Domain(List<Project> lists, List<User> users, List<Task> tasks) {
        this.lists = lists;
        this.users = users;
        this.tasks = tasks;
    }

    public List<Project> getLists() {
        return lists;
    }

    public void setLists(List<Project> lists) {
        this.lists = lists;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

}
