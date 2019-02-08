package ru.trandefil.tm.endpoint;

import ru.trandefil.tm.api.UserService;
import ru.trandefil.tm.entity.User;
import ru.trandefil.tm.generated.UserEndPoint;

import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "ru.trandefil.tm.generated.UserEndPoint")
public class UserEndPointImpl  implements UserEndPoint {

    private UserService userService;

    public UserEndPointImpl(UserService userService) {
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

}
