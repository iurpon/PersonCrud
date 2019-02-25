package ru.trandefil.tm.dto;

import java.util.Date;

public class TaskDTO {

    private String id;

    private String name;

    private String description;

    private Date begin;

    private Date end;

    private String projectId;

    private String assigneeId;

    private String executorId;

    public TaskDTO(String id, String name, String description, Date begin, Date end, String projectId, String assigneeId, String executorId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.begin = begin;
        this.end = end;
        this.projectId = projectId;
        this.assigneeId = assigneeId;
        this.executorId = executorId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getExecutorId() {
        return executorId;
    }

    public void setExecutorId(String executorId) {
        this.executorId = executorId;
    }

}
