package com.tech3.erp.repository;

import com.tech3.erp.entity.WeavingContract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeavingContractRepository extends JpaRepository<WeavingContract, Long> {}
