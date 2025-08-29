package com.tech3.erp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "po_type_master", schema = "masters")
public class PoTypeMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "po_type_name", nullable = false, unique = true, length = 100)
    private String poTypeName;

    @Column(name = "description")
    private String description;

    @Column(name = "active_flag", nullable = false)
    private boolean activeFlag = true;

    // Constructors
    public PoTypeMaster() {}

    public PoTypeMaster(Long id) {
        this.id = id;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPoTypeName() {
        return poTypeName;
    }

    public void setPoTypeName(String poTypeName) {
        this.poTypeName = poTypeName;
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
