package ru.trandefil.tm.generated;

import ru.trandefil.tm.api.PublishEndPoint;
import ru.trandefil.tm.entity.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface UserEndPoint extends PublishEndPoint {

    @WebMethod
    User deleteUser(@WebParam(name = "user") User user);

    @WebMethod
    User deleteUserByName(@WebParam(name = "name") String name);

    @WebMethod
    User saveUser(@WebParam(name = "user") User user);

    @WebMethod
    User getUserByName(@WebParam(name = "name") String name);

    @WebMethod
    List<User> getAllUsers();

}
