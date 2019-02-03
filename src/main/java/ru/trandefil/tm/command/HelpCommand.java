package ru.trandefil.tm.command;

import ru.trandefil.tm.api.ServiceLocator;

import java.util.Map;

public class HelpCommand extends AbstractCommand {

    private Map<String,AbstractCommand> abstractCommandMap;

    public HelpCommand(ServiceLocator serviceLocator, Map<String, AbstractCommand> abstractCommandMap) {
        super(serviceLocator);
        this.abstractCommandMap = abstractCommandMap;
    }

    @Override
    public String command() {
        return "help";
    }

    @Override
    public String description() {
        return "return list of commands";
    }

    @Override
    public void execute() {
        if(abstractCommandMap != null){
            abstractCommandMap.keySet().forEach(System.out::println);
            return;
        }
    }

    @Override
    public boolean secure() {
        return false;
    }

}
