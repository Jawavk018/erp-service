package com.tech3.erp.repository;

import com.tech3.erp.entity.WeavingContractItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeavingContractItemRepository extends JpaRepository<WeavingContractItem, Long> {}