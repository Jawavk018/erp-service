package com.tech3.erp.repository;

import com.tech3.erp.entity.Address;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
     Optional<Address> findByline1(String line1);
}
