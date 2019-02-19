package ru.trandefil.tm.domain.user;

import ru.trandefil.tm.api.ServiceLocator;
import ru.trandefil.tm.domain.AbstractCommand;
import ru.trandefil.tm.generated.Session;
import ru.trandefil.tm.generated.User;
import ru.trandefil.tm.generated.UserEndPoint;
import ru.trandefil.tm.service.TerminalService;

import static ru.trandefil.tm.util.UserInputUtil.getNotNullString;

public class UserDeleteCommand extends AbstractCommand {

    public UserDeleteCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    public UserDeleteCommand() {
    }

    @Override
    public String command() {
        return "user-delete";
    }

    @Override
    public String description() {
        return "delete user.";
    }

    @Override
    public void execute() {
        final UserEndPoint userEndPoint = getServiceLocator().getUserEndPoint();
        final Session session = getServiceLocator().getSession();
        final TerminalService terminalService = getServiceLocator().getTerminalService();
        final String userName = getNotNullString(terminalService, "enter user name to delete");
        final User deleting = userEndPoint.deleteUserByName(userName, session);
        if (deleting == null) {
            System.out.println("bad user name.");
            return;
        }
        if(deleting.getId().equals(session.getUserId())){
            getServiceLocator().setSession(null);
        }
        System.out.println("user deleted succefully");
    }

    @Override
    public boolean secure() {
        return true;
    }

    @Override
    public boolean isAdmin() {
        return true;
    }

}
