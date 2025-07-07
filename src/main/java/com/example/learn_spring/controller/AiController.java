package com.example.learn_spring.controller;

import com.example.learn_spring.service.AiService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/ai")
public class AiController {

  private final AiService aiService;

  public AiController(AiService aiService) {
    this.aiService = aiService;
  }

  @PostMapping("/learning-path")
  public Map<String, String> generateLearningPath(@RequestBody Map<String, String> request) {
    String name = request.get("name");
    String techStack = request.get("techStack");

    String learningPath = aiService.generateLearningPathRecommendation(name, techStack);

    return Map.of(
        "name", name,
        "techStack", techStack,
        "learningPath", learningPath,
        "provider", "Monica AI");
  }

  @PostMapping("/chat")
  public Map<String, String> chat(@RequestBody Map<String, String> request) {
    String message = request.get("message");
    String response = aiService.generateResponse(message);

    return Map.of(
        "message", message,
        "response", response,
        "model", "monica-ai");
  }

  @GetMapping("/test")
  public Map<String, String> test() {
    String response = aiService.generateResponse("Hello, can you introduce yourself?");

    return Map.of(
        "test", "success",
        "response", response,
        "provider", "Monica AI via OpenAI Compatible API");
  }
}
