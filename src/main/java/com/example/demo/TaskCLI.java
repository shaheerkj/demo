//package com.example.demo;
//
//import com.example.demo.service.TaskService;
//import com.example.demo.model.Task;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//public class TaskCLI implements CommandLineRunner {
//    private final TaskService taskService;
//
//    public TaskCLI(TaskService taskService) {
//        this.taskService = taskService;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        if (args.length == 0) {
//            System.out.println("Usage: task-cli <command> [options]");
//            return;
//        }
//
//        String command = args[0];
//        switch (command) {
//            case "add" -> {
//                if (args.length < 2) {
//                    System.out.println("Usage: task-cli add <description>");
//                } else {
//                    Task task = taskService.addTask(args[1]);
//                    System.out.println("Task added successfully (ID: " + task.getId() + ")");
//                }
//            }
//            case "list" -> {
//                String status = args.length > 1 ? args[1] : null;
//                List<Task> tasks = taskService.listTasks(status);
//                tasks.forEach(System.out::println);
//            }
//            case "update" -> {
//                if (args.length < 3) {
//                    System.out.println("Usage: task-cli update <id> <description>");
//                } else {
//                    boolean updated = taskService.updateTask(Integer.parseInt(args[1]), args[2]);
//                    System.out.println(updated ? "Task updated successfully" : "Task not found");
//                }
//            }
//            case "delete" -> {
//                if (args.length < 2) {
//                    System.out.println("Usage: task-cli delete <id>");
//                } else {
//                    boolean deleted = taskService.deleteTask(Integer.parseInt(args[1]));
//                    System.out.println(deleted ? "Task deleted successfully" : "Task not found");
//                }
//            }
//            case "mark-in-progress" -> {
//                if (args.length < 2) {
//                    System.out.println("Usage: task-cli mark-in-progress <id>");
//                } else {
//                    boolean marked = taskService.markTask(Integer.parseInt(args[1]), "in-progress");
//                    System.out.println(marked ? "Task marked as in-progress" : "Task not found");
//                }
//            }
//            case "mark-done" -> {
//                if (args.length < 2) {
//                    System.out.println("Usage: task-cli mark-done <id>");
//                } else {
//                    boolean marked = taskService.markTask(Integer.parseInt(args[1]), "done");
//                    System.out.println(marked ? "Task marked as done" : "Task not found");
//                }
//            }
//            default -> System.out.println("Unknown command: " + command);
//        }
//    }
//}