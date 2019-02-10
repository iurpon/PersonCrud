package ru.trandefil.tm.command.databin;

import ru.trandefil.tm.api.ProjectService;
import ru.trandefil.tm.api.TaskService;
import ru.trandefil.tm.api.UserService;
import ru.trandefil.tm.command.AbstractCommand;
import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.entity.Task;
import ru.trandefil.tm.entity.User;

import java.io.*;
import java.util.List;

public class DataBinSaveCommand extends AbstractCommand {

    @Override
    public String command() {
        return "data-bin-save";
    }

    @Override
    public String description() {
        return "store data to bin file";
    }

    @Override
    public void execute() {
/*        try(OutputStream outputStream = new FileOutputStream("data.bin")){
            final ProjectService projectService = getServiceLocator().getProjectService();
            final UserService userService = getServiceLocator().getUserService();
            final TaskService taskService = getServiceLocator().getTaskService();
            List<Project> projectList = projectService.getAll();
            List<User> userList = userService.getAll();
            List<Task> taskList = taskService.getAll();
            Project[] projectArray = new Project[projectList.size()];
            User[] userArray = new User[userList.size()];
            Task[] taskArray = new Task[taskList.size()];
            projectList.toArray(projectArray);
            userList.toArray(userArray);
            taskList.toArray(taskArray);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("data.bin"));
            objectOutputStream.writeObject(projectArray);
            objectOutputStream.writeObject(userArray);
            objectOutputStream.writeObject(taskArray);
            objectOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }*/
    }

    @Override
    public boolean secure() {
        return true;
    }

}
