package ru.trandefil.tm.entity;

import java.io.Serializable;

public abstract class BaseEntity implements Serializable {

    protected String id;

    protected String name;

    public BaseEntity(String id, String name) {
        this.id = id;
        this.name = name;
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

}
