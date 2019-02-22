package ru.trandefil.tm.entity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseNamedEntity extends BaseEntity {

    protected String name;

    public BaseNamedEntity(String id, String name) {
        super(id);
        this.name = name;
    }

    public BaseNamedEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
