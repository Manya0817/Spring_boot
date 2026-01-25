package com.Maheshwari.Manya.Module2.controllers;

import com.Maheshwari.Manya.Module2.dto.EmployeeDTO;
import com.Maheshwari.Manya.Module2.entities.EmployeeEntity;
import com.Maheshwari.Manya.Module2.repositories.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController {
//    @GetMapping(path="/getSecretMessage")
//    public String getMySuperSecretMessage(){
//        return "Secret message : your_secret";
//    }

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping(path="/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable(name="employeeId") Long id){
//        return new EmployeeDTO(id,"Manya","maheshwarimanya@gmail.com",22, LocalDate.of(2026,01,23),true);
        return employeeRepository.findById(id).orElse(null);
    }

    @GetMapping
    public List<EmployeeEntity> getAllEmployees(@RequestParam(required = false,name="inputAge") Integer age,
                                                @RequestParam(required = false) String sortBy){
//        return "Hi age "+age+" "+sortBy;
        return employeeRepository.findAll();
    }

    @PostMapping
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity inputEmployee){
//        inputEmployee.setId(100L);
//        return inputEmployee;
        return employeeRepository.save(inputEmployee);
    }

    @PutMapping String updateEmployeeById(){
        return "Hello from put";
    }
}
