package com.tech3.erp.repository;

import com.tech3.erp.entity.DyeingWorkOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DyeingWorkOrderItemRepository extends JpaRepository<DyeingWorkOrderItem, Long> {
    // Additional query methods if needed
}
