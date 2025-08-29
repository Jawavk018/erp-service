package com.tech3.erp.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer_international", schema = "masters")
public class CustomerInternational {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(nullable = false)
    private String mobileno;

    private String email;
    private String iecCode;
    private String cinNo;
    private String tinNo;
    private String ircNo;
    private String binNo;

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

    public String getIrcNo() { return ircNo; }
    public void setIrcNo(String ircNo) { this.ircNo = ircNo; }
    
    public String getBinNo() { return binNo; }
    public void setBinNo(String binNo) { this.binNo = binNo; }
    

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
