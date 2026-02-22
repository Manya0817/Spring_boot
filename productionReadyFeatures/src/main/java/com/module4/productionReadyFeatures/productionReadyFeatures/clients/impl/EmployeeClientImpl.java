package com.module4.productionReadyFeatures.productionReadyFeatures.clients.impl;

import com.module4.productionReadyFeatures.productionReadyFeatures.advice.ApiResponse;
import com.module4.productionReadyFeatures.productionReadyFeatures.clients.EmployeeClient;
import com.module4.productionReadyFeatures.productionReadyFeatures.dto.EmployeeDTO;
import com.module4.productionReadyFeatures.productionReadyFeatures.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeClientImpl implements EmployeeClient {

    private final RestClient restClient;

    Logger log= LoggerFactory.getLogger(EmployeeClientImpl.class);

    @Override
    public List<EmployeeDTO> getAllEmployees() {

//        log.error("error log");
//        log.warn("warn log");
//        log.info("info log");
//        log.debug("debug log");
//        log.trace("trace log");

        log.trace("Trying to retrieve all employees in getAllEmployees");
        try{
            log.info("Attempting to call the restClient method in getAllEmployees");
            ApiResponse<List<EmployeeDTO>> employeeDTOList=restClient.get()
                    .uri("employees")
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError,(req,res)->{
                        log.error(new String(res.getBody().readAllBytes()));
                        throw new ResourceNotFoundException("could not create the employees");
                    })
                    .body(new ParameterizedTypeReference<>() {
                    });

            log.debug("Successfully retrieved the employess in getAllEmployees");
            log.trace("Retrieved employees list in this getAllEmployees :{}", employeeDTOList.getData());

            return employeeDTOList.getData();

        }catch(Exception e){
            log.error("Exception occured in getAllEmployees",e);
            throw new RuntimeException(e);
        }

    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {
        log.trace("Trying to get Employee by Id in getEmployeeById with id : {}",employeeId);
        try{
            ApiResponse<EmployeeDTO> employeeResponse=restClient.get()
                    .uri("employees/{employeeId}",employeeId)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError,(req,res)->{
                        log.error(new String(res.getBody().readAllBytes()));
                        throw new ResourceNotFoundException("could not create the employees");
                    })
                    .body(new ParameterizedTypeReference<>() {
                    });

            return employeeResponse.getData();
        }catch(Exception e){
            log.error("Exception occured in getEmployeeById ",e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) {
        log.trace("Trying to create Employee with Information {}",employeeDTO);
        try{
            ResponseEntity<ApiResponse<EmployeeDTO>> employeeDTOApiResponse=restClient.post()
                    .uri("employees")
                    .body(employeeDTO)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError,(req,res)->{
                        log.debug("4xxClient error occured during createNewEmployee");
                        log.error(new String(res.getBody().readAllBytes()));
                        throw new ResourceNotFoundException("could not create the employee");
                    })
                    .toEntity(new ParameterizedTypeReference<>() {
                    });

            log.trace("Successfully create a new employee : {}",employeeDTOApiResponse.getBody());
            return employeeDTOApiResponse.getBody().getData();
        }catch(Exception e){
            log.error("Exception occured in createNewEmployee",e);
            throw new RuntimeException(e);
        }
    }
}
