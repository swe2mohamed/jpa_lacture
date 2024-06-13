package com.example.jpa_lacture.repository;

import com.example.jpa_lacture.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    // find student by course id
    List<Student> findByCourse_Id (Long courseId );

    // find student by course name
    List<Student> findByCourse_CourseName (String courseName);

    @Modifying
    @Query("UPDATE Student s set s.status = true WHERE s.id = :studentId")
    void updateStudentStatusToTrue (@Param("studentId") String id);

}
