package com.example.learn_spring;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

  @GetMapping("{id}")
  public SoftwareEngineer getEngineerById(@PathVariable Integer id) {
    return softwareEngineerService.getSoftwareEngineerById(id);
  }

  @PostMapping
  public void addNewSoftwareEngineer(@RequestBody SoftwareEngineer softwareEngineer) {
    softwareEngineerService.insertSoftwareEngineer(softwareEngineer);
  }

}
