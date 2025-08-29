package com.tech3.erp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vendor", schema = "masters")
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vendor_name", nullable = false, length = 100)
    private String vendorName;

    @Column(nullable = false)
    private String gstno;

    @Column(nullable = false)
    private String pancard;

    @Column(nullable = false)
    private String mobileno;

    private String email;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @Column(name = "active_flag", nullable = false)
    private Boolean activeFlag = true;

    @Column(name = "photo_url")
    private String photoUrl;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getVendorName() { return vendorName; }
    public void setVendorName(String vendorName) { this.vendorName = vendorName; }

    public String getGstno() { return gstno; }
    public void setGstno(String gstno) { this.gstno = gstno; }

    public String getPancard() { return pancard; }
    public void setPancard(String pancard) { this.pancard = pancard; }

    public String getMobileno() { return mobileno; }
    public void setMobileno(String mobileno) { this.mobileno = mobileno; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }

    public Boolean getActiveFlag() { return activeFlag; }
    public void setActiveFlag(Boolean activeFlag) { this.activeFlag = activeFlag; }
    
    public String getPhotoUrl() { return photoUrl; }
    public void setPhotoUrl(String photoUrl) { this.photoUrl = photoUrl; }
}