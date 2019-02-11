package ru.trandefil.tm.command.task;

import ru.trandefil.tm.command.AbstractCommand;
import ru.trandefil.tm.api.ServiceLocator;

import static ru.trandefil.tm.util.HashUtil.getNotNullString;

public class TaskListCommand extends AbstractCommand {

    public TaskListCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    public TaskListCommand() {
    }

    @Override
    public String command() {
        return "task-list";
    }

    @Override
    public String description() {
        return "get all tasks from  a project";
    }

    @Override
    public void execute() {
/*        final TerminalService terminalService = getServiceLocator().getTerminalService();
        final TaskService taskService = getServiceLocator().getTaskService();
        final List<Task> collect = taskService.getAll()
                .stream()
                .filter(t -> t.getExecuter().equals(getServiceLocator().getSession()))
                .collect(Collectors.toList());
        collect.forEach(System.out::println);*/
    }

    @Override
    public boolean secure() {
        return true;
    }

}
