package ru.trandefil.tm.command;

import ru.trandefil.tm.entity.User;
import ru.trandefil.tm.api.ServiceLocator;
import ru.trandefil.tm.api.UserService;

import java.util.List;

public class UserListCommand extends AbstractCommand {

    public UserListCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    public UserListCommand() {
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
        final UserService userService = getServiceLocator().getUserService();
        final List<User> userList = userService.getAll();
        userList.forEach(System.out::println);
    }

    @Override
    public boolean secure() {
        return true;
    }

}
