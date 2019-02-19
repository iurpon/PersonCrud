package ru.trandefil.tm.command;

import ru.trandefil.tm.api.ServiceLocator;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public abstract class AbstractCommand {

    private ServiceLocator serviceLocator;

    public AbstractCommand(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    public AbstractCommand() {
    }

    public abstract String command();

    public abstract String description();

    @WebMethod
    public abstract void execute();

    public abstract boolean secure();

    public ServiceLocator getServiceLocator() {
        return serviceLocator;
    }

    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    public  boolean isAdmin(){
        return false;
    }

}
