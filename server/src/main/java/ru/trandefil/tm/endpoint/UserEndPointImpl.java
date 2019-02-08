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
    public User deleteUser(User user) {
        return userService.delete(user);
    }

    @WebMethod
    @Override
    public User deleteUserByName(String name) {
        return userService.deleteByName(name);
    }

    @WebMethod
    @Override
    public User saveUser(User user) {
        return userService.save(user);
    }

    @WebMethod
    @Override
    public User getUserByName(String userName) {
        return userService.getByName(userName);
    }

    @WebMethod
    @Override
    public List<User> getAllUsers() {
        return userService.getAll();
    }


    @Override
    public void publish() {
        Endpoint endpoint = Endpoint.create(this);
        endpoint.publish("http://localhost:8080/userEndPoint?wsdl");

    }

}
