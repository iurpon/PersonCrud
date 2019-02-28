package ru.trandefil.tm.endpoint;


import org.junit.Assert;
import org.junit.Test;
import ru.trandefil.tm.AbstractEndPoint;
import ru.trandefil.tm.generated.Session;
import ru.trandefil.tm.generated.UserDTO;
import ru.trandefil.tm.generated.UserEndPoint;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserEndPointTest extends AbstractEndPoint {

    @Test
    public void getAll() {
        Session session = userEndPoint.getSession("Admin", "adminPassword");
        List<UserDTO> list = userEndPoint.getAllUsers(session);
        list.forEach(System.out::println);
        assertEquals(list.size(), 2);
    }

    @Test
    public void getSession() {
        Session session = userEndPoint.getSession("Admin", "adminPassword");
        assertEquals(session != null, true);
    }

    @Test
    public void saveUser() {
        Session session = userEndPoint.getSession("Admin", "adminPassword");
        userEndPoint.saveUser("bla", "bla", "USER", session);
        List<UserDTO> list = userEndPoint.getAllUsers(session);
        list.forEach(System.out::println);
        assertEquals(list.size(), 3);
    }

}