package com.tech3.erp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tech3.erp.dto.FinishFabricReceiveDTO;
import com.tech3.erp.entity.FinishFabricReceive;
import com.tech3.erp.service.FinishFabricReceiveService;

import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/finish-fabric-receives")
@Tag(name = "Finish Fabric Receive Controller", description = "APIs for Finish Fabric Receive management")
public class FinishFabricReceiveController {

    private final FinishFabricReceiveService receiveService;

    @Autowired
    public FinishFabricReceiveController(FinishFabricReceiveService receiveService) {
        this.receiveService = receiveService;
    }

    @PostMapping
    public ResponseEntity<FinishFabricReceive> createFinishFabricReceive(
            @RequestBody FinishFabricReceiveDTO dto) {
        return ResponseEntity.ok(receiveService.createFinishFabricReceive(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FinishFabricReceive> getFinishFabricReceiveById(
            @PathVariable Long id) {
        return ResponseEntity.ok(receiveService.getFinishFabricReceiveById(id));
    }

    @GetMapping
    public ResponseEntity<List<FinishFabricReceive>> getAllFinishFabricReceives() {
        return ResponseEntity.ok(receiveService.getAllFinishFabricReceives());
    }

    @PutMapping("/{id}")
    public ResponseEntity<FinishFabricReceive> updateFinishFabricReceive(
            @PathVariable Long id, @RequestBody FinishFabricReceiveDTO dto) {
        return ResponseEntity.ok(receiveService.updateFinishFabricReceive(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFinishFabricReceive(@PathVariable Long id) {
        receiveService.deleteFinishFabricReceive(id);
        return ResponseEntity.noContent().build();
    }
}
