package ru.trandefil.tm.command.user;

import ru.trandefil.tm.api.ServiceLocator;
import ru.trandefil.tm.command.AbstractCommand;
import ru.trandefil.tm.generated.Session;
import ru.trandefil.tm.generated.User;
import ru.trandefil.tm.generated.UserEndPoint;
import ru.trandefil.tm.service.TerminalService;
import ru.trandefil.tm.util.UserInputUtil;

import static ru.trandefil.tm.util.UserInputUtil.getNotNullString;

public class UserCreateCommand extends AbstractCommand {

    public UserCreateCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    public UserCreateCommand() {
    }

    @Override
    public String command() {
        return "user-create";
    }

    @Override
    public String description() {
        return "create new user. Admin only";
    }

    @Override
    public void execute() {
        final UserEndPoint userEndPoint = getServiceLocator().getUserEndPoint();
        final Session session = getServiceLocator().getSession();
        final TerminalService terminalService = getServiceLocator().getTerminalService();
        final String userName = getNotNullString(terminalService,"enter user name");
        final String userPass = getNotNullString(terminalService,"enter user password");
        final String userRole = getNotNullString(terminalService,"User role(ADMIN/USER)");
        final User user = userEndPoint.saveUser(userName,userPass,userRole,session);
        if(user == null){
            System.out.println("coudn't create user");
            return;
        }
        System.out.println("created user : " + userName);
    }

    @Override
    public boolean secure() {
        return true;
    }

}
