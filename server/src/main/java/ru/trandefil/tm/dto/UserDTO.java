package ru.trandefil.tm.dto;

import ru.trandefil.tm.entity.Role;
import ru.trandefil.tm.entity.User;

public class UserDTO {

    private String id;

    private String name;

    private String password;

    private Role role;

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.password = user.getPassword();
        this.role = user.getRole();
    }

    public UserDTO(String id, String name, String password, Role role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
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
}
