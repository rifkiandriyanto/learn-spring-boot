package com.example.learn_spring.entity;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "software_engineers")
public class SoftwareEngineer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
  private String name;

  @Column(name = "tech_stack")
  private String techStack;

  @CreationTimestamp
  @Column(name = "created_at", updatable = false)
  private LocalDateTime createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  // Default constructor
  public SoftwareEngineer() {
  }

  // Constructor dengan semua parameter
  public SoftwareEngineer(Integer id, String name, String techStack) {
    this.id = id;
    this.name = name;
    this.techStack = techStack;
  }

  // Constructor tanpa ID (untuk insert baru)
  public SoftwareEngineer(String name, String techStack) {
    this.name = name;
    this.techStack = techStack;
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

  @Override
  public int hashCode() {
    return Objects.hash(id, name, techStack);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null || getClass() != obj.getClass())
      return false;

    SoftwareEngineer other = (SoftwareEngineer) obj;
    return Objects.equals(id, other.id) &&
        Objects.equals(name, other.name) &&
        Objects.equals(techStack, other.techStack);
  }

  @Override
  public String toString() {
    return "SoftwareEngineer{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", techStack='" + techStack + '\'' +
        ", createdAt=" + createdAt +
        ", updatedAt=" + updatedAt +
        '}';
  }
}
