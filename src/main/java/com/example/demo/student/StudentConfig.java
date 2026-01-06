package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig
{
    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository studentRepository
    )
    {
        return args -> {
            Student Digvijay =  new Student(
                    "Digvijay Srivastava",
                    "dig9074vijay@gmail.com",
                    LocalDate.of(2001,
                            Month.SEPTEMBER,13));

            Student Aditi =  new Student(
                    "Aditi Srivastava",
                    "aditi214908.com",
                    LocalDate.of(2004,
                            Month.MARCH,30));

            studentRepository.saveAll(List.of(Digvijay,Aditi));
        };
    }
}
