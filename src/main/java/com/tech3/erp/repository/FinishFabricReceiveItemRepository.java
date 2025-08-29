package com.tech3.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tech3.erp.entity.FinishFabricReceiveItem;

@Repository
public interface FinishFabricReceiveItemRepository extends JpaRepository<FinishFabricReceiveItem, Long> {

	void deleteByFinishFabricReceiveId(Long id);
}