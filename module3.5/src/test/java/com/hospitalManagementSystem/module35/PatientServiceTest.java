package com.hospitalManagementSystem.module35;

import com.hospitalManagementSystem.module35.dto.BloodGroupStats;
import com.hospitalManagementSystem.module35.dto.CPatientInfo;
import com.hospitalManagementSystem.module35.dto.IPatientInfo;
import com.hospitalManagementSystem.module35.entity.Patient;
import com.hospitalManagementSystem.module35.repository.PatientRepository;
import com.hospitalManagementSystem.module35.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientServiceTest {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void  testPatient(){
//        List<Patient> patientList=patientRepository.findAll();
//        List<CPatientInfo> patientList=patientRepository.getAllPatientsInfoConcrete();
//
//        int rowsAffected=patientRepository.updatePatientNameWithId("Manya Maheshwari",1L);
//        System.out.println(rowsAffected);

        patientService.testPatientTransaction();
    }
}
