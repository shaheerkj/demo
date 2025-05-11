package com.example.demo;
import com.example.demo.repository.TaskRepository;
import com.example.demo.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.model.Task;
import java.util.List;

@Controller
public class TaskTrackerApplication {
    private final TaskRepository taskRepository;
    private final TaskService taskService;
    public TaskTrackerApplication(TaskRepository taskRepository, TaskService taskService){
        this.taskService = taskService;
        this.taskRepository = taskRepository;
    }
    @GetMapping("/")
    public String homepage(){
        return "index";
    }
    @GetMapping("/list")
    public String listTasks(Model model){
        List<Task> tasks = taskRepository.findAll();
        model.addAttribute("tasks",tasks);
        return "taskslist";
    }
    @GetMapping("/gettask")
    public String getTask(@RequestParam int id,Model model){
        Task task = taskRepository.findById(id).orElse(null);
        model.addAttribute("task",task);
        return "gettask";
    }
    @GetMapping("/addtask")
    public String add(){
        return "addform";
    }
    @GetMapping("/updatetask")
    public String update(){
        return "updateform";
    }

    @PostMapping("/update")
    public String updateTask(@RequestParam int id, @RequestParam String status, @RequestParam String description, Model model){
        boolean isUpdated = taskService.updateTask(id,description);
        if(isUpdated){
            return "redirect:/success";
        }
        else{
            model.addAttribute("error","Task not found or update failed");
            return "error";

        }
    }
    @PostMapping("/add")
    public String addTask(@RequestParam String status, @RequestParam String description, Model model){
        boolean isAdded = taskService.addTask(description);
        if(isAdded){
            return "redirect:/success";
        }
        else{
            model.addAttribute("error","Task not added successfully");
            return "error";
        }
    }

}
