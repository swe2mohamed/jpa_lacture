package com.example.jpa_lacture.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    @Column(nullable = false, length = 100)
    private String courseName;

    @OneToMany (mappedBy = "course")
    private Set<Student> studentSet = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "course_instructors",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "instructor_id")
    )
    private Set<Instructor> instructors = new HashSet<>();

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void addStudent(Student student){
        studentSet.add(student);
        student.setCourse(this);
    }

    public void removeStudent(Student student){
        studentSet.remove(student);
        student.setCourse(null);
    }
}
