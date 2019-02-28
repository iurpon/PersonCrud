package ru.trandefil.tm;

import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.entity.Role;
import ru.trandefil.tm.entity.Task;
import ru.trandefil.tm.entity.User;
import ru.trandefil.tm.util.HashUtil;

import java.util.Date;

public class TestData {

    public static final User USER = new User("df6e526a-163b-4342-b55c-0377956edd06","User", HashUtil.hashPassword("userPassword"), Role.USER);

    public static final User ADMIN = new User("58b1689d-ed26-4be2-89be-8c56f7c7d8f1","Admin",HashUtil.hashPassword("adminPassword"), Role.ADMIN);

    public static final Project PROJECT1_ADMIN = new Project("c08ec6e8-9c21-4fce-a1fc-e2ff72f593ab","project","description",ADMIN);

    public static final Project PROJECT1_USER = new Project("7fa10911-63b1-4cc2-a4bd-d2ce26add644","up1","up1",USER);

    public static final Task TASK1_ADMIN = new Task("46c4b2ef-dea4-40ed-acc3-ced2fdfbbf9c","task","desc",
            new Date(2019,01,28), new Date(2019,01,28),
            PROJECT1_ADMIN,ADMIN,USER);

    public static final Task TASK2_ADMIN = new Task("b41d4a26-5066-4c37-b4f2-1fa6cf992afe","p","p",
            new Date(2012,0,02), new Date(2012,0,03),
            PROJECT1_ADMIN,ADMIN,USER);

    public static final Task TASK1_USER = new Task("f186ae59-0c2e-4d1f-a0bd-4b606096931b","up1t1","up1t1",
            new Date(2011,0,03), new Date(2011,0,03),
            PROJECT1_USER,USER,ADMIN);

}
