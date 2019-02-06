package ru.trandefil.tm.command.project;

import org.junit.Assert;
import org.junit.Test;
import ru.trandefil.tm.command.AbstractCommandTest;
import ru.trandefil.tm.entity.Project;

import static ru.trandefil.tm.command.ProjectCommandTestData.PROJECT1;

public class ProjectUpdateCommandTest extends AbstractCommandTest {

    @Test
    public void execute() {
        Project updating = PROJECT1;
        updating.setName("updatedName");
        projectService.delete(PROJECT1);
        projectService.save(updating);
        Project updated = projectService.getById("updatedName");
        Assert.assertEquals(updated,updating);
    }
}