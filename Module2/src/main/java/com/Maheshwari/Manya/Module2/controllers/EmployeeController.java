package com.Maheshwari.Manya.Module2.controllers;

import com.Maheshwari.Manya.Module2.dto.EmployeeDTO;
import com.Maheshwari.Manya.Module2.entities.EmployeeEntity;
import com.Maheshwari.Manya.Module2.repositories.EmployeeRepository;
import com.Maheshwari.Manya.Module2.services.EmployeeService;
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

//    private final EmployeeRepository employeeRepository;

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

//    public EmployeeController(EmployeeRepository employeeRepository) {
//        this.employeeRepository = employeeRepository;
//    }

    @GetMapping(path="/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name="employeeId") Long id){
//        return new EmployeeDTO(id,"Manya","maheshwarimanya@gmail.com",22, LocalDate.of(2026,01,23),true);
//        return employeeRepository.findById(id).orElse(null);
        return employeeService.getEmployeeById(id);
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees(@RequestParam(required = false,name="inputAge") Integer age,
                                                @RequestParam(required = false) String sortBy){
//        return "Hi age "+age+" "+sortBy;
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee){
//        inputEmployee.setId(100L);
//        return inputEmployee;
        return employeeService.createNewEmployee(inputEmployee);
    }

    @PutMapping String updateEmployeeById(){
        return "Hello from put";
    }
}
