package ru.trandefil.tm.command;


import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.entity.Task;
import ru.trandefil.tm.locator.AbstractServiceLocator;
import ru.trandefil.tm.service.ProjectService;
import ru.trandefil.tm.service.TaskService;
import ru.trandefil.tm.service.TerminalService;

import java.util.Date;

import static ru.trandefil.tm.util.ValidateUserInput.*;

public class TaskUpdateCommand extends AbstractCommand {
    public TaskUpdateCommand(AbstractServiceLocator abstractServiceLocator) {
        super(abstractServiceLocator);
    }

    @Override
    public String command() {
        return "task-update";
    }

    @Override
    public String description() {
        return "update a project task";
    }

    @Override
    public void execute() {
        TerminalService terminalService = abstractServiceLocator.getTermanalService();
        String projectName = getNotNullString(terminalService,"Enter project name : ");
        ProjectService projectService = abstractServiceLocator.getProjectService();
        Project project = projectService.getByName(projectName);
        if(project == null){
            System.out.println("Wrong project name.");
            return;
        }else{
            String taskName = getNotNullString(terminalService,"Enter task name for update : ");
            TaskService taskService = abstractServiceLocator.getTaskService();
            Task task = taskService.getByName(taskName);
            if(task == null){
                System.out.println("Wrong task name");
                return;
            }else{
                String newName = getNotNullString(terminalService,"Enter new Task name :");
                String newDescription = getNotNullString(terminalService,"Enter new Task descrip:");
                Date beginDate = getDate(terminalService,"begin date");
                Date endDate = getDate(terminalService,"end date");
                Task newTask = new Task(task.getId(),newName,newDescription,beginDate,endDate,project);
                taskService.deleteByName(task.getName());
                taskService.save(newTask);
            }
        }
    }
}
