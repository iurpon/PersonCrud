package ru.trandefil.tm.command;

import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.util.UUIDUtil;

import static ru.trandefil.tm.command.UserCommandTestData.ADMIN;
import static ru.trandefil.tm.command.UserCommandTestData.USER;

public class ProjectCommandTestData {

    public static final Project PROJECT1
            = new Project(UUIDUtil.getUniqueString(), "simpleProject1", "no description1", ADMIN);

    public static final Project PROJECT2
            = new Project(UUIDUtil.getUniqueString(), "simpleProject2", "no description2", ADMIN);

    public static final Project PROJECT3
            = new Project(UUIDUtil.getUniqueString(), "simpleProject3", "no description3", USER);

}
