package ru.trandefil.tm.service;

import org.junit.Test;
import ru.trandefil.tm.command.AbstractCommandTest;
import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.entity.Task;
import ru.trandefil.tm.entity.User;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class AdminServiceImplTest extends AbstractCommandTest {

    @Test
    public void saveBin() {
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
        try (InputStream inputStream = new FileInputStream("data.bin")) {
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            Project[] projects = (Project[]) objectInputStream.readObject();
            User[] users = (User[]) objectInputStream.readObject();
            Task[] tasks = (Task[]) objectInputStream.readObject();
            assertEquals(projects.length,3);
            assertEquals(users.length,2);
            assertEquals(tasks.length,3);
            IntStream.range(0,projects.length).forEach(i -> System.out.println(projects[i]));
            IntStream.range(0,tasks.length).forEach(i -> System.out.println(tasks[i]));
            IntStream.range(0,users.length).forEach(i -> System.out.println(users[i]));
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("is empty.");
        }
    }

    @Test
    public void saveXml() {
    }

    @Test
    public void loadXml() {
    }

    @Test
    public void saveJson() {
    }

    @Test
    public void loadJson() {
    }

    @Test
    public void clearBin() {
        File file = new File("data.bin");
        file.delete();
    }

    @Test
    public void clearXml() {
    }

    @Test
    public void clearJson() {
    }
}