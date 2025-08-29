package com.tech3.erp.repository;

import com.tech3.erp.entity.FabricWarpDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FabricWarpDetailRepository extends JpaRepository<FabricWarpDetail, Long> {
    // You can add custom query methods here if needed
}
