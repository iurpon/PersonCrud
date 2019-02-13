package ru.trandefil.tm.endpoint;

import ru.trandefil.tm.api.UserService;
import ru.trandefil.tm.entity.Role;
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

    @Override
    @WebMethod
    public User deleteUserByName(String name, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            return null;
        }
        User removing = userService.getByName(name);
        if(removing == null){
            return null;
        }
        if (!session.getRole().equals(Role.ADMIN) && !removing.getId().equals(session.getUserId())) {
            System.out.println("not authorized  to delete user.");
            return null;
        }
        userService.delete(removing);
        return removing;
    }

    @Override
    @WebMethod
    public User saveUser(String name, String pass, String role, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            return null;
        }
        if (!session.getRole().equals(Role.ADMIN)) {
            System.out.println("not authorized  to create new user.");
            return null;
        }
        return userService.constractUser(name,pass,role);
    }

    @Override
    @WebMethod
    public User getUserByName(String userName, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            return null;
        }
        return userService.getByName(userName);
    }

    @Override
    @WebMethod
    public List<User> getAllUsers(Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            return null;
        }
        return userService.getAll();
    }

    @Override
    @WebMethod
    public Session getSession(String userName, String password) {
        return userService.getSession(userName, password);
    }

    @Override
    @WebMethod
    public void userLogout(Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            return;
        }
        userService.logout(session.getId());
    }

    @Override
    @WebMethod
    public User updateUser(User user, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            return null;
        }
        if (!session.getRole().equals(Role.ADMIN) && !user.getId().equals(session.getUserId())) {
            System.out.println("not authorized  to update this user.");
            return null;
        }
        return userService.save(user);
    }
}
