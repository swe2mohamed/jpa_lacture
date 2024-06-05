package com.example.jpa_lacture.repository;

import com.example.jpa_lacture.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, String> {

    // select * from student where name = ?
    List<Student> findByFirstName(String name);

    // select * from student contain keyword
    List<Student> findByFirstNameContaining(String name);

    List<Student> findByCreateDateAfter(LocalDateTime dateTime);

    List<Student> findByStatusTrue();

    Optional<Student> findByEmailIgnoreCase(String email);
}
