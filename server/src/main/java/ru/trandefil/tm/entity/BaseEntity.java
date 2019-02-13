package ru.trandefil.tm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public abstract class BaseEntity implements Serializable {

    protected String id;


    public BaseEntity() {
    }

    public BaseEntity(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonIgnore
    public boolean isNew(){
        return id == null;
    }

}
