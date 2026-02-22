package com.module4.productionReadyFeatures.productionReadyFeatures.clients;

import com.module4.productionReadyFeatures.productionReadyFeatures.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeClient {
    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO getEmployeeById(Long employeeId);

    EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO);
}
