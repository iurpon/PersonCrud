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
        List<Task> all = taskRepository.getAll();
        return all.stream()
                .filter(t -> (t.getExecuterId().equals(userId) || t.getAssigneeId().equals(userId)))
                .collect(Collectors.toList());
    }

    public Task save(Task task) {
        if(task.isNew()){
            task.setId(UUIDUtil.getUniqueString());
            return taskRepository.save(task);
        }
        return taskRepository.update(task);
/*        Task updated = taskRepository.getByid(task.getId());
        updated.setBegin(task.getBegin());
        updated.setEnd(task.getEnd());
        updated.setName(task.getName());
        updated.setDescription(task.getDescription());
        updated.setExecuterId(task.getExecuterId());
        return taskRepository.save(updated);*/
    }

    public Task delete(Task task, String userId) {
        return taskRepository.delete(task);
    }

    public Task deleteByName(String name, String userId) {
        Task removing = taskRepository.getByName(name);
        if(removing == null){
            System.out.println("wrong task name.");
            return null;
        }
        if(!removing.getAssigneeId().equals(userId)){
            System.out.println("Only creator can delete task.");
            return null;
        }
        return taskRepository.delete(removing);
    }

    public Task getByName(String name, String userId) {
        Task byName = taskRepository.getByName(name);
        if(byName == null){
            return null;
        }
        if(!byName.getAssigneeId().equals(userId)){
            System.out.println("can't update task you didn't create");
            return null;
        }
        return byName;
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.getAll();
    }

}
