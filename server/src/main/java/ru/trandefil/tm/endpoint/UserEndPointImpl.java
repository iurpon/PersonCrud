package ru.trandefil.tm.endpoint;

import ru.trandefil.tm.api.UserService;
import ru.trandefil.tm.entity.Session;
import ru.trandefil.tm.entity.User;
import ru.trandefil.tm.generated.UserEndPoint;
import ru.trandefil.tm.util.SignatureUtil;

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
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            return null;
        }
        return userService.delete(user, session);
    }

    @WebMethod
    @Override
    public User deleteUserByName(String name, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            return null;
        }
        return userService.deleteByName(name, session);
    }

    @WebMethod
    @Override
    public User saveUser(User user, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            return null;
        }
        return userService.save(user, session);
    }

    @WebMethod
    @Override
    public User getUserByName(String userName, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            return null;
        }
        return userService.getByName(userName, session);
    }

    @WebMethod
    @Override
    public List<User> getAllUsers(Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            return null;
        }
        return userService.getAll(session);
    }

    @WebMethod
    @Override
    public Session getSession(String userName, String password) {
        return userService.getSession(userName, password);
    }

    @Override
    public void userLogout(Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            return;
        }
        userService.logout(session.getId());
    }
}
