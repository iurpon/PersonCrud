package ru.trandefil.tm.endpoint;

import org.junit.Test;
import ru.trandefil.tm.entity.Role;

import static org.junit.Assert.*;

public class UserEndPointImplTest {

    @Test
    public void deleteUserByName() {
    }

    @Test
    public void saveUser() {
    }

    @Test
    public void getUserByName() {
    }

    @Test
    public void getAllUsers() {
    }

    @Test
    public void getSession() {
    }

    @Test
    public void userLogout() {
    }

    @Test
    public void testEnum(){
        assertEquals(Role.ADMIN,Enum.valueOf(Role.class,"ADMIN"));
    }
}