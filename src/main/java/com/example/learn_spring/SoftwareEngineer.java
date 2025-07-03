package com.example.learn_spring;

import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SoftwareEngineer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String techStack; // Simple String, bukan List

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

    // hashCode & equals
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
                '}';
    }
}
