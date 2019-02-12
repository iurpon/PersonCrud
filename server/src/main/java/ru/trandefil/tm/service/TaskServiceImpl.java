package ru.trandefil.tm.service;

import ru.trandefil.tm.api.TaskRepository;
import ru.trandefil.tm.api.TaskService;
import ru.trandefil.tm.entity.Session;
import ru.trandefil.tm.entity.Task;
import ru.trandefil.tm.util.SignatureUtil;
import ru.trandefil.tm.util.UUIDUtil;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAll(String userId) {
        return taskRepository.getAll().stream()
                .filter(t -> t.getExecuterId().equals(userId))
                .collect(Collectors.toList());
    }

    public Task save(Task task) {
        if(task.isNew()){
            task.setId(UUIDUtil.getUniqueString());
            return taskRepository.save(task);
        }
        Task updated = taskRepository.getByid(task.getId());
        updated.setBegin(task.getBegin());
        updated.setEnd(task.getEnd());
        updated.setName(task.getName());
        updated.setDescription(task.getDescription());
        updated.setExecuterId(task.getExecuterId());
        return taskRepository.save(updated);
    }

    public Task delete(Task task, String userId) {
        return taskRepository.delete(task);
    }

    public Task deleteByName(String name, String userId) {
        Task removing = taskRepository.deleteByName(name);
        if(removing == null){
            System.out.println("wrong task name.");
            return null;
        }
        if(!removing.getAssigneeId().equals(userId)){
            System.out.println("Only creator can delete task.");
            return null;
        }
        return removing;
    }

    public Task getByName(String name, String userId) {
        return taskRepository.getByName(name);
    }

}
