package com.tech3.erp.repository;

import com.tech3.erp.entity.DyeingWorkOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DyeingWorkOrderRepository extends JpaRepository<DyeingWorkOrder, Long> {
    // Additional query methods if needed
}
