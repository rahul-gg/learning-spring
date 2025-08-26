package com.rahulyrn;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController {

//    @GetMapping
//    public String names(){
//        return "Rahul singhal";
//    }

    @GetMapping
    public ArrayList<SoftwareEngineer> getEngineers(){
        ArrayList<SoftwareEngineer> engineers = new ArrayList<SoftwareEngineer>();
        SoftwareEngineer rahul = new SoftwareEngineer(1, "Rahul", "Java");
        SoftwareEngineer rohan = new SoftwareEngineer(2, "Rohan", "C");
        engineers.add(rahul);
        engineers.add(rohan);
        return engineers;
    }

}
