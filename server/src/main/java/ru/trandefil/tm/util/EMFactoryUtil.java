package ru.trandefil.tm.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMFactoryUtil {

    private static EntityManagerFactory entityManagerFactory = construct();

    private static EntityManagerFactory  construct(){
        return Persistence.createEntityManagerFactory("entityManager");
    }

    public static EntityManager getEntityManager(){
        return entityManagerFactory.createEntityManager();
    }

}
