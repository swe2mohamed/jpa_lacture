package com.example.jpa_lacture.repository;

import com.example.jpa_lacture.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}
