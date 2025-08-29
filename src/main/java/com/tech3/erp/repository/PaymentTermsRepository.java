package com.tech3.erp.repository;

import com.tech3.erp.entity.PaymentTerms;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentTermsRepository extends JpaRepository<PaymentTerms, Long> {
    Optional<PaymentTerms> findByTermName(String TermName);
}