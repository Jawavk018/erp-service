//package com.tech3.erp.repository;
//
//import com.tech3.erp.entity.GeneratePackingItem;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface GeneratePackingItemRepository extends JpaRepository<GeneratePackingItem, Long> {
//}


package com.tech3.erp.repository;

import com.tech3.erp.entity.GeneratePackingItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface GeneratePackingItemRepository extends JpaRepository<GeneratePackingItem, Long> {
    
    @Transactional
    @Modifying
    @Query("DELETE FROM GeneratePackingItem i WHERE i.generatePacking.id = :packingId")
    void deleteByGeneratePackingId(Long packingId);
}