package ru.trandefil.tm.command.service;

import ru.trandefil.tm.command.AbstractCommand;

public class RegistryCommand extends AbstractCommand {

    public RegistryCommand() {
    }

    @Override
    public String command() {
        return "registry";
    }

    @Override
    public String description() {
        return "registry new user";
    }

    @Override
    public void execute() {
/*        System.out.println("This is registaration form.");
        final TerminalService terminalService = getServiceLocator().getTerminalService();
        final UserService userService = getServiceLocator().getUserService();
        final String userName = getNotNullString(terminalService,"enter your name");
        User user = userService.getByName(userName);
        if(user == null){
            final String userPass = getNotNullString(terminalService,"enter your password");
            final User registred = new User(UUIDUtil.getUniqueString(),userName,userPass);
            userService.save(registred);
            System.out.println("Registry success");
            getServiceLocator().setLoggedUser(registred);
        }
        System.out.println("duplicate name. registry failed.");*/
    }

    @Override
    public boolean secure() {
        return false;
    }

}
