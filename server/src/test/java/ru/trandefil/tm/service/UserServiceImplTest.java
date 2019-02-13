package ru.trandefil.tm.service;

import org.junit.Assert;
import org.junit.Test;
import ru.trandefil.tm.command.AbstractCommandTest;
import ru.trandefil.tm.entity.Role;
import ru.trandefil.tm.entity.Session;
import ru.trandefil.tm.entity.User;
import ru.trandefil.tm.util.SignatureUtil;
import ru.trandefil.tm.util.UUIDUtil;

import static ru.trandefil.tm.command.UserCommandTestData.ADMIN;
import static ru.trandefil.tm.command.UserCommandTestData.USER;

public class UserServiceImplTest extends AbstractCommandTest {

    @Test
    public void delete() {
        userService.delete(USER );
        Assert.assertEquals(userService.getAll().size(), 1);
    }

    @Test
    public void deleteByName() {
        userService.deleteByName(ADMIN.getName() );
        Assert.assertEquals(userService.getAll().size(), 1);
    }

    @Test
    public void save() {
        User newUser = new User(null, "newUser", "newPass", Role.USER);
        userService.save(newUser );
        Assert.assertEquals(userService.getAll().size(), 3);
    }

    @Test
    public void getByName() {
        User user = userService.getByName(ADMIN.getName() );
        Assert.assertEquals(user, ADMIN);
    }

    @Test
    public void getAll() {
        Assert.assertEquals(userRepository.getAll().size(), 2);
    }

    @Test
    public void getSession() {
        Session session = userService.getSession(USER.getName(),USER.getPassword());
        Assert.assertEquals(true, SignatureUtil.checkCorrectSession(session));
    }

}