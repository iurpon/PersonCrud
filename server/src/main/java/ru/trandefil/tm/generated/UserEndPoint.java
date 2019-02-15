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
    User deleteUserByName(@WebParam(name = "name") String name, @WebParam(name = "session") Session session);

    @WebMethod
    User updateUser(@WebParam(name = "user") User user, @WebParam(name = "session") Session session);

    @WebMethod
    User saveUser(@WebParam(name = "name") String name,
                  @WebParam(name = "pass") String pass,
                  @WebParam(name = "role") String role,
                  @WebParam Session session);

    @WebMethod
    User getUserByName(@WebParam(name = "name") String name, @WebParam(name = "session") Session session);

    @WebMethod
    List<User> getAllUsers(@WebParam(name = "session") Session session);

    @WebMethod
    void userLogout(@WebParam(name = "session") Session session);

    @WebMethod
    Session getSession(@WebParam(name = "userName") String userName, @WebParam(name = "password") String password);

    @WebMethod
    Session registry(@WebParam(name = "userName") String userName, @WebParam(name = "password") String password);

}
