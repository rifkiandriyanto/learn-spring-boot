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
   * GET - Ambil semua software engineers
   */
  @GetMapping
  public ResponseEntity<List<SoftwareEngineerResponse>> getAllEngineers() {
    List<SoftwareEngineerResponse> engineers = softwareEngineerService.getAllSoftwareEngineers();
    return ResponseEntity.ok(engineers);
  }

  /**
   * GET by ID - Ambil software engineer berdasarkan ID
   */
  @GetMapping("/{id}")
  public ResponseEntity<SoftwareEngineerResponse> getEngineerById(@PathVariable Integer id) {
    SoftwareEngineerResponse engineer = softwareEngineerService.getSoftwareEngineerById(id);
    return ResponseEntity.ok(engineer);
  }

  /**
   * POST - Buat software engineer baru
   */
  @PostMapping
  public ResponseEntity<SoftwareEngineerResponse> createSoftwareEngineer(
      @Valid @RequestBody SoftwareEngineerRequest request) {
    SoftwareEngineerResponse createdEngineer = softwareEngineerService.createSoftwareEngineer(request);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdEngineer);
  }

  /**
   * PUT - Update software engineer berdasarkan ID
   */
  @PutMapping("/{id}")
  public ResponseEntity<SoftwareEngineerResponse> updateSoftwareEngineer(
      @PathVariable Integer id,
      @Valid @RequestBody SoftwareEngineerRequest request) {
    SoftwareEngineerResponse updatedEngineer = softwareEngineerService.updateSoftwareEngineer(id, request);
    return ResponseEntity.ok(updatedEngineer);
  }

  /**
   * DELETE - Hapus software engineer berdasarkan ID
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteSoftwareEngineer(@PathVariable Integer id) {
    softwareEngineerService.deleteSoftwareEngineer(id);
    return ResponseEntity.ok("Software Engineer with id " + id + " has been deleted successfully");
  }
}
