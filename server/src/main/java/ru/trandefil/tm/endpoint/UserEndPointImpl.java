package ru.trandefil.tm.endpoint;

import ru.trandefil.tm.api.UserService;
import ru.trandefil.tm.entity.Session;
import ru.trandefil.tm.entity.User;
import ru.trandefil.tm.generated.UserEndPoint;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "ru.trandefil.tm.generated.UserEndPoint")
public class UserEndPointImpl implements UserEndPoint {

    private UserService userService;

    public UserEndPointImpl(UserService userService) {
        this.userService = userService;
    }

    @WebMethod
    @Override
    public User deleteUser(User user, Session session) {
        return userService.delete(user,session);
    }

    @WebMethod
    @Override
    public User deleteUserByName(String name,Session session) {
        return userService.deleteByName(name,session);
    }

    @WebMethod
    @Override
    public User saveUser(User user,Session session) {
        return userService.save(user,session);
    }

    @WebMethod
    @Override
    public User getUserByName(String userName,Session session) {
        return userService.getByName(userName,session);
    }

    @WebMethod
    @Override
    public List<User> getAllUsers(Session session) {
        return userService.getAll(session);
    }

    @WebMethod
    @Override
    public Session getSession(String userName, String password) {
        return userService.getSession(userName, password);
    }

}
