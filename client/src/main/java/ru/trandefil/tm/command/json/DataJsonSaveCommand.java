package ru.trandefil.tm.command.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.trandefil.tm.command.AbstractCommand;
import ru.trandefil.tm.generated.*;

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
        final ProjectEndPoint projectEndPoint = getServiceLocator().getProjectEndPoint();
        final UserEndPoint userEndPoint = getServiceLocator().getUserEndPoint();
        final TaskEndPoint taskEndPoint = getServiceLocator().getTaskEndPoint();
        final Session session = getServiceLocator().getSession();
        final List<Project> projectList = projectEndPoint.getAllProjects(session);
        final List<User> userList = userEndPoint.getAllUsers(session);
        final List<Task> taskList = taskEndPoint.getAllTasks(session);
        final Domain objectFactory = new Domain();
   /*    objectFactory.
         objectFactory.setTaskList(taskList);
        objectFactory.setUserList(userList);*/
        final ObjectMapper objectMapper = new ObjectMapper();
        try {
            final String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectFactory);
            Files.write(Paths.get("data.json"), json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean secure() {
        return false;
    }

}
