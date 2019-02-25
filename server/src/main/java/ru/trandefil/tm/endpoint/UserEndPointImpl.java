package ru.trandefil.tm.endpoint;

import ru.trandefil.tm.api.UserService;
import ru.trandefil.tm.dto.UserDTO;
import ru.trandefil.tm.entity.Role;
import ru.trandefil.tm.entity.Session;
import ru.trandefil.tm.entity.User;
import ru.trandefil.tm.exception.SecurityAuthentificationException;
import ru.trandefil.tm.exception.SecurityAuthorizationException;
import ru.trandefil.tm.generated.UserEndPoint;
import ru.trandefil.tm.util.HashUtil;
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
    public boolean deleteUserByName(String name, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            throw new SecurityAuthentificationException("security authentification exception.");
        }
        if (!session.getRole().equals(Role.ADMIN)) {
            System.out.println("not authorized  to delete user.");
            throw new SecurityAuthorizationException("no permitting for execution.");
        }
        return userService.deleteByName(name) ;
    }

    @Override
    @WebMethod
    public UserDTO saveUser(String name, String pass, String role, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            throw new SecurityAuthentificationException("security authentification exception.");
        }
        if (!session.getRole().equals(Role.ADMIN)) {
            System.out.println("not authorized  to create new user.");
            throw new SecurityAuthorizationException("no permitting for execution.");
        }
        return userService.constractUser(name, pass, role);
    }

    @Override
    @WebMethod
    public UserDTO getUserByName(String userName, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            throw new SecurityAuthentificationException("security authentification exception.");
        }
        return userService.getByName(userName);
    }

    @Override
    @WebMethod
    public List<UserDTO> getAllUsers(Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            throw new SecurityAuthentificationException("security authentification exception.");
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
            throw new SecurityAuthentificationException("security authentification exception.");
        }
        userService.logout(session.getId());
    }

    @Override
    @WebMethod
    public UserDTO updateUser(UserDTO user, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            throw new SecurityAuthentificationException("security authentification exception.");
        }
        if (!session.getRole().equals(Role.ADMIN) && !user.getId().equals(session.getUserId())) {
            System.out.println("not authorized  to update this user.");
            throw new SecurityAuthorizationException("no permitting for execution.");
        }
        return userService.save(user);
    }

    @Override
    public Session registry(String userName, String password) {
//        userService.save(new User(null, userName, HashUtil.hashPassword(password), Role.USER));
        return getSession(userName, password);
    }

}
