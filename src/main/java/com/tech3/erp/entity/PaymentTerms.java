package com.tech3.erp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "payment_terms", schema = "masters")
public class PaymentTerms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "term_name", nullable = false, length = 50)
    private String termName;

    @Column(name = "description")
    private String description;

    @Column(name = "active_flag", nullable = false)
    private boolean activeFlag = true;

    public PaymentTerms() {
    }

    public PaymentTerms(Long id, String termName, String description, boolean activeFlag) {
        this.id = id;
        this.termName = termName;
        this.description = description;
        this.activeFlag = activeFlag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTermName() {
        return termName;
    }

    public void setTermName(String termName) {
        this.termName = termName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
}