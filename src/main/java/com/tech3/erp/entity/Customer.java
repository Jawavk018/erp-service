package com.tech3.erp.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer", schema = "masters")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(nullable = false)
    private String gstno;

    @Column(nullable = false)
    private String pancard;

    @Column(nullable = false)
    private String mobileno;

    private String email;
    private String iecCode;
    private String cinNo;
    private String tinNo;
    private String msmeUdyam;

    @ManyToOne
    @JoinColumn(name = "address_id") // FK column to main address
    private Address address; // only ONE primary address (not a list)

    @Column(name = "active_flag", nullable = false)
    private boolean activeFlag = true;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getGstno() { return gstno; }
    public void setGstno(String gstno) { this.gstno = gstno; }

    public String getPancard() { return pancard; }
    public void setPancard(String pancard) { this.pancard = pancard; }

    public String getMobileno() { return mobileno; }
    public void setMobileno(String mobileno) { this.mobileno = mobileno; }

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

//    public List<Address> getAddressList() { return addressList; }
//    public void setAddressList(List<Address> addressList) {
//        this.addressList = addressList;
//        if (addressList != null) {
//            addressList.forEach(a -> a.setCustomer(this));
//        }
//    }
    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }

    public boolean getActiveFlag() { return activeFlag; }
    public void setActiveFlag(boolean activeFlag) { this.activeFlag = activeFlag; }
}
