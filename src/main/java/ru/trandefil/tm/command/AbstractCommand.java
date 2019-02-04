package ru.trandefil.tm.command;

import ru.trandefil.tm.api.ServiceLocator;

public abstract class AbstractCommand {

    private ServiceLocator serviceLocator;

    public AbstractCommand(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    public abstract String command();

    public abstract String description();

    public abstract void execute();

    public abstract boolean secure();

    public ServiceLocator getServiceLocator() {
        return serviceLocator;
    }
}
