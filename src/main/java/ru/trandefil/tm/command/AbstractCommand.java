package ru.trandefil.tm.command;


import ru.trandefil.tm.locator.AbstractServiceLocator;

public abstract class AbstractCommand {
     protected AbstractServiceLocator abstractServiceLocator;

     public AbstractCommand(AbstractServiceLocator abstractServiceLocator) {
          this.abstractServiceLocator = abstractServiceLocator;
     }

     public AbstractCommand() {
     }

     public abstract String command();
     public abstract String description();
     public abstract void execute();
     public AbstractServiceLocator getAbstractServiceLocator(){
          return abstractServiceLocator;
     }


}
