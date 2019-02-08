package ru.trandefil.tm.generated;

import ru.trandefil.tm.entity.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface UserEndPoint {

    @WebMethod
    User delete(@WebParam(name = "user") User user);

    @WebMethod
    User deleteByName(@WebParam(name = "name") String name);

    @WebMethod
    User save(@WebParam(name = "user") User user);

    @WebMethod
    User getByName(@WebParam(name = "userName") String userName);

    @WebMethod
    List<User> getAll();

}
