package ru.trandefil.tm.entity;

import java.util.Date;

public class Task extends BaseEntity {

    private static final long serialVersionUID = 2L;

    private String description;

    private Date begin;

    private Date end;

    private Project project;

    private User assignee;

    private User executer;

    public Task() {
    }

    public Task(String id, String name, String description, Date begin, Date end, Project project) {
        super(id, name);
        this.description = description;
        this.begin = begin;
        this.end = end;
        this.project = project;
    }

    public Task(String id, String name, String description, Date begin, Date end, Project project, User assignee, User executer) {
        super(id, name);
        this.description = description;
        this.begin = begin;
        this.end = end;
        this.project = project;
        this.assignee = assignee;
        this.executer = executer;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    public User getExecuter() {
        return executer;
    }

    public void setExecuter(User executer) {
        this.executer = executer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "task{" +
/*                "description='" + description + '\'' +
                ", begin=" + (begin == null ? "Didn't start" : DateFormatterUtil.format(begin)) +
                ", end=" + (end == null ? "Still in production" : DateFormatterUtil.format(end)) +
                ", project=" + project.getName() +*/
                ", assignee=" + assignee.getName() +
                ", executer=" + executer.getName() +
                /*                ", id='" + id + '\'' +*/
                ", name='" + name + '\'' +
                '}';
    }

}
