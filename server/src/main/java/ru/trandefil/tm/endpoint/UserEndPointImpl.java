package ru.trandefil.tm.endpoint;

import ru.trandefil.tm.api.UserService;
import ru.trandefil.tm.entity.User;
import ru.trandefil.tm.generated.UserEndPoint;
import ru.trandefil.tm.repository.UserRepositoryImpl;
import ru.trandefil.tm.service.UserServiceImpl;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.List;

@WebService(endpointInterface = "ru.trandefil.tm.generated.UserEndPoint")
public class UserEndPointImpl implements UserEndPoint {

    private UserService userService;

    public UserEndPointImpl(UserService userService) {
        this.userService = userService;
    }

    public UserEndPointImpl() {
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User delete(User user) {
        return userService.delete(user);
    }

    @Override
    public User deleteByName(String name) {
        return userService.deleteByName(name);
    }

    @Override
    public User save(User user) {
        return userService.save(user);
    }

    @Override
    public User getByName(String userName) {
        return userService.getByName(userName);
    }

    @Override
    public List<User> getAll() {
        return userService.getAll();
    }

    @Override
    public void publish() {
        Endpoint.publish("http://localhost:8080/userEndPoint?wsdl",this);
    }

    public static void main(String[] args){
        Endpoint.publish("http://localhost:8080/userEndPoint?wsdl",new UserEndPointImpl(new UserServiceImpl(new UserRepositoryImpl())));
    }

}
