package ru.trandefil.tm.service;

import ru.trandefil.tm.api.*;

import java.io.File;

public class AdminServiceImpl implements AdminService {

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
/*            try {
                final ObjectMapper objectMapper = new ObjectMapper();
                final String jsonString = new String(Files.readAllBytes(Paths.get("data.json")));
                System.out.println(jsonString);
                final Domain command = objectMapper.readValue(jsonString, Domain.class);
                userRepository.clear();
                command.getUsers().forEach(userRepository::save);
                projectRepository.clear();
                command.getProjects().forEach(projectRepository::save);
                taskRepository.clear();
                command.getTasks().forEach(taskRepository::save);
            } catch (IOException e) {
                System.out.println("is empty.");
                e.printStackTrace();
            }*/
    }

    @Override
    public void saveJson() {
/*        final ObjectMapper objectMapper = new ObjectMapper();
//        final List<Project> projectList = projectService.getAll();
        final List<User> userList = userService.getAll();
//        final List<Task> taskList = taskService.getAll(ADMIN);
        final Domain command = new Domain();
//        command.setProjects(projectList);
//        command.setTasks(taskList);
        command.setUsers(userList);
        try {
            final String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(command);
            Files.write(Paths.get("data.json"), json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    @Override
    public void clearJson() {
        final File file = new File("data.json");
        file.delete();
    }

}
