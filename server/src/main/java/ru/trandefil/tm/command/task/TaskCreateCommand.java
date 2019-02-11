package ru.trandefil.tm.command.task;

import ru.trandefil.tm.api.ServiceLocator;
import ru.trandefil.tm.command.AbstractCommand;

import static ru.trandefil.tm.util.HashUtil.getDate;
import static ru.trandefil.tm.util.HashUtil.getNotNullString;

public class TaskCreateCommand extends AbstractCommand {

    public TaskCreateCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    public TaskCreateCommand() {
    }

    @Override
    public String command() {
        return "task-create";
    }

    @Override
    public String description() {
        return "create new task for project";
    }

    @Override
    public void execute() {
/*        final TerminalService terminalService = getServiceLocator().getTerminalService();
        final String projectName =
                getNotNullString(terminalService, "enter project name to add new task :");
        final ProjectService projectService = getServiceLocator().getProjectService();
        final Project project = projectService.getById(projectName);
        if (project == null) {
            System.out.println("Wrong project name");
            return;
        }
        final String taskName = getNotNullString(terminalService, "Enter task name");
        final String taskDesc = getNotNullString(terminalService, "Enter task description");
        final Date taskBegin = getDate(terminalService, "task start ");
        Date taskEnd = null;
        if (taskBegin != null) {
            taskEnd = getDate(terminalService, "task end");
        }
        final Task newTask = new Task(UUIDUtil.getUniqueString(), taskName, taskDesc, taskBegin, taskEnd, project);
        newTask.setAssignee(getServiceLocator().getLoggedUser());
        final String executerUser = getNotNullString(terminalService,"which user will execute this task");
        final UserService userService = getServiceLocator().getUserService();
        final User executer = userService.getByName(executerUser);
        if(executer == null){
            System.out.println("wrong user name.");
            return;
        }
        newTask.setExecuter(executer);
        final TaskService taskService = getServiceLocator().getTaskService();
        taskService.save(newTask);*/
    }

    @Override
    public boolean secure() {
        return true;
    }

}
