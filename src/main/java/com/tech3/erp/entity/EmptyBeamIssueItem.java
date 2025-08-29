package com.tech3.erp.entity;

import jakarta.persistence.*;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "empty_beam_issue_item", schema = "masters")
public class EmptyBeamIssueItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "empty_beam_issue_id", nullable = false)
    @JsonBackReference
    private EmptyBeamIssue emptyBeamIssue;
    
    private Long flangeId;
    
    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EmptyBeamIssue getEmptyBeamIssue() {
        return emptyBeamIssue;
    }

    public void setEmptyBeamIssue(EmptyBeamIssue emptyBeamIssue) {
        this.emptyBeamIssue = emptyBeamIssue;
    }
    
    public Long getFlangeId() { 
    	return flangeId; 
    }
    public void setFlangeId(Long flangeId) { 
    	this.flangeId = flangeId; 
    }

}
