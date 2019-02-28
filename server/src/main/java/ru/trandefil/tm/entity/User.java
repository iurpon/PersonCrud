package ru.trandefil.tm.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Table(name = "users")
@Entity
public class User extends BaseNamedEntity {

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Project> projects = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "assignee")
    private List<Task> assignerTasks = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "executor")
    private List<Task> executorTasks = new ArrayList<>();

    public User() {
    }

    public User(String id, String name, String password, Role role) {
        super(id, name);
        this.password = password;
        this.role = role;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "role=" + role +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
