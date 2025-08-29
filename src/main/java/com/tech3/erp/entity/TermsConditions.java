package com.tech3.erp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "terms_conditions", schema = "masters")
public class TermsConditions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "terms_conditions_name", unique = true, nullable = false, length = 50)
    private String termsConditionsName;

    @Column(name = "description")
    private String description;

    @Column(name = "active_flag")
    private boolean activeFlag = true;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTermsConditionsName() { return termsConditionsName; }
    public void setTermsConditionsName(String termsConditionsName) { this.termsConditionsName = termsConditionsName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public boolean getActiveFlag() { return activeFlag; }
    public void setActiveFlag(boolean activeFlag) { this.activeFlag = activeFlag; }
}

