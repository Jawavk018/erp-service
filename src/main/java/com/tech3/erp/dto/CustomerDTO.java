package com.tech3.erp.dto;

import com.tech3.erp.entity.Customer;

public class CustomerDTO {

    private Long id;
    private String customerName;
    private String gstNo;
    private String panCard;
    private String mobileNo;
    private String email;
    private String iecCode;
    private String cinNo;
    private String tinNo;
    private String msmeUdyam;
    private Boolean activeFlag;
    private AddressDTO address;

    public CustomerDTO() {}

    public CustomerDTO(Customer customer) {
        this.id = customer.getId();
        this.customerName = customer.getCustomerName();
        this.gstNo = customer.getGstno();
        this.panCard = customer.getPancard();
        this.mobileNo = customer.getMobileno();
        this.iecCode = customer.getIecCode();
        this.cinNo = customer.getCinNo();
        this.tinNo = customer.getTinNo();
        this.msmeUdyam = customer.getMsmeUdyam();
        this.email = customer.getEmail();
        this.activeFlag = customer.getActiveFlag();
        if (customer.getAddress() != null) {
            this.address = new AddressDTO(customer.getAddress());
        }
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getGstNo() { return gstNo; }
    public void setGstNo(String gstNo) { this.gstNo = gstNo; }

    public String getPanCard() { return panCard; }
    public void setPanCard(String panCard) { this.panCard = panCard; }

    public String getMobileNo() { return mobileNo; }
    public void setMobileNo(String mobileNo) { this.mobileNo = mobileNo; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getIecCode() { return iecCode; }
    public void setIecCode(String iecCode) { this.iecCode = iecCode; }

    public String getCinNo() { return cinNo; }
    public void setCinNo(String cinNo) { this.cinNo = cinNo; }

    public String getTinNo() { return tinNo; }
    public void setTinNo(String tinNo) { this.tinNo = tinNo; }

    public String getMsmeUdyam() { return msmeUdyam; }
    public void setMsmeUdyam(String msmeUdyam) { this.msmeUdyam = msmeUdyam; }
    
    public Boolean getActiveFlag() { return activeFlag; }
    public void setActiveFlag(Boolean activeFlag) { this.activeFlag = activeFlag; }

    public AddressDTO getAddress() { return address; }
    public void setAddress(AddressDTO address) { this.address = address; }
}
