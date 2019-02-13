package ru.trandefil.tm.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.trandefil.tm.api.*;
import ru.trandefil.tm.command.Domain;
import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.entity.Task;
import ru.trandefil.tm.entity.User;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AdminServiceImpl implements AdminService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final ProjectService projectService;

    private final UserService userService;

    private final TaskService taskService;

    private final ProjectRepository projectRepository;

    private final UserRepository userRepository;

    private final TaskRepository taskRepository;


    public AdminServiceImpl(
            ProjectService projectService, UserService userService, TaskService taskService,
            ProjectRepository projectRepository, UserRepository userRepository, TaskRepository taskRepository) {
        this.projectService = projectService;
        this.userService = userService;
        this.taskService = taskService;
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public void loadJson() {
        try {
            final ObjectMapper objectMapper = new ObjectMapper();
            final String xmlString = new String(Files.readAllBytes(Paths.get("data.json")));
            final Domain domain = objectMapper.readValue(xmlString, Domain.class);
            userRepository.clear();
            domain.getUsers().forEach(u -> userRepository.save(u));
            projectRepository.clear();
            domain.getProjects().forEach(p -> projectRepository.save(p));
            taskRepository.clear();
            domain.getTasks().forEach(t -> taskRepository.save(t));
        } catch (IOException e) {
            System.out.println("is empty.");
            e.printStackTrace();
        }
    }

    @Override
    public void saveJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Project> projectList = projectService.getAll();
        List<User> userList = userService.getAll();
        List<Task> taskList = taskService.getAll();
        Domain domain = new Domain();
        domain.setProjects(projectList);
        domain.setTasks(taskList);
        domain.setUsers(userList);
        try {
            final String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(domain);
            Files.write(Paths.get("data.json"), json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void clearJson() {
        File file = new File("data.json");
        file.delete();
    }

}
