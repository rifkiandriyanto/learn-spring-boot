package com.example.learn_spring.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;

@Configuration
public class EnvConfig {

  @PostConstruct
  public void loadEnv() {
    try {
      Dotenv dotenv = Dotenv.configure()
          .directory("./")
          .filename(".env")
          .ignoreIfMissing()
          .load();

      // Set system properties dari .env
      dotenv.entries().forEach(entry -> {
        System.setProperty(entry.getKey(), entry.getValue());
      });

      System.out.println("✅ Environment variables loaded from .env file");
    } catch (Exception e) {
      System.out.println("⚠️  Could not load .env file: " + e.getMessage());
    }
  }
}
