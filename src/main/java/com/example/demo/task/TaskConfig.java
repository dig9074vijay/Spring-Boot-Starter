package com.example.demo.task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class TaskConfig
{
//    @Bean
//    CommandLineRunner commandLineRunner(
//            TaskRepository taskRepository
//    )
//    {
//        return args -> {
//            Task task1 =  new Task(
//                    "Solve Daily Leetcode problem",
//                    "Consistency is the key",
//                    LocalDate.of(2026,
//                            Month.SEPTEMBER,13));
//
//            Task task2 =  new Task(
//                    "Read one complex system design case study",
//                    "Scalable Modern Solutions",
//                    LocalDate.of(2026,
//                            Month.MARCH,30));
//
//            taskRepository.saveAll(List.of(task1,task2));
//        };
//    }
}
