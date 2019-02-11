package ru.trandefil.tm.generated;

import ru.trandefil.tm.entity.Session;
import ru.trandefil.tm.entity.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface UserEndPoint {

    @WebMethod
    User deleteUser(@WebParam(name = "user") User user, @WebParam(name = "session") Session session);

    @WebMethod
    User deleteUserByName(@WebParam(name = "name") String name, @WebParam(name = "session") Session session);

    @WebMethod
    User saveUser(@WebParam(name = "user") User user, @WebParam(name = "session") Session session);

    @WebMethod
    User getUserByName(@WebParam(name = "name") String name, @WebParam(name = "session") Session session);

    @WebMethod
    List<User> getAllUsers(@WebParam(name = "session") Session session);

    @WebMethod
    Session getSession(@WebParam(name = "userName") String userName, @WebParam(name = "password") String password);

}
