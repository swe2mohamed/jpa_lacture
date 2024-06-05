package com.example.jpa_lacture.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString (exclude = "createDate")

@Entity
public class Student {
    @Id
    //@GeneratedValue (strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, length = 100)
    @Setter private String firstName;

    @Column(nullable = false, length = 100)
    @Setter private String lastName;

    @Column(nullable = false, unique = true)
    @Setter private String email;

    @Column
    private boolean status;

    @Column
    private LocalDateTime createDate;

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.status = true;
        this.createDate = LocalDateTime.now();
    }
}
