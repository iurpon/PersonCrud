package ru.trandefil.tm.command.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.trandefil.tm.api.ProjectService;
import ru.trandefil.tm.api.TaskService;
import ru.trandefil.tm.api.UserService;
import ru.trandefil.tm.command.AbstractCommand;
import ru.trandefil.tm.command.Domain;
import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.entity.Task;
import ru.trandefil.tm.entity.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DataJsonSaveCommand extends AbstractCommand {

    @Override
    public String command() {
        return "data-json-save";
    }

    @Override
    public String description() {
        return "convert object to json and save it to file.";
    }

    @Override
    public void execute() {
/*        final ProjectService projectService = getServiceLocator().getProjectService();
        final TaskService taskService = getServiceLocator().getTaskService();
        final UserService userService = getServiceLocator().getUserService();
        final List<Project> projectList = projectService.getAll();
        final List<User> userList = userService.getAll();
        final List<Task> taskList = taskService.getAll();
        final Domain objectFactory = new Domain();
        objectFactory.setProjectList(projectList);
        objectFactory.setTaskList(taskList);
        objectFactory.setUserList(userList);
        final ObjectMapper objectMapper = new ObjectMapper();
        try {
            final String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectFactory);
            Files.write(Paths.get("data.json"), json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }


    @Override
    public boolean secure() {
        return true;
    }

}
