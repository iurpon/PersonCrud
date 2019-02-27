package ru.trandefil.tm;

import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.entity.Role;
import ru.trandefil.tm.entity.User;
import ru.trandefil.tm.util.EMFactoryUtil;
import ru.trandefil.tm.util.HashUtil;
import ru.trandefil.tm.util.UUIDUtil;

import javax.persistence.EntityManager;

public class HibernateExample {

    public static void main(String[] args){
/*        User user = new User("df6e526a-163b-4342-b55c-0377956edd06","User", HashUtil.hashPassword("userPassword"), Role.USER);
        User user1 = new User("58b1689d-ed26-4be2-89be-8c56f7c7d8f1","Admin",HashUtil.hashPassword("adminPassword"), Role.ADMIN);*/
//        User user = new User(UUIDUtil.getUniqueString(),"bla",HashUtil.hashPassword("bla"), Role.USER);
/*        Session  session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.merge(user);
        session.getTransaction().commit();
        session.close();*/
        EntityManager entityManager = EMFactoryUtil.getEntityManager();
        entityManager.getTransaction().begin();
/*        entityManager.merge(user);
        entityManager.merge(user1);*/
/*        User newUser = new User(UUIDUtil.getUniqueString(),"newUser",HashUtil.hashPassword("newPass"),Role.USER);
        Project newProject = new Project(UUIDUtil.getUniqueString(),"nup1","nup1",newUser);
        entityManager.persist(newProject);*/
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
