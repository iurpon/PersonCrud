package ru.trandefil.tm.command.user;

import ru.trandefil.tm.api.ServiceLocator;
import ru.trandefil.tm.command.AbstractCommand;
import ru.trandefil.tm.generated.Session;
import ru.trandefil.tm.generated.User;
import ru.trandefil.tm.generated.UserDTO;
import ru.trandefil.tm.generated.UserEndPoint;

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
        final UserEndPoint userEndPoint = getServiceLocator().getUserEndPoint();
        final Session session = getServiceLocator().getSession();
        final List<UserDTO> userList = userEndPoint.getAllUsers(session);
        if(userList.isEmpty()){
            System.out.println("list is empty");
            return;
        }
        userList.forEach(System.out::println);
    }

    @Override
    public boolean secure() {
        return true;
    }

    @Override
    public boolean isAdmin() {
        return false;
    }
}
