package com.example.learn_spring.dto;

import java.time.LocalDateTime;

public class SoftwareEngineerResponse {

  private Integer id;
  private String name;
  private String techStack;
  private String learningPathRecommendation; // Added
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  public SoftwareEngineerResponse() {
  }

  public SoftwareEngineerResponse(Integer id, String name, String techStack,
      String learningPathRecommendation,
      LocalDateTime createdAt, LocalDateTime updatedAt) {
    this.id = id;
    this.name = name;
    this.techStack = techStack;
    this.learningPathRecommendation = learningPathRecommendation;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  // Getters & Setters
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTechStack() {
    return techStack;
  }

  public void setTechStack(String techStack) {
    this.techStack = techStack;
  }

  // Added: Getter & Setter for learningPathRecommendation
  public String getLearningPathRecommendation() {
    return learningPathRecommendation;
  }

  public void setLearningPathRecommendation(String learningPathRecommendation) {
    this.learningPathRecommendation = learningPathRecommendation;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }
}
