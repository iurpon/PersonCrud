package ru.trandefil.tm.domain;

import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.util.UUIDUtil;

import static ru.trandefil.tm.domain.UserCommandTestData.ADMIN;
import static ru.trandefil.tm.domain.UserCommandTestData.USER;

public class ProjectCommandTestData {

    public static final Project PROJECT1
            = new Project(UUIDUtil.getUniqueString(), "simpleProject1", "no description1", ADMIN.getId());

    public static final Project PROJECT2
            = new Project(UUIDUtil.getUniqueString(), "simpleProject2", "no description2", ADMIN.getId());

    public static final Project PROJECT3
            = new Project(UUIDUtil.getUniqueString(), "simpleProject3", "no description3", USER.getId());

}
