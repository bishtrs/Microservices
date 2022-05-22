package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorRestController {
	
    List<Doctor> doctors = new ArrayList<>();
        
    public DoctorRestController() {
    	doctors.add(new Doctor("Andy Thomas", "Orthopedic"));
    	doctors.add(new Doctor("James Hardy", "Physician"));
    	doctors.add(new Doctor("Ana Marie", "Pediatric"));
    }

    @GetMapping("/{id}") 
    public Doctor get(@PathVariable("id") int id) {
    	System.out.println("id ##" + id);
        return doctors.get(id);
    }
}
   