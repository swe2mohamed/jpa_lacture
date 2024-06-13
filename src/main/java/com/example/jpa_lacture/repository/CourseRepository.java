package com.example.jpa_lacture.repository;

import com.example.jpa_lacture.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    // find course by instructor id
    List<Course> findByInstructors_Id(Long instructorId);
}
