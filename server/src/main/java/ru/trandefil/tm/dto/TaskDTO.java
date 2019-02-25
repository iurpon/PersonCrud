package ru.trandefil.tm.dto;

import ru.trandefil.tm.entity.Task;

import java.util.Date;

public class TaskDTO {

    private String id;

    private String name;

    private String description;

    private Date begin;

    private Date end;

    private String  projectName;

    private String assigneeName;

    private String executorName;

    public TaskDTO(Task task) {
        this.id = task.getId();
        this.name = task.getName();
        this.description = task.getDescription();
        this.begin = task.getBegin();
        this.end = task.getEnd();
        this.projectName = task.getProject().getName();
        this.assigneeName = task.getAssignee().getName();
        this.executorName = task.getExecutor().getName();
    }

    public TaskDTO() {
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getAssigneeName() {
        return assigneeName;
    }

    public void setAssigneeName(String assigneeName) {
        this.assigneeName = assigneeName;
    }

    public String getExecutorName() {
        return executorName;
    }

    public void setExecutorName(String executorName) {
        this.executorName = executorName;
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

}
