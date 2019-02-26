package ru.trandefil.tm.command.task;

import ru.trandefil.tm.api.ServiceLocator;
import ru.trandefil.tm.command.AbstractCommand;
import ru.trandefil.tm.generated.Session;
import ru.trandefil.tm.generated.Task;
import ru.trandefil.tm.generated.TaskDTO;
import ru.trandefil.tm.generated.TaskEndPoint;

import java.util.List;

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
        final TaskEndPoint taskEndPoint = getServiceLocator().getTaskEndPoint();
        final Session session = getServiceLocator().getSession();
        final List<TaskDTO> tasks = taskEndPoint.getAllTasks(session);
        if(tasks == null && tasks.size()== 0){
            System.out.println("no tasks for you.");
            return;
        }
        tasks.forEach(System.out::println);
    }

    @Override
    public boolean secure() {
        return true;
    }

}
