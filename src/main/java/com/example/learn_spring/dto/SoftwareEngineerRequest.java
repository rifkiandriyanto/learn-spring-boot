package com.example.learn_spring.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class SoftwareEngineerRequest {

  @NotBlank(message = "Name is required")
  @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
  private String name;

  @Size(max = 500, message = "Tech stack must not exceed 500 characters")
  private String techStack;

  public SoftwareEngineerRequest() {
  }

  public SoftwareEngineerRequest(String name, String techStack) {
    this.name = name;
    this.techStack = techStack;
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
}
