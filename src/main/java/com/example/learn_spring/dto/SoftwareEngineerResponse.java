package com.example.learn_spring.dto;

import java.time.LocalDateTime;

public class SoftwareEngineerResponse {

  private Integer id;
  private String name;
  private String techStack;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  public SoftwareEngineerResponse() {
  }

  public SoftwareEngineerResponse(Integer id, String name, String techStack,
      LocalDateTime createdAt, LocalDateTime updatedAt) {
    this.id = id;
    this.name = name;
    this.techStack = techStack;
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
