package com.project.department.controllers;

import com.project.department.dto.DepartmentDTO;
import com.project.department.exceptions.ResourceNotFoundException;
import com.project.department.services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//    GET: /departments
//    POST: /departments
//    PUT: /departments
//    DELETE: /departments
//    GET: /departments/{id}

@RestController
@RequestMapping(path="/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    //  GET: /departments/{id}

    @GetMapping(path ="/{departmentId}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable(name="departmentId") Long id){
        Optional<DepartmentDTO> departmentDTO=departmentService.getDepartmentById(id);
        return departmentDTO
                .map(departmentDTO1 -> ResponseEntity.ok(departmentDTO1))
                .orElseThrow(()->new ResourceNotFoundException("Department not found with the given id :"+id));
    }

    //    GET: /departments

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments() {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    //    POST: /departments

    @PostMapping
    public ResponseEntity<DepartmentDTO> createNewDepartment(@RequestBody @Valid DepartmentDTO inputDepartment) {
        DepartmentDTO savedDepartment = departmentService.createNewDepartment(inputDepartment);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    //    PUT: /departments

    @PutMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentDTO> updateDepartmentById(@RequestBody @Valid DepartmentDTO departmentDTO, @PathVariable Long departmentId) {
        return ResponseEntity.ok(departmentService.updateDepartmentById(departmentId, departmentDTO));
    }

    //    DELETE: /departments

    @DeleteMapping(path = "/{departmentId}")
    public ResponseEntity<Boolean> deleteDepartmentById(@PathVariable Long departmentId) {
        boolean gotDeleted = departmentService.deleteDepartmentById(departmentId);
        if (gotDeleted) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }
}
