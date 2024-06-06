package com.example.jpa_lacture.repository;

import com.example.jpa_lacture.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
