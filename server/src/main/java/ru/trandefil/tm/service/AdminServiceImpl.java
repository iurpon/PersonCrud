package ru.trandefil.tm.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.trandefil.tm.api.AdminService;
import ru.trandefil.tm.api.ProjectService;
import ru.trandefil.tm.api.TaskService;
import ru.trandefil.tm.api.UserService;
import ru.trandefil.tm.command.Domain;
import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.entity.Task;
import ru.trandefil.tm.entity.User;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AdminServiceImpl implements AdminService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private ProjectService projectService;

    private UserService userService;

    private TaskService taskService;

    public AdminServiceImpl(ProjectService projectService, UserService userService, TaskService taskService) {
        this.projectService = projectService;
        this.userService = userService;
        this.taskService = taskService;
    }

    @Override
    public void saveBin() {
        try(OutputStream outputStream = new FileOutputStream("data.bin")){
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
        }
    }

    @Override
    public void loadBin() {
    }

    @Override
    public void saveXml() {

    }

    @Override
    public void loadXml() {
/*         try {
           final String xmlString = new String(Files.readAllBytes(Paths.get("data.xml")));
            final ObjectMapper objectMapper = new XmlMapper();
            final Domain objectFactory = objectMapper.readValue(xmlString, Domain.class);
            return objectFactory;
        } catch (IOException e) {
            logger.info("data is empty.");
            e.printStackTrace();
        }       */
    }

    @Override
    public void saveJson() {

    }

    @Override
    public void loadJson() {
/*        try {
            final ObjectMapper objectMapper = new ObjectMapper();
            final String xmlString = new String(Files.readAllBytes(Paths.get("data.json")));
            final Domain objectFactory = objectMapper.readValue(xmlString, Domain.class);
            return objectFactory;
        } catch (IOException e) {
            System.out.println("is empty.");
            e.printStackTrace();
        }
        return null;*/
    }

    @Override
    public void clearBin() {
        File file = new File("data.bin");
        file.delete();
    }

    @Override
    public void clearXml() {
        File file = new File("data.xml");
        file.delete();
    }

    @Override
    public void clearJson() {
        File file = new File("data.json");
        file.delete();
    }

}
