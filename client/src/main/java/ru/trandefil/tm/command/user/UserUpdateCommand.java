package ru.trandefil.tm.command.user;

import ru.trandefil.tm.api.ServiceLocator;
import ru.trandefil.tm.command.AbstractCommand;
import ru.trandefil.tm.generated.Session;
import ru.trandefil.tm.generated.User;
import ru.trandefil.tm.generated.UserEndPoint;
import ru.trandefil.tm.service.TerminalService;
import ru.trandefil.tm.util.UserInputUtil;

import static ru.trandefil.tm.util.UserInputUtil.getNotNullString;

public class UserUpdateCommand extends AbstractCommand {

    public UserUpdateCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    public UserUpdateCommand() {
    }

    @Override
    public String command() {
        return "user-update";
    }

    @Override
    public String description() {
        return "update user";
    }

    @Override
    public void execute() {
        final UserEndPoint userEndPoint = getServiceLocator().getUserEndPoint();
        final Session session = getServiceLocator().getSession();
        final TerminalService terminalService = getServiceLocator().getTerminalService();
        final String userName = getNotNullString(terminalService,"enter user name to update");
        final User updating = userEndPoint.getUserByName(userName,session);
        if(updating == null){
            System.out.println("Wrong user name.");
            return;
        }
        if(updating.getId().equals(session.getUserId())){
            final String newName = getNotNullString(terminalService,"enter new name");
            final String newPass = getNotNullString(terminalService,"enter new pass");
            updating.setName(newName);
            updating.setPassword(newPass);
//            userEndPoint
        }
    }

    @Override
    public boolean secure() {
        return true;
    }

}
