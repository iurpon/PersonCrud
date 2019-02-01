package ru.trandefil.tm.command;



public interface AbstractCommand {
     String command();
     String description();
     void execute();

}
