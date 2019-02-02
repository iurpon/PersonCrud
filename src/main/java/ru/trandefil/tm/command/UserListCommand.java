package ru.trandefil.tm.command;

import ru.trandefil.tm.entity.User;
import ru.trandefil.tm.locator.ServiceLocator;
import ru.trandefil.tm.service.UserService;

import java.util.List;

public class UserListCommand extends AbstractCommand {
    public UserListCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    @Override
    public String command() {
        return "user-list";
    }

    @Override
    public String description() {
        return "show all users";
    }

    @Override
    public void execute() {
        final UserService userService = serviceLocator.getUserService();
        final List<User> userList = userService.getAll();
        userList.forEach(System.out::println);
    }
}
