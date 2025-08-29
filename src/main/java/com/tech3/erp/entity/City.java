package com.tech3.erp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "city", schema = "masters")
public class City {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "state_sno", nullable = false)
    private State state;

    @ManyToOne
    @JoinColumn(name = "country_sno", nullable = false)  // Add this field
    private Country country;

    @Column(name = "city_name", nullable = false, length = 100)
    private String cityName;

    @Column(name = "active_flag", columnDefinition = "boolean default true")
    private boolean activeFlag;

    // Constructors
    public City() {}

    public City(Long id, State state, String cityName, boolean activeFlag) {
        this.id = id;
        this.state = state;
        this.cityName = cityName;
        this.activeFlag = activeFlag;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public State getState() { return state; }
    public void setState(State state) { this.state = state; }

    public Country getCountry() { return country; }  // Add this getter
    public void setCountry(Country country) { this.country = country; }  // Add this setter

    public String getCityName() { return cityName; }
    public void setCityName(String cityName) { this.cityName = cityName; }

    public boolean getActiveFlag() { return activeFlag; }
    public void setActiveFlag(boolean activeFlag) { this.activeFlag = activeFlag; }
}
