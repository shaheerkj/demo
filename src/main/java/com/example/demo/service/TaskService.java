package com.example.demo.service;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }
    public boolean addTask(String description){
        try{
            Task task = new Task();
            task.setDescription(description);
            task.setStatus("todo");
            task.setCreatedAt(LocalDateTime.now());
            task.setUpdatedAt(LocalDateTime.now());
            taskRepository.save(task);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public List<Task> listTasks(String status){
        return (status == null) ? taskRepository.findAll() : taskRepository.findByStatus(status);
    }
    public boolean updateTask(int id, String description){
        Optional<Task> taskOpt = taskRepository.findById(id);
        if(taskOpt.isPresent()){
            Task task = taskOpt.get();
            task.setDescription(description);
            task.setUpdatedAt(LocalDateTime.now());
            taskRepository.save(task);
            return true;
        }
        return false;
    }
    public boolean deleteTask(int id){
        if(taskRepository.existsById(id)){
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public boolean markTask(int id, String status){
        Optional<Task> taskOpt = taskRepository.findById(id);
        if(taskOpt.isPresent()){
            Task task = taskOpt.get();
            task.setStatus(status);
            task.setUpdatedAt(LocalDateTime.now());
            taskRepository.save(task);
            return true;

        }
        return false;
    }

}
