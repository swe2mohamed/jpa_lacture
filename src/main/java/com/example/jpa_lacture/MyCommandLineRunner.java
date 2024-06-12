package com.example.jpa_lacture;


import com.example.jpa_lacture.entity.Address;
import com.example.jpa_lacture.entity.Student;
import com.example.jpa_lacture.repository.AddressRepository;
import com.example.jpa_lacture.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    AddressRepository addressRepository;



    @Override
    public void run(String... args) throws Exception {
        Address address_1 = new Address("Test Street", "Test City", "123zip");
        Student student_1 = studentRepository.save(new Student("Mohamed", "Hussein", "mohamed@gmail.com",address_1));

    }
}
