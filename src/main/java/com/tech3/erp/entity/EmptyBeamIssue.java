package com.tech3.erp.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "empty_beam_issue", schema = "masters")
public class EmptyBeamIssue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String emptyBeamNo;
    private Date emptyBeamIssueDate;
    private Long vendorId;
    private Long consigneeId;
    private String vechileNo;
    
//    private static int salesOrderCounter = 1;
//    private static int internalOrderCounter = 1;
//    
    @OneToMany(mappedBy = "emptyBeamIssue", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<EmptyBeamIssueItem> items;

    
    @PrePersist
    public void prePersist() {
        if (this.emptyBeamNo == null || this.emptyBeamNo.isEmpty()) {
            this.emptyBeamNo = generateEmptyBeamNo();
        }
    }

    private String generateEmptyBeamNo() {
        String datePart = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        int randomNum = new Random().nextInt(9000) + 1000;
        return "EBN-" + datePart + "-" + randomNum;
    }

    // Getters and Setters
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getEmptyBeamNo() {
        return emptyBeamNo;
    }
    
    public void setEmptyBeamNo(String emptyBeamNo) {
        this.emptyBeamNo = emptyBeamNo;
    }
    
    public Date getEmptyBeamIssueDate() {
        return emptyBeamIssueDate;
    }

    public void setEmptyBeamIssueDate(Date emptyBeamIssueDate) {
        this.emptyBeamIssueDate = emptyBeamIssueDate;
    }

    public Long getConsigneeId() {
        return consigneeId;
    }

    public void setConsigneeId(Long consigneeId) {
        this.consigneeId = consigneeId;
    }
    
    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public String getVechileNo() {
        return vechileNo;
    }

    public void setVechileNo(String vechileNo) {
        this.vechileNo = vechileNo;
    }
    
    public List<EmptyBeamIssueItem> getItems() { return items; }
    
    public void setItems(List<EmptyBeamIssueItem> items) { this.items = items; }
    
}
