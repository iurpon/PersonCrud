package ru.trandefil.tm.entity;

import ru.trandefil.tm.util.UserXmlAdapter;

import javax.persistence.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@Entity
@Table(name = "projects")
public class Project extends BaseNamedEntity {

    private String description;

    @OneToOne(fetch = FetchType.EAGER)
    @MapsId
//    @XmlJavaTypeAdapter(UserXmlAdapter.class)
    private User user;

    public Project() {
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

}
