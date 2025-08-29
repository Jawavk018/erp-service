package com.tech3.erp.repository;

import com.tech3.erp.entity.PurchaseOrder;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {
	List<PurchaseOrder> findByVendorId(Long vendorId);
	
	@Query("SELECT DISTINCT po.vendorId FROM PurchaseOrder po WHERE po.poTypeId = :poTypeId")
    List<Long> findVendorIdsByPoTypeId(@Param("poTypeId") Long poTypeId);
}
