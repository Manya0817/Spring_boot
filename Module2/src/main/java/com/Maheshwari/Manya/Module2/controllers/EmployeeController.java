package com.Maheshwari.Manya.Module2.controllers;

import com.Maheshwari.Manya.Module2.dto.EmployeeDTO;
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

    @GetMapping(path="/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name="employeeId") Long id){
        return new EmployeeDTO(id,"Manya","maheshwarimanya@gmail.com",22, LocalDate.of(2026,01,23),true);
    }

    @GetMapping
    public String getAllEmployees(@RequestParam(required = false,name="inputAge") Integer age,
                                  @RequestParam(required = false) String sortBy){
        return "Hi age "+age+" "+sortBy;
    }

    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee){
        inputEmployee.setId(100L);
        return inputEmployee;
    }

    @PutMapping String updateEmployeeById(){
        return "Hello from put";
    }
}
