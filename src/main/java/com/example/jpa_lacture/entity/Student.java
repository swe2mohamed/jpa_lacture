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
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false)
    private String id;

    @Setter
    @Column(nullable = false, length = 100)
    private String firstName;

    @Setter
    @Column(nullable = false, length = 100)
    private String lastName;

    @Setter
    @Column(nullable = false, unique = true)
    private String email;

    @Column
    private boolean status;

    @Column
    private LocalDateTime createDate;


    // The '@OneToOne' annotation is used to specify a one-to-one relationship between two entities.

    // The 'cascade' attribute is used to propagate all operations (e.g., persist, remove) from the parent entity (Student) to the associated entity (Address).
    // 'CascadeType.ALL' means all operations will be cascaded.

    // The 'fetch' attribute specifies the fetching strategy for the associated entity.
    // 'FetchType.EAGER' means the Address entity will be loaded immediately with the Student entity, rather than lazily on demand.

    // The '@JoinColumn' annotation is used to specify the column that joins the two tables.
    // The name attribute defines the name of the foreign key column in the Student table that references the primary key of the Address table.

    @Setter
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    private Address address;

    @Setter
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private Course course;


    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.status = true;
        this.createDate = LocalDateTime.now();
    }

    public Student(String firstName, String lastName, String email, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.status = true;
        this.createDate = LocalDateTime.now();
    }
}
