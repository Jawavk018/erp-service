package com.tech3.erp.repository;

import com.tech3.erp.entity.PaymentTerms;
import com.tech3.erp.entity.PoTypeMaster;
import com.tech3.erp.entity.ProductCategory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoTypeMasterRepository extends JpaRepository<PoTypeMaster, Long> {
	 Optional<PoTypeMaster> findByPoTypeName(String poTypeName);
}
