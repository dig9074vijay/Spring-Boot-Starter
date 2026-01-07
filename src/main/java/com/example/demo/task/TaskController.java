package com.example.demo.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    @PostMapping
    public Task registerNewTask(@RequestBody Task task) {
        return taskService.addNewTask(task);
    }

    @DeleteMapping(path = "{taskId}")
    public void deleteTask(@PathVariable("taskId") Long id) {
         taskService.deleteTask(id);
    }

    @PutMapping(path = "{taskId}")
    public Task updateTask(@PathVariable("taskId") Long taskId,
                              @RequestParam(required = false) String taskTitle,
                              @RequestParam(required = false) String taskDescription) {
       return taskService.updateTask(taskId, taskTitle, taskDescription);
    }
}