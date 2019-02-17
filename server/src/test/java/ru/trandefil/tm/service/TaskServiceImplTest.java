package ru.trandefil.tm.service;

import org.junit.Assert;
import org.junit.Test;
import ru.trandefil.tm.command.AbstractCommandTest;
import ru.trandefil.tm.entity.Task;

import static org.junit.Assert.*;
import static ru.trandefil.tm.command.ProjectCommandTestData.PROJECT3;
import static ru.trandefil.tm.command.TaskCommandTestData.TASK1;
import static ru.trandefil.tm.command.TaskCommandTestData.TASK2;
import static ru.trandefil.tm.command.UserCommandTestData.ADMIN;
import static ru.trandefil.tm.command.UserCommandTestData.USER;

public class TaskServiceImplTest extends AbstractCommandTest {

    @Test
    public void getAll() {
        Assert.assertEquals(taskService.getAll(sessionUser.getUserId()).size(),2);
    }

    @Test
    public void save() {
        Task task = new Task(null,"task4","task4",null,null, PROJECT3.getId(),ADMIN.getId(), USER.getId());
        taskService.save(task);
        Assert.assertEquals(taskService.getAll(sessionUser.getUserId()).size(),3);
    }

    @Test
    public void delete() {
        taskService.delete(sessionAdmin.getUserId(),TASK1);
        Assert.assertEquals(taskRepository.getAll().size(),2);
    }

    @Test
    public void deleteByName() {
        Task task = taskService.deleteByName(TASK1.getName(), sessionAdmin.getUserId());
        Assert.assertEquals(task,TASK1);
    }

    @Test
    public void getByName() {
        Task task = taskService.getByName(TASK2.getName(),sessionAdmin.getUserId());
        Assert.assertEquals(task,TASK2);
    }

}