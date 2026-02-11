package com.hospitalManagementSystem.module35;

import com.hospitalManagementSystem.module35.entity.Appointment;
import com.hospitalManagementSystem.module35.entity.Insurance;
import com.hospitalManagementSystem.module35.service.AppointmentService;
import com.hospitalManagementSystem.module35.service.InsuranceService;
import com.hospitalManagementSystem.module35.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTests {

    @Autowired
    private PatientService patientService;

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void  testAssignInsuranceToPatient(){
        Insurance insurance=Insurance.builder()
                .provider("HDFC Ergo")
                .policyNumber("HDFC_236")
                .validUntil(LocalDate.of(2030,1,1))
                .build();

        var updatedInsurance=insuranceService.assignInsuranceToPatient(insurance,1L);
        System.out.println(updatedInsurance);

        patientService.deletePatient(1L);
    }

    @Test
    public void testCreateAppointment(){
        Appointment appointment=Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025,11,1,14,0,6))
                .reason("Cancer")
                .build();

        var updatedAppointment=appointmentService.createNewAppointment(appointment,1L,2L);
        System.out.println(updatedAppointment);
        patientService.deletePatient(1L);
    }
}
