package ru.trandefil.tm.command;

import ru.trandefil.tm.entity.User;
import ru.trandefil.tm.util.HashUtil;
import ru.trandefil.tm.util.UUIDUtil;

public class UserCommandTestData {

    public static final User USER = new User(UUIDUtil.getUniqueString(), "User", "userPassword");//userPassword

    public static final User ADMIN = new User(UUIDUtil.getUniqueString(), "Admin", "adminPassword");//adminPassword

}
