package com.example.learn_spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @GetMapping("/")
  public String helloWorld() {
    return "Hello world learn spring boot";
  }
}
