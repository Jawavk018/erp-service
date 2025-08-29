package com.tech3.erp.dto;

import com.tech3.erp.entity.Vendor;

public class VendorDTO {
    private Long id;
    private String vendorName;
    private String gstno;
    private String pancard;
    private String mobileno;
    private String email;
    private Boolean activeFlag;
    private String photoUrl;
    private AddressDTO address;

    public VendorDTO() {}

    public VendorDTO(Vendor vendor) {
        this.id = vendor.getId();
        this.vendorName = vendor.getVendorName();
        this.gstno = vendor.getGstno();
        this.pancard = vendor.getPancard();
        this.mobileno = vendor.getMobileno();
        this.email = vendor.getEmail();
        this.activeFlag = vendor.getActiveFlag();
        this.photoUrl = vendor.getPhotoUrl();
        if (vendor.getAddress() != null) {
            this.address = new AddressDTO(vendor.getAddress());
        }
    }

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

    public Boolean getActiveFlag() { return activeFlag; }
    public void setActiveFlag(Boolean activeFlag) { this.activeFlag = activeFlag; }

    public String getPhotoUrl() { return photoUrl; }
    public void setPhotoUrl(String photoUrl) { this.photoUrl = photoUrl; }
    
    public AddressDTO getAddress() { return address; }
    public void setAddress(AddressDTO address) { this.address = address; }
}