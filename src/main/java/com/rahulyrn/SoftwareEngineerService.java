package com.rahulyrn;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareEngineerService {

    private final SoftwareEngineerRepository softwareEngineerRepository;

    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository) {
        this.softwareEngineerRepository = softwareEngineerRepository;
    }

    public List<SoftwareEngineer> getEngineers(){
        return softwareEngineerRepository.findAll();
    }

    public SoftwareEngineer createEngineer(SoftwareEngineer person){
        return softwareEngineerRepository.save(person);
    }
}
