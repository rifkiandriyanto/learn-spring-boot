package com.example.learn_spring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.learn_spring.dto.SoftwareEngineerRequest;
import com.example.learn_spring.dto.SoftwareEngineerResponse;
import com.example.learn_spring.service.SoftwareEngineerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/software-engineers")
@Validated
public class SoftwareEngineerController {

  private final SoftwareEngineerService softwareEngineerService;

  public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
    this.softwareEngineerService = softwareEngineerService;
  }

  /**
   * GET - Retrieve all software engineers
   */
  @GetMapping
  public ResponseEntity<List<SoftwareEngineerResponse>> getAllEngineers() {
    List<SoftwareEngineerResponse> engineers = softwareEngineerService.getAllSoftwareEngineers();
    return ResponseEntity.ok(engineers);
  }

  /**
   * GET by ID - Retrieve software engineer by ID
   */
  @GetMapping("/{id}")
  public ResponseEntity<SoftwareEngineerResponse> getEngineerById(@PathVariable Integer id) {
    SoftwareEngineerResponse engineer = softwareEngineerService.getSoftwareEngineerById(id);
    return ResponseEntity.ok(engineer);
  }

  /**
   * POST - Create new software engineer
   */
  @PostMapping
  public ResponseEntity<SoftwareEngineerResponse> createSoftwareEngineer(
      @Valid @RequestBody SoftwareEngineerRequest request) {
    SoftwareEngineerResponse createdEngineer = softwareEngineerService.createSoftwareEngineer(request);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdEngineer);
  }

  /**
   * PUT - Update software engineer by ID
   */
  @PutMapping("/{id}")
  public ResponseEntity<SoftwareEngineerResponse> updateSoftwareEngineer(
      @PathVariable Integer id,
      @Valid @RequestBody SoftwareEngineerRequest request) {
    SoftwareEngineerResponse updatedEngineer = softwareEngineerService.updateSoftwareEngineer(id, request);
    return ResponseEntity.ok(updatedEngineer);
  }

  /**
   * DELETE - Delete software engineer by ID
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteSoftwareEngineer(@PathVariable Integer id) {
    softwareEngineerService.deleteSoftwareEngineer(id);
    return ResponseEntity.ok("Software Engineer with id " + id + " has been deleted successfully");
  }
}
