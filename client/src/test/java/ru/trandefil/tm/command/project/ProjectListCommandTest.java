package ru.trandefil.tm.command.project;

import org.junit.Assert;
import org.junit.Test;
import ru.trandefil.tm.command.AbstractCommandTest;

import static org.junit.Assert.*;

public class ProjectListCommandTest  extends AbstractCommandTest {

    @Test
    public void execute() {
        Assert.assertEquals(projectService.getAll().size(),3);
    }

}