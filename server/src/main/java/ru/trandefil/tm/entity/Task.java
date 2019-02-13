package ru.trandefil.tm.entity;

import java.util.Date;

public class Task extends BaseNamedEntity {

    private static final long serialVersionUID = 2L;

    private String description;

    private Date begin;

    private Date end;

    private String projectId;

    private String assigneeId;

    private String executerId;

    public Task() {
    }

    public Task(String id, String name, String description, Date begin, Date end, String projectId, String assigneeId, String executerId) {
        super(id, name);
        this.description = description;
        this.begin = begin;
        this.end = end;
        this.projectId = projectId;
        this.assigneeId = assigneeId;
        this.executerId = executerId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(String assigneeId) {
        this.assigneeId = assigneeId;
    }

    public String getExecuterId() {
        return executerId;
    }

    public void setExecuterId(String executerId) {
        this.executerId = executerId;
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
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
