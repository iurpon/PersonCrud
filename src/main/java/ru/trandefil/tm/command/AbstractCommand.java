package ru.trandefil.tm.command;


import ru.trandefil.tm.locator.ServiceLocator;

public abstract class AbstractCommand {
     protected ServiceLocator serviceLocator;

     public AbstractCommand(ServiceLocator serviceLocator) {
          this.serviceLocator = serviceLocator;
     }

     public abstract String command();
     public abstract String description();
     public abstract void execute();


}
