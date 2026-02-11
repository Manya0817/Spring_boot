package com.hospitalManagementSystem.module35.service;

import com.hospitalManagementSystem.module35.entity.Patient;
import com.hospitalManagementSystem.module35.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class PatientService {
    private final PatientRepository patientRepository;
    public void testPatientTransaction(){
        Patient p1=patientRepository.findById(1L).orElseThrow();
        Patient p2=patientRepository.findById(1L).orElseThrow();
        System.out.println(p1+" "+p2);
        System.out.println(p1==p2);
        p1.setName("Random Name");
    }

}
