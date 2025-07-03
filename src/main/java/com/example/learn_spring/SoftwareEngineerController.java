package com.example.learn_spring;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController {
  private final SoftwareEngineerService softwareEngineerService;

  SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
    this.softwareEngineerService = softwareEngineerService;
  }

  @GetMapping
  public List<SoftwareEngineer> getEngineers() {
    return softwareEngineerService.getAllSoftwareEngineers();
  }

}
