package ru.trandefil.tm.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.trandefil.tm.api.*;
import ru.trandefil.tm.domain.Domain;
import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.entity.Task;
import ru.trandefil.tm.entity.User;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AdminServiceImpl implements AdminService {

    private final ProjectService projectService;

    private final UserService userService;

    private final TaskService taskService;

    public AdminServiceImpl(ProjectService projectService, UserService userService, TaskService taskService) {
        this.projectService = projectService;
        this.userService = userService;
        this.taskService = taskService;
    }

    @Override
    public void loadJson() {
            try {
                final ObjectMapper objectMapper = new ObjectMapper();
                final String jsonString = new String(Files.readAllBytes(Paths.get("data.json")));
                System.out.println(jsonString);
                final Domain command = objectMapper.readValue(jsonString, Domain.class);
                command.getUsers().forEach(System.out::println);
                command.getProjects().forEach(System.out::println);
                command.getTasks().forEach(System.out::println);
            } catch (IOException e) {
                System.out.println("is empty.");
                e.printStackTrace();
            }
    }

    @Override
    public void saveJson() {
        final ObjectMapper objectMapper = new ObjectMapper();
        final List<Project> projectList = projectService.getAll();
        final List<User> userList = userService.getAll();
        final List<Task> taskList = taskService.getAll();
        final Domain command = new Domain();
        command.setProjects(projectList);
        command.setTasks(taskList);
        command.setUsers(userList);
        try {
            final String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(command);
            Files.write(Paths.get("data.json"), json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void clearJson() {
        final File file = new File("data.json");
        file.delete();
    }

}
