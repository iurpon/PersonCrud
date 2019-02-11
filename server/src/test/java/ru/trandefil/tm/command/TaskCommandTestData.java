package ru.trandefil.tm.command;

import ru.trandefil.tm.entity.Task;
import ru.trandefil.tm.util.UUIDUtil;

import static ru.trandefil.tm.command.ProjectCommandTestData.PROJECT1;
import static ru.trandefil.tm.command.ProjectCommandTestData.PROJECT2;
import static ru.trandefil.tm.command.UserCommandTestData.ADMIN;
import static ru.trandefil.tm.command.UserCommandTestData.USER;

public class TaskCommandTestData {

    public static final Task TASK1 = new Task(UUIDUtil.getUniqueString(),
            "TASK1", "TASK1DESC1", null, null, PROJECT1.getId(), ADMIN.getId(), ADMIN.getId());

    public static final Task TASK2 = new Task(UUIDUtil.getUniqueString(),
            "TASK2", "TASK1DESC2", null, null, PROJECT1.getId(), ADMIN.getId(), USER.getId());

    public static final Task TASK3 = new Task(UUIDUtil.getUniqueString(),
            "TASK3", "TASK1DESC3", null, null, PROJECT2.getId(), USER.getId(), USER.getId());

}
