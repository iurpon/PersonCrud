package ru.trandefil.tm.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "tasks")
public class Task extends BaseNamedEntity {

    private String description;

    private Date begin;

    private Date end;

    @OneToOne(fetch = FetchType.EAGER)
    private Project projectId;

    @OneToOne(fetch = FetchType.EAGER)
    private User assigneeId;

    @OneToOne(fetch = FetchType.EAGER)
    private User executorId;

    public Task() {
    }

    public Task(String id, String name, String description, Date begin, Date end,
                Project projectId, User assigneeId, User executorId) {
        super(id, name);
        this.description = description;
        this.begin = begin;
        this.end = end;
        this.projectId = projectId;
        this.assigneeId = assigneeId;
        this.executorId = executorId;
    }

    public Project getProjectId() {
        return projectId;
    }

    public void setProjectId(Project projectId) {
        this.projectId = projectId;
    }

    public User getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(User assigneeId) {
        this.assigneeId = assigneeId;
    }

    public User getExecutorId() {
        return executorId;
    }

    public void setExecutorId(User executorId) {
        this.executorId = executorId;
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
