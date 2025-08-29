package com.tech3.erp.repository;

import com.tech3.erp.entity.TermsConditions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TermsConditionsRepository extends JpaRepository<TermsConditions, Long> {
    Optional<TermsConditions> findByTermsConditionsName(String termsConditionsName);
}

