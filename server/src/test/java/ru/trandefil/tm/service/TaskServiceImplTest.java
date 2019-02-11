package ru.trandefil.tm.service;

import org.junit.Assert;
import org.junit.Test;
import ru.trandefil.tm.command.AbstractCommandTest;
import ru.trandefil.tm.entity.Task;

import static org.junit.Assert.*;
import static ru.trandefil.tm.command.ProjectCommandTestData.PROJECT3;
import static ru.trandefil.tm.command.UserCommandTestData.ADMIN;
import static ru.trandefil.tm.command.UserCommandTestData.USER;

public class TaskServiceImplTest extends AbstractCommandTest {

    @Test
    public void getAll() {
        Assert.assertEquals(taskService.getAll(sessionUser).size(),2);
    }

    @Test
    public void save() {
        Task task = new Task(null,"task4","task4",null,null, PROJECT3.getId(),ADMIN.getId(), USER.getId());
//        taskService.
    }

    @Test
    public void delete() {
    }

    @Test
    public void deleteByName() {
    }

    @Test
    public void getByName() {
    }
}