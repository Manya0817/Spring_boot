package com.hospitalManagementSystem.module35.service;

import com.hospitalManagementSystem.module35.entity.Insurance;
import com.hospitalManagementSystem.module35.entity.Patient;
import com.hospitalManagementSystem.module35.repository.InsuranceRepository;
import com.hospitalManagementSystem.module35.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Insurance assignInsuranceToPatient(Insurance insurance,Long patientId){
        Patient patient=patientRepository.findById(patientId).orElseThrow();
        patient.setInsurance(insurance);
        insurance.setPatient(patient); //optional ->this is done to maintain bi-directional dependency
        return insurance;
    }

    @Transactional
    public Insurance updateInsuranceOfAPatient(Insurance insurance,Long patientId){
        Patient patient=patientRepository.findById(patientId).orElseThrow();
        patient.setInsurance(insurance);
        insurance.setPatient(patient); //optional ->this is done to maintain bi-directional dependency
        return insurance;
    }

    //works if we set orphan remove true
    @Transactional
    public Patient removeInsuranceOfAPatient(Long patientId){
        Patient patient=patientRepository.findById(patientId).orElseThrow();
        patient.setInsurance(null);
        //optional ->this is done to maintain bi-directional dependency
        return patient;
    }


}
