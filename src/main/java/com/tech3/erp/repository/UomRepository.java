package com.tech3.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tech3.erp.entity.Uom;

@Repository
public interface UomRepository extends JpaRepository<Uom, Long> {}