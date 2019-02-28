package ru.trandefil.tm;

import org.hibernate.Session;
import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.entity.Role;
import ru.trandefil.tm.entity.Task;
import ru.trandefil.tm.entity.User;
import ru.trandefil.tm.util.EMFactoryUtil;
import ru.trandefil.tm.util.HashUtil;
import ru.trandefil.tm.util.HibernateUtil;
import ru.trandefil.tm.util.UUIDUtil;

import javax.persistence.EntityManager;
import java.util.Date;

public class HibernateExample {

    public static void main(String[] args){
        final User user = new User("df6e526a-163b-4342-b55c-0377956edd06","User", HashUtil.hashPassword("userPassword"), Role.USER);
        final User user1 = new User("58b1689d-ed26-4be2-89be-8c56f7c7d8f1","Admin",HashUtil.hashPassword("adminPassword"), Role.ADMIN);
        final String projectId = UUIDUtil.getUniqueString();
        final Project project = new Project(projectId,"project","description",user1);
        final String taskId = UUIDUtil.getUniqueString();
        final Task task = new Task(taskId,"task","desc",new Date(), new Date(),project,user1,user);
//        User user = new User(UUIDUtil.getUniqueString(),"bla",HashUtil.hashPassword("bla"), Role.USER);
/*        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.merge(user);
        session.getTransaction().commit();
        session.close();*/
        EntityManager entityManager = null;
        try {
            entityManager = EMFactoryUtil.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.persist(user1);
            entityManager.persist(project);
            entityManager.persist(task);
/*        User newUser = new User(UUIDUtil.getUniqueString(),"newUser",HashUtil.hashPassword("newPass"),Role.USER);
        Project newProject = new Project(UUIDUtil.getUniqueString(),"nup1","nup1",newUser);
        entityManager.persist(newProject);*/
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            if(entityManager != null){
                entityManager.getTransaction().rollback();
                entityManager.close();
            }
            e.getMessage();
        }
    }

}
