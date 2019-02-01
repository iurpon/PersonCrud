package ru.trandefil.tm.command;

import ru.trandefil.tm.entity.Task;
import ru.trandefil.tm.locator.ServiceLocator;
import ru.trandefil.tm.service.TaskService;
import ru.trandefil.tm.service.TerminalService;

import java.util.List;
import java.util.stream.Collectors;

public class TaskListCommand  extends AbstractCommand{

    public TaskListCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
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
        TerminalService scanner = serviceLocator.getTerminalService();
        System.out.println("Enter the project name to see tasks:");
        String projectName = scanner.nextLine();
        TaskService taskService = serviceLocator.getTaskService();
        List<Task> collect = taskService.getAll().stream().filter(t -> t.getProject().getName().equals(projectName))
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
}
