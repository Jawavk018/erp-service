package com.tech3.erp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "state", schema = "masters")
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "country_sno", nullable = false)
    private Country country;

    @Column(name = "state_name", nullable = false, length = 100)
    @NotNull
    @Size(min = 1, max = 100)
    private String stateName;

    @Column(name = "active_flag", nullable = false)
    private boolean activeFlag = true;

    // Constructors
    public State() {}

    public State(Long id, Country country, String stateName, boolean activeFlag) {
        this.id = id;
        this.country = country;
        this.stateName = stateName;
        this.activeFlag = activeFlag;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
}
