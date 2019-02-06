package ru.trandefil.tm.command.project;

import org.junit.Assert;
import org.junit.Test;
import ru.trandefil.tm.command.AbstractCommandTest;
import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.util.UUIDUtil;

import static org.junit.Assert.*;
import static ru.trandefil.tm.command.UserCommandTestData.ADMIN;

public class ProjectCreateCommandTest extends AbstractCommandTest {

    @Test
    public void execute() {
        int size = projectService.getAll().size();
        Project project = new Project(UUIDUtil.getUniqueString(),"new Project","new Description",ADMIN);
        projectService.save(project);
        int newSize = projectService.getAll().size();
        Assert.assertEquals(++size,newSize);
    }
}