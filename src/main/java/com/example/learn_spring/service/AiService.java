package com.example.learn_spring.service;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AiService {

  private static final Logger logger = LoggerFactory.getLogger(AiService.class);
  private final ChatModel chatModel;

  public AiService(ChatModel chatModel) {
    this.chatModel = chatModel;
  }

  public String generateLearningPathRecommendation(String name, String techStack) {
    try {
      String prompt = String.format(
          "Give a very short learning recommendation for %s with tech stack: %s. " +
              "Maximum 80 characters. Be concise and actionable.",
          name, techStack);

      logger.info("Sending request to AI service for user: {}", name);
      String response = chatModel.call(prompt);
      logger.info("Successfully received AI response for user: {}", name);
      return truncateResponse(response, 80);

    } catch (Exception e) {
      logger.error("Error generating learning path for {}: {}", name, e.getMessage());
      return generateFallbackLearningPath(name, techStack);
    }
  }

  public String generateResponse(String userMessage) {
    try {
      String prompt = userMessage + " (Answer in max 80 characters)";
      logger.info("Sending chat request to AI service");
      String response = chatModel.call(prompt);
      logger.info("Successfully received AI chat response");
      return truncateResponse(response, 80);

    } catch (Exception e) {
      logger.error("Error generating AI response: {}", e.getMessage());
      return "AI service unavailable. Try again later.";
    }
  }

  private String generateFallbackLearningPath(String name, String techStack) {
    if (techStack == null || techStack.isEmpty()) {
      return "Focus on fundamentals: algorithms, system design, best practices";
    }

    String[] techs = techStack.split(",");
    String mainTech = techs[0].trim();
    return String.format("Master %s fundamentals, build projects, learn system design", mainTech);
  }

  private String truncateResponse(String response, int maxLength) {
    if (response == null || response.length() <= maxLength) {
      return response;
    }
    return response.substring(0, maxLength - 3) + "...";
  }
}
