package com.example.demo.service;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskServiceTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void testListTasksReturnsValidList() {
        // Clear the database for a clean test
        taskRepository.deleteAll();

        // Add a task to the database
        Task task = new Task();
        task.setDescription("MY NAME");
        task.setStatus("todo");
        task.setCreatedAt(LocalDateTime.now());
        task.setUpdatedAt(LocalDateTime.now());
        taskRepository.save(task);

        // Fetch tasks from the database
        List<Task> tasks = taskRepository.findAll();

        // Verify the result
        assertEquals(1, tasks.size());
        assertEquals("MY NAME", tasks.get(0).getDescription());
    }
}