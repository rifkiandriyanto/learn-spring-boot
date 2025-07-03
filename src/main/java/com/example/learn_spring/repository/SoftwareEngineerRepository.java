package com.example.learn_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.learn_spring.entity.SoftwareEngineer;

import java.util.List;
import java.util.Optional;

@Repository
public interface SoftwareEngineerRepository extends JpaRepository<SoftwareEngineer, Integer> {

  // Custom query untuk mencari berdasarkan nama
  Optional<SoftwareEngineer> findByName(String name);

  // Custom query untuk mencari berdasarkan tech stack
  List<SoftwareEngineer> findByTechStackContainingIgnoreCase(String techStack);

  // Custom query dengan JPQL
  @Query("SELECT se FROM SoftwareEngineer se WHERE se.name LIKE %:name%")
  List<SoftwareEngineer> findByNameContaining(@Param("name") String name);
}
