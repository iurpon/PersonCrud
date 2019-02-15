package ru.trandefil.tm.repository;

import org.junit.Test;
import ru.trandefil.tm.util.HashUtil;

import static org.junit.Assert.*;

public class UserRepositoryImplTest {

    @Test
    public void clear() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void deleteByName() {
    }

    @Test
    public void save() {
    }

    @Test
    public void getByName() {
    }

    @Test
    public void getAll() {
    }

    @Test
    public void getLoginUser() {
    }

    @Test
    public void getById() {
    }

    @Test
    public void hash(){
        System.out.println(HashUtil.hashPassword("userPassword"));
        System.out.println(HashUtil.hashPassword("adminPassword"));
    }
}