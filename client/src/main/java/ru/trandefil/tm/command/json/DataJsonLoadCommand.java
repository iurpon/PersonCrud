package ru.trandefil.tm.command.json;

import ru.trandefil.tm.command.AbstractCommand;
import ru.trandefil.tm.generated.FileEndPoint;

public class DataJsonLoadCommand extends AbstractCommand {

    @Override
    public String command() {
        return "data-json-load";
    }

    @Override
    public String description() {
        return "load json from file and covert to Object";
    }

    @Override
    public void execute() {
        final FileEndPoint fileEndPoint = getServiceLocator().getFileEndPoint();
/*        final Domain domain = fileEndPoint.loadJson();
        domain.getProjectList().forEach(System.out::println);
        domain.getTaskList().forEach(System.out::println);
        domain.getUserList().forEach(System.out::println);*/
    }

    @Override
    public boolean secure() {
        return false;
    }

}
