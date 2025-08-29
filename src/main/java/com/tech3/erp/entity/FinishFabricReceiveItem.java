package com.tech3.erp.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "finish_fabric_receive_items", schema = "masters")
public class FinishFabricReceiveItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "finished_fabric_code")
    private String finishedFabricCode;

    @Column(name = "roll_no")
    private String rollNo;

    @Column(name = "roll_yards")
    private String rollYards;

    @Column(name = "weight")
    private String weight;

    @Column(name = "grade_id")
    private Long gradeId;

    @Column(name = "warehouse_id")
    private Long warehouseId;

    @Column(name = "active_flag")
    private Boolean activeFlag = true;

    @ManyToOne
    @JoinColumn(name = "finish_fabric_receive_id")
    private FinishFabricReceive finishFabricReceive;

 // Getters
    public Long getId() {
        return id;
    }

    public String getFinishedFabricCode() {
        return finishedFabricCode;
    }

    public String getRollNo() {
        return rollNo;
    }

    public String getRollYards() {
        return rollYards;
    }

    public String getWeight() {
        return weight;
    }

    public Long getGradeId() {
        return gradeId;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public Boolean getActiveFlag() {
        return activeFlag;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setFinishedFabricCode(String finishedFabricCode) {
        this.finishedFabricCode = finishedFabricCode;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public void setRollYards(String rollYards) {
        this.rollYards = rollYards;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

	public void setFinishFabricReceive(FinishFabricReceive receive) {
		// TODO Auto-generated method stub
		
	}
}

