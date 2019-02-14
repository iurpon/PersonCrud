package ru.trandefil.tm.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Test;
import ru.trandefil.tm.command.AbstractCommandTest;
import ru.trandefil.tm.command.Domain;
import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.entity.Task;
import ru.trandefil.tm.entity.User;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class AdminServiceImplTest extends AbstractCommandTest {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Test
    public void saveBin() {
        logger.info("OLO");
        try (OutputStream outputStream = new FileOutputStream("data.bin")) {
            List<Project> projectList = projectService.getAll();
            List<User> userList = userService.getAll();
            List<Task> taskList = taskService.getAll();
            Project[] projectArray = new Project[projectList.size()];
            User[] userArray = new User[userList.size()];
            Task[] taskArray = new Task[taskList.size()];
            projectList.toArray(projectArray);
            userList.toArray(userArray);
            taskList.toArray(taskArray);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(projectArray);
            objectOutputStream.writeObject(userArray);
            objectOutputStream.writeObject(taskArray);
            objectOutputStream.close();
            System.out.println("success");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void loadBin() {
        saveBin();
        try (InputStream inputStream = new FileInputStream("data.bin")) {
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            Project[] projects = (Project[]) objectInputStream.readObject();
            User[] users = (User[]) objectInputStream.readObject();
            Task[] tasks = (Task[]) objectInputStream.readObject();
            assertEquals(projects.length, 3);
            assertEquals(users.length, 2);
            assertEquals(tasks.length, 3);
            IntStream.range(0, projects.length).forEach(i -> System.out.println(projects[i]));
            IntStream.range(0, tasks.length).forEach(i -> System.out.println(tasks[i]));
            IntStream.range(0, users.length).forEach(i -> System.out.println(users[i]));
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("is empty.");
        }
    }

    @Test
    public void saveXml() {
        ObjectMapper objectMapper = new XmlMapper();
        List<Project> projectList = projectService.getAll();
        List<User> userList = userService.getAll();
        List<Task> taskList = taskService.getAll();
        Domain domain = new Domain();
        domain.setProjects(projectList);
        domain.setTasks(taskList);
        domain.setUsers(userList);
        try {
            final String xml = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(domain);
            Files.write(Paths.get("data.xml"), xml.getBytes());
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    @Test
    public void loadXml() {
        saveXml();
        try {
            final ObjectMapper objectMapper = new XmlMapper();
            final String xmlString = new String(Files.readAllBytes(Paths.get("data.xml")));
            System.out.println(xmlString);
            final Domain domain = objectMapper.readValue(xmlString, Domain.class);
            domain.getUsers().forEach(System.out::println);
            domain.getTasks().forEach(System.out::println);
            domain.getProjects().forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("is empty.");
            e.printStackTrace();
        }
    }

    @Test
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

    @Test
    public void loadJson() {
        saveJson();
        try {
            final ObjectMapper objectMapper = new ObjectMapper();
            final String jsonString = new String(Files.readAllBytes(Paths.get("data.json")));
            System.out.println(jsonString);
            final Domain domain = objectMapper.readValue(jsonString, Domain.class);
            domain.getUsers().forEach(System.out::println);
            domain.getTasks().forEach(System.out::println);
            domain.getProjects().forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("is empty.");
            e.printStackTrace();
        }
    }

    @Test
    public void clearBin() {
        File file = new File("data.bin");
        file.delete();
    }

    @Test
    public void clearXml() {
        File file = new File("data.xml");
        file.delete();
    }

    @Test
    public void clearJson() {
        File file = new File("data.json");
        file.delete();
    }
}