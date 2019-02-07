package ru.trandefil.tm;

import org.reflections.Reflections;
import ru.trandefil.tm.api.ServiceLocator;
import ru.trandefil.tm.api.User;
import ru.trandefil.tm.command.AbstractCommand;
import ru.trandefil.tm.service.TerminalService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ClientBootstrap implements ServiceLocator {

    private User loggedUser = null;

    private final TerminalService terminalService = new TerminalService(new Scanner(System.in));

    private final Map<String, AbstractCommand> commandMap = new HashMap<>();

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    @Override
    public Map<String, AbstractCommand> getCommandMap() {
        return commandMap;
    }

    @Override
    public TerminalService getTerminalService() {
        return this.terminalService;
    }

    private void getClassesAndFillMap(String packageInfo) {
        Reflections refilections = new Reflections(packageInfo);
        Set<Class<? extends AbstractCommand>> subTypes = refilections.getSubTypesOf(AbstractCommand.class);
        subTypes.forEach(cl -> {
            try {
                AbstractCommand ac = cl.newInstance();
                ac.setServiceLocator(this);
                commandMap.put(ac.command(), ac);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }

    public void init() {
        getClassesAndFillMap("ru.trandefil.tm.command");
        System.out.println("enter help to see commands.");
        while (true) {
            final String s = terminalService.nextLine();
            final AbstractCommand abstractCommand = commandMap.get(s);
            if (abstractCommand == null) {
                System.out.println("Bad command.");
                continue;
            }
            if (!abstractCommand.secure()) {
                abstractCommand.execute();
                continue;
            }
            if (loggedUser == null) {
                final AbstractCommand loginCommand = commandMap.get("login");
                loginCommand.execute();
            }
            if(loggedUser == null){
                continue;
            }
            abstractCommand.execute();
        }
    }

}
