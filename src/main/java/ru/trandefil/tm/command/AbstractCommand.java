package ru.trandefil.tm.command;

import ru.trandefil.tm.entity.BaseEntity;

import java.util.List;

public interface AbstractCommand {
     String command();
     String description();
     List<BaseEntity> execute();

}
