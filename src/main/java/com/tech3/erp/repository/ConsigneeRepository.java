package com.tech3.erp.repository;

import com.tech3.erp.entity.Consignee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsigneeRepository extends JpaRepository<Consignee, Long> {
}
