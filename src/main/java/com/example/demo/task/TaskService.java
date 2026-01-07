package com.example.demo.task;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository)
    {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks()
    {
        return taskRepository.findAll();
    }

    public Task addNewTask(Task task)
    {
        System.out.println(task);
        Optional<Task> taskOptional = taskRepository.findTaskByDescription(task.getTaskDescription());
        if(taskOptional.isPresent())
        {
            throw new IllegalStateException("Email taken");
        }
        return taskRepository.save(task);
    }

    public void deleteTask(Long id)
    {
        boolean exists = taskRepository.existsById(id);
        if(!exists)
        {
            throw new IllegalStateException("Task with id " + id + " does not exist");
        }
         taskRepository.deleteById(id);
    }

    @Transactional
    public Task updateTask(Long taskId,String taskTitle,String taskDescription)
    {
        Task task = taskRepository.findById(taskId).orElseThrow(()-> new IllegalStateException("Task with id"+ taskId +"does not exist"));
        if(taskTitle!=null&& !taskTitle.isEmpty() && !Objects.equals(task.getTaskTitle(),taskTitle))
        {
            task.setTaskTitle(taskTitle);
        }

        if(taskDescription!=null&& !taskDescription.isEmpty())
        {
            task.setTaskDescription(taskDescription);
        }

        return task;

    }

}
