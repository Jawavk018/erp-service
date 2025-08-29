package com.tech3.erp.repository;

import com.tech3.erp.entity.SalesOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesOrderItemRepository extends JpaRepository<SalesOrderItem, Long> {
}
