package com.example.learn_spring.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.learn_spring.dto.SoftwareEngineerRequest;
import com.example.learn_spring.dto.SoftwareEngineerResponse;
import com.example.learn_spring.entity.SoftwareEngineer;
import com.example.learn_spring.repository.SoftwareEngineerRepository;

@Service
@Transactional
public class SoftwareEngineerService {

  private final SoftwareEngineerRepository softwareEngineerRepository;
  private final AiService aiService; // Added

  public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository,
      AiService aiService) { // Added
    this.softwareEngineerRepository = softwareEngineerRepository;
    this.aiService = aiService; // Added
  }

  /**
   * GET All - Ambil semua software engineers
   */
  @Transactional(readOnly = true)
  public List<SoftwareEngineerResponse> getAllSoftwareEngineers() {
    return softwareEngineerRepository.findAll()
        .stream()
        .map(this::convertToResponse)
        .collect(Collectors.toList());
  }

  /**
   * GET by ID - Ambil software engineer berdasarkan ID
   */
  @Transactional(readOnly = true)
  public SoftwareEngineerResponse getSoftwareEngineerById(Integer id) {
    SoftwareEngineer engineer = findEngineerById(id);
    return convertToResponse(engineer);
  }

  /**
   * POST - Buat software engineer baru dengan AI Learning Path
   */
  public SoftwareEngineerResponse createSoftwareEngineer(SoftwareEngineerRequest request) {
    SoftwareEngineer engineer = new SoftwareEngineer();
    engineer.setName(request.getName());
    engineer.setTechStack(request.getTechStack());

    // Added: Generate learning path recommendation using AI
    if (request.getTechStack() != null && !request.getTechStack().trim().isEmpty()) {
      String learningPath = aiService.generateLearningPathRecommendation(
          request.getName(),
          request.getTechStack());
      engineer.setLearningPathRecommendation(learningPath);
    }

    SoftwareEngineer savedEngineer = softwareEngineerRepository.save(engineer);
    return convertToResponse(savedEngineer);
  }

  /**
   * PUT - Update software engineer berdasarkan ID
   */
  public SoftwareEngineerResponse updateSoftwareEngineer(Integer id, SoftwareEngineerRequest request) {
    SoftwareEngineer existingEngineer = findEngineerById(id);

    existingEngineer.setName(request.getName());
    existingEngineer.setTechStack(request.getTechStack());

    // Added: Update learning path if tech stack changed
    if (request.getTechStack() != null && !request.getTechStack().trim().isEmpty()) {
      String learningPath = aiService.generateLearningPathRecommendation(
          request.getName(),
          request.getTechStack());
      existingEngineer.setLearningPathRecommendation(learningPath);
    }

    SoftwareEngineer updatedEngineer = softwareEngineerRepository.save(existingEngineer);
    return convertToResponse(updatedEngineer);
  }

  /**
   * DELETE - Hapus software engineer berdasarkan ID
   */
  public void deleteSoftwareEngineer(Integer id) {
    SoftwareEngineer engineer = findEngineerById(id);
    softwareEngineerRepository.delete(engineer);
  }

  /**
   * Helper method untuk mencari engineer berdasarkan ID
   */
  private SoftwareEngineer findEngineerById(Integer id) {
    return softwareEngineerRepository.findById(id)
        .orElseThrow(() -> new IllegalStateException(
            "Software Engineer with id " + id + " not found"));
  }

  /**
   * Helper method untuk convert Entity ke Response DTO
   */
  private SoftwareEngineerResponse convertToResponse(SoftwareEngineer engineer) {
    return new SoftwareEngineerResponse(
        engineer.getId(),
        engineer.getName(),
        engineer.getTechStack(),
        engineer.getLearningPathRecommendation(), // Added
        engineer.getCreatedAt(),
        engineer.getUpdatedAt());
  }
}
