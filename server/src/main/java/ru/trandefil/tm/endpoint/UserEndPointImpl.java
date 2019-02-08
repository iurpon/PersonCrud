package ru.trandefil.tm.endpoint;

import ru.trandefil.tm.api.UserService;
import ru.trandefil.tm.entity.User;
import ru.trandefil.tm.generated.UserEndPoint;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.List;

@WebService(endpointInterface = "ru.trandefil.tm.generated.UserEndPoint")
public class UserEndPointImpl implements UserEndPoint {

    private UserService userService;

    public UserEndPointImpl(UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @WebMethod
    @Override
    public User delete(User user) {
        return userService.delete(user);
    }

    @WebMethod
    @Override
    public User deleteByName(String name) {
        return userService.deleteByName(name);
    }

    @WebMethod
    @Override
    public User save(User user) {
        return userService.save(user);
    }

    @WebMethod
    @Override
    public User getByName(String userName) {
        return userService.getByName(userName);
    }

    @WebMethod
    @Override
    public List<User> getAll() {
        return userService.getAll();
    }


    @Override
    public void publish() {
        Endpoint endpoint = Endpoint.create(this);
        endpoint.publish("http://localhost:8080/userEndPoint?wsdl");

    }

}
