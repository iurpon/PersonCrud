package ru.trandefil.tm.service;

import org.junit.Assert;
import org.junit.Test;
import ru.trandefil.tm.command.AbstractCommandTest;
import ru.trandefil.tm.command.UserCommandTestData;
import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.util.UUIDUtil;

import static org.junit.Assert.*;
import static ru.trandefil.tm.command.ProjectCommandTestData.PROJECT1;
import static ru.trandefil.tm.command.UserCommandTestData.ADMIN;

public class ProjectServiceImplTest extends AbstractCommandTest {

    @Test
    public void save() {
        Project created = new Project(null,"newProj","newProj", ADMIN.getId());
        projectService.save(created);
        Assert.assertEquals(projectService.getAll(sessionAdmin.getUserId()).size(),3);
    }

    @Test
    public void getAll() {
        Assert.assertEquals(projectService.getAll(sessionAdmin.getUserId()).size(),2);
        Assert.assertEquals(projectService.getAll(sessionUser.getUserId()).size(),1);
    }

    @Test
    public void getById() {
        Project project = projectService.getById(PROJECT1.getId(),sessionAdmin.getUserId());
        Assert.assertEquals(project,PROJECT1);
    }

    @Test
    public void delete() {
        projectService.delete(PROJECT1,sessionAdmin.getUserId());
        Assert.assertEquals(projectService.getAll(sessionAdmin.getUserId()).size(),1);
    }

    @Test
    public void deleteByName() {
        projectService.deleteByName(PROJECT1.getName(),sessionAdmin.getUserId());
        Assert.assertEquals(projectService.getAll(sessionAdmin.getUserId()).size(),1);
    }

    @Test
    public void getByName() {
        Project project = projectService.getByName(PROJECT1.getName(),sessionAdmin.getUserId());
        Assert.assertEquals(project,PROJECT1);
    }

}