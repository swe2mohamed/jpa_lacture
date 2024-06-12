package com.example.jpa_lacture.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    @Setter
    @Column(nullable = false)
    private String street;

    @Setter
    @Column(nullable = false)
    private String city;

    @Setter
    @Column(nullable = false, length = 6)
    private String zipCode;

    // The 'mappedBy' attribute is used to indicate that the relationship is managed by the opposite entity.
    // This means that the foreign key is defined in the other entity (Student), not in this entity (Address).
    // By using mappedBy, we avoid creating a duplicate foreign key and keep the relationship bidirectional.
    @OneToOne(mappedBy = "address")
    private Student student;


    public Address(String street, String city, String zipCode) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }
}
