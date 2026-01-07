package com.example.demo.task;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Task {

    @Id
    @SequenceGenerator(
            name="Task_sequence",
            sequenceName="Task_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "Task_sequence"
    )
    private Long id;
    private String taskTitle;
    private String taskDescription;
    private LocalDate targetDate;
    @Transient
    private int daysLeft;

    public Task()
    {

    }

    public Task(String taskTitle, String taskDescription, LocalDate targetDate) {
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
        this.targetDate = targetDate;

    }

    public Task(Long id, String taskTitle, String taskDescription, LocalDate targetDate) {
        this.id = id;
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
        this.targetDate = targetDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String title) {
        this.taskTitle = title;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String description) {
        this.taskDescription = description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public Integer getDaysLeft() {
        return Period.between(LocalDate.now(), this.targetDate).getDays();
    }

    public void setDaysLeft(int daysLeft) {
        this.daysLeft = daysLeft;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + taskTitle + '\'' +
                ", email='" + taskDescription + '\'' +
                ", dob=" + targetDate +
                ", age=" + daysLeft +
                '}';
    }
}
