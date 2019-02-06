package ru.trandefil.tm.command;

import ru.trandefil.tm.entity.User;
import ru.trandefil.tm.util.UUIDUtil;

public class UserCommandTestData {

    public static final User USER = new User(UUIDUtil.getUniqueString(), "User", "221068207E125B97BEB4E2D062E888B1");//userPassword

    public static final User ADMIN = new User(UUIDUtil.getUniqueString(), "Admin", "33D87FD364516F6604124FCC76FDD279");//adminPassword

}
