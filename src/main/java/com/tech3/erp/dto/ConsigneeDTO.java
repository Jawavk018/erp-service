package com.tech3.erp.dto;

import com.tech3.erp.entity.Consignee;

public class ConsigneeDTO {

    private Long id;
    private String consigneeName;
    private String gstNo;
    private String panCard;
    private String mobileNo;
    private String email;
    private Boolean activeFlag;
    private AddressDTO address;

    public ConsigneeDTO() {}

    public ConsigneeDTO(Consignee consignee) {
        this.id = consignee.getId();
        this.consigneeName = consignee.getConsigneeName();
        this.gstNo = consignee.getGstno();
        this.panCard = consignee.getPancard();
        this.mobileNo = consignee.getMobileno();
        this.email = consignee.getEmail();
        this.activeFlag = consignee.getActiveFlag();
        if (consignee.getAddress() != null) {
            this.address = new AddressDTO(consignee.getAddress());
        }
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getConsigneeName() { return consigneeName; }
    public void setConsigneeName(String consigneeName) { this.consigneeName = consigneeName; }

    public String getGstNo() { return gstNo; }
    public void setGstNo(String gstNo) { this.gstNo = gstNo; }

    public String getPanCard() { return panCard; }
    public void setPanCard(String panCard) { this.panCard = panCard; }

    public String getMobileNo() { return mobileNo; }
    public void setMobileNo(String mobileNo) { this.mobileNo = mobileNo; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Boolean getActiveFlag() { return activeFlag; }
    public void setActiveFlag(Boolean activeFlag) { this.activeFlag = activeFlag; }

    public AddressDTO getAddress() { return address; }
    public void setAddress(AddressDTO address) { this.address = address; }
}
