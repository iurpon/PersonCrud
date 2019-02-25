package ru.trandefil.tm.api;

import ru.trandefil.tm.dto.UserDTO;
import ru.trandefil.tm.entity.Session;
import ru.trandefil.tm.entity.User;

import java.util.List;

public interface UserService {

    User getRefById(String id);

    User getById(String id);

    void delete(User user);

    boolean deleteByName(String name);

    UserDTO save(UserDTO user);

    UserDTO getByName(String userName);

    List<UserDTO> getAll();

    Session getSession(String userName, String userPassword);

    void logout(String sessionId);

    UserDTO constractUser(String name, String pass, String role);

}
