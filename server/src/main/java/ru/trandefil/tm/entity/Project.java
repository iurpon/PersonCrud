package ru.trandefil.tm.entity;

import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import java.util.Objects;

public class Project extends BaseNamedEntity {

    private static final long serialVersionUID = 1L;

    private String description;

    @OneToOne(fetch = FetchType.EAGER)
    private User user;

    public Project() {
    }

    public Project(String id, String name) {
        super(id, name);
    }

    public Project(String id, String name, String description) {
        super(id, name);
        this.description = description;
    }

    public Project(String id, String name, String description, User user) {
        super(id, name);
        this.description = description;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return name.equals(project.name) &&
                description.equals(project.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }

}
