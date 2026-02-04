package com.project.department.services;

import com.project.department.DepartmentApplication;
import com.project.department.dto.DepartmentDTO;
import com.project.department.entities.DepartmentEntity;
import com.project.department.exceptions.ResourceNotFoundException;
import com.project.department.repositories.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//GET: /departments
//POST: /departments
//PUT: /departments
//DELETE: /departments
//GET: /departments/{id}

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    public DepartmentService(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }

    //GET: /departments/{id}

    public Optional<DepartmentDTO> getDepartmentById(Long id){
        return departmentRepository.findById(id).map(departmentEntity ->modelMapper.map(departmentEntity,DepartmentDTO.class));
    }

    //GET: /departments

    public List<DepartmentDTO> getAllDepartments(){
        List<DepartmentEntity> departmentEntities=departmentRepository.findAll();
        return departmentEntities
                .stream()
                .map(departmentEntity -> modelMapper.map(departmentEntity,DepartmentDTO.class))
                .collect(Collectors.toList());
    }

    //POST: /departments

    public DepartmentDTO createNewDepartment(DepartmentDTO departmentDTO){
        DepartmentEntity toSaveEntity=modelMapper.map(departmentDTO,DepartmentEntity.class);
        DepartmentEntity savedEmployeeEntity=departmentRepository.save(toSaveEntity);
        return modelMapper.map(savedEmployeeEntity,DepartmentDTO.class);
    }

    //PUT: /departments

    public DepartmentDTO updateDepartmentById(Long departmentId,DepartmentDTO departmentDTO){
        isExistsByDepartmentId(departmentId);
        DepartmentEntity departmentEntity=modelMapper.map(departmentDTO,DepartmentEntity.class);
        departmentEntity.setId(departmentId);
        DepartmentEntity savedDepartmentEntity=departmentRepository.save(departmentEntity);
        return modelMapper.map(departmentEntity,DepartmentDTO.class);
    }

    //DELETE: /departments

    public boolean deleteDepartmentById(Long departmentId){
        isExistsByDepartmentId(departmentId);
        departmentRepository.deleteById(departmentId);
        return true;
    }

    public void isExistsByDepartmentId(Long departmentId){
        boolean exists=departmentRepository.existsById(departmentId);
        if(!exists)throw new ResourceNotFoundException("Depatment not found with given id: "+departmentId);
    }
}
