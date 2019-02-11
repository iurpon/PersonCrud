package ru.trandefil.tm.service;

import ru.trandefil.tm.api.TaskRepository;
import ru.trandefil.tm.api.TaskService;
import ru.trandefil.tm.entity.Session;
import ru.trandefil.tm.entity.Task;
import ru.trandefil.tm.util.SignatureUtil;

import java.util.List;
import java.util.stream.Collectors;

public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAll(Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            return null;
        }
        return taskRepository.getAll().stream()
                .filter(t -> t.getExecuterId().equals(session.getUserId()))
                .collect(Collectors.toList());
    }

    public Task save(Task task, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            return null;
        }
        return taskRepository.save(task);
    }

    public Task delete(Task task, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            return null;
        }
        return taskRepository.delete(task);
    }

    public Task deleteByName(String name, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            return null;
        }
        return taskRepository.deleteByName(name);
    }

    public Task getByName(String name, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            return null;
        }
        return taskRepository.getByName(name);
    }

}
