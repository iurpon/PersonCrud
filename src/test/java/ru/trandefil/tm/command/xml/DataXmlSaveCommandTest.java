package ru.trandefil.tm.command.xml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Test;
import ru.trandefil.tm.api.ProjectService;
import ru.trandefil.tm.api.TaskService;
import ru.trandefil.tm.api.UserService;
import ru.trandefil.tm.command.Domain;
import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.entity.Task;
import ru.trandefil.tm.entity.User;
import ru.trandefil.tm.repository.ProjectRepositoryImpl;
import ru.trandefil.tm.repository.TaskRepositoryImpl;
import ru.trandefil.tm.repository.UserRepositoryImpl;
import ru.trandefil.tm.service.ProjectServiceImpl;
import ru.trandefil.tm.service.TaskServiceImpl;
import ru.trandefil.tm.service.UserServiceImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DataXmlSaveCommandTest {

    @Test
    public void execute() throws IOException {
        final ProjectService projectService = new ProjectServiceImpl(new ProjectRepositoryImpl());
        final UserService userService = new UserServiceImpl(new UserRepositoryImpl());
        final TaskService taskService = new TaskServiceImpl(new TaskRepositoryImpl());
        final List<Project> projectList = projectService.getAll();
        final List<User> userList = userService.getAll();
        final List<Task> taskList = taskService.getAll();
        Domain objectFactory = new Domain();
        objectFactory.setProjectList(projectList);
        objectFactory.setTaskList(taskList);
        objectFactory.setUserList(userList);
        ObjectMapper objectMapper = new XmlMapper();
        String xml = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectFactory);
        Files.write(Paths.get("data.xml"), xml.getBytes());
    }

}