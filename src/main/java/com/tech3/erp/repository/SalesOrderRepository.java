package com.tech3.erp.repository;

import com.tech3.erp.entity.SalesOrder;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesOrderRepository extends JpaRepository<SalesOrder, Long> {
	
	List<SalesOrder> findByBuyerCustomerId(Long buyerCustomerId);

}
