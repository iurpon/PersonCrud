package ru.trandefil.tm.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tasks")
public class Task extends BaseNamedEntity {

    private String description;

    private Date begin;

    private Date end;

    @ManyToOne(fetch = FetchType.EAGER)
    private Project project;

    @ManyToOne(fetch = FetchType.EAGER)
    private User assignee;

    @ManyToOne(fetch = FetchType.EAGER)
    private User executor;

    public Task() {
    }

    public Task(String id, String name, String description, Date begin, Date end, Project project, User assignee, User executor) {
        super(id, name);
        this.description = description;
        this.begin = begin;
        this.end = end;
        this.project = project;
        this.assignee = assignee;
        this.executor = executor;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    public User getExecutor() {
        return executor;
    }

    public void setExecutor(User executor) {
        this.executor = executor;
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

    @Override
    public String toString() {
        return "Task{" +
                "project=" + project +
                ", assignee=" + assignee +
                ", executor=" + executor +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

}
