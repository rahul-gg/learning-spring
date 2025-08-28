package com.rahulyrn;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController {

    private final SoftwareEngineerService softwareEngineerService;

    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }

    @GetMapping
    public List<SoftwareEngineer> getEngineers() {
        return softwareEngineerService.getEngineers();
    }

    @PostMapping
    public SoftwareEngineer createEngineer(@RequestBody SoftwareEngineer person) {
        return softwareEngineerService.createEngineer(person);
    }

}
