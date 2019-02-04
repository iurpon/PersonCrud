package ru.trandefil.tm.command;

import ru.trandefil.tm.entity.Task;
import ru.trandefil.tm.api.ServiceLocator;
import ru.trandefil.tm.api.TaskService;
import ru.trandefil.tm.service.TerminalService;

import java.util.List;
import java.util.stream.Collectors;

import static ru.trandefil.tm.util.UserInputUtil.getNotNullString;

public class TaskListCommand extends AbstractCommand {

    public TaskListCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    @Override
    public AbstractCommand getInstance() {
        return new TaskListCommand(getServiceLocator());
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
        final TerminalService terminalService = getServiceLocator().getTerminalService();
        final String projectName =
                getNotNullString(terminalService, "Enter the project name to see tasks:");
        final TaskService taskService = getServiceLocator().getTaskService();
        final List<Task> collect = taskService.getAll().stream().filter(t -> t.getProject().getName().equals(projectName))
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    @Override
    public boolean secure() {
        return true;
    }

}
