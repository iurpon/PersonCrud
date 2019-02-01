package ru.trandefil.tm.locator;

import ru.trandefil.tm.service.AbstractService;

public class ServiceLocator {
    public static Cache cache = new Cache();
    public static AbstractService getService(String name){
        return cache.getService(name);
    }
}
