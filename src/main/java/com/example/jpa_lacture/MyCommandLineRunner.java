package com.example.jpa_lacture;


import com.example.jpa_lacture.entity.Student;
import com.example.jpa_lacture.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @Autowired
    StudentRepository studentRepository;


    @Override
    public void run(String... args) throws Exception {
        studentRepository.save(new Student("Mohamed", "Hussein", "mohamed@gmail.com"));
    }
}
