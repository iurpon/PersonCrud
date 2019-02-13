package ru.trandefil.tm.endpoint;

import org.junit.Test;
import ru.trandefil.tm.entity.Role;

import static org.junit.Assert.*;
import static ru.trandefil.tm.repository.UserRepositoryImpl.ADMIN;

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

    @Test
    public void testLoginOR(){
        String role1 = "NotRolle";
        String role2 = "ADMIN";
        String role3 = "USER";
        assertEquals(true,check(role2));
        assertEquals(true,check(role3));
        assertEquals(false,check(role1));

    }
    public boolean check(String str){
        if(!str.equals("ADMIN") && !str.equals("USER")){
            System.out.println(str + " didn't pass");
            return false;
        }
        return true;

    }
}