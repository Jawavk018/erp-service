package com.tech3.erp.repository;

import com.tech3.erp.entity.FabricWeftDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FabricWeftDetailRepository extends JpaRepository<FabricWeftDetail, Long> {
    // You can add custom query methods here if needed
}
