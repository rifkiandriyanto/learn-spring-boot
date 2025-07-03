package com.example.learn_spring;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class SoftwareEngineer {
    private Integer id;
    private String name;
    private List<String> techStack;

    public SoftwareEngineer() {
    }

    // Constructor yang fixed - convert String ke List<String>
    public SoftwareEngineer(Integer id, String name, String techStack) {
        this.id = id;
        this.name = name;
        // Split comma-separated string menjadi List
        this.techStack = Arrays.asList(techStack.split("\\s*,\\s*"));
    }

    // Getters & Setters yang konsisten
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

    // Fixed: return List<String> bukan String
    public List<String> getTechStack() {
        return techStack;
    }

    // Fixed: parameter List<String> bukan String
    public void setTechStack(List<String> techStack) {
        this.techStack = techStack;
    }

    // Setter tambahan untuk String input
    public void setTechStackFromString(String techStack) {
        this.techStack = Arrays.asList(techStack.split("\\s*,\\s*"));
    }

    // Modern hashCode menggunakan Objects.hash()
    @Override
    public int hashCode() {
        return Objects.hash(id, name, techStack);
    }

    // Modern equals menggunakan Objects.equals() - LENGKAP
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
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
                ", techStack=" + techStack +
                '}';
    }
}
