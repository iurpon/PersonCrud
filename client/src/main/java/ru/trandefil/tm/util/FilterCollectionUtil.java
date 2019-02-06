package ru.trandefil.tm.util;

import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.entity.Task;
import ru.trandefil.tm.entity.User;

import java.util.List;

public class FilterCollectionUtil {

    public static void printUserCollection(List<User> list, User loggedUser) {
        if (list == null || list.isEmpty()) {
            return;
        }
        list.forEach(System.out::println);
    }

    public static void printProjectCollection(List<Project> list,User loggedUser) {
        if (list == null || list.isEmpty()) {
            return;
        }
        list.stream().filter(p -> p.getUser().equals(loggedUser)).forEach(System.out::println);
    }

    public static void printTaskCollection(List<Task> list,User loggedUser) {
        if (list == null || list.isEmpty()) {
            return;
        }
        list.stream().filter(t -> t.getExecuter().equals(loggedUser))
                .forEach(System.out::println);
    }
}
