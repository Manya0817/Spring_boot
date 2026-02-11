package com.hospitalManagementSystem.module35.service;

import com.hospitalManagementSystem.module35.entity.Appointment;
import com.hospitalManagementSystem.module35.entity.Doctor;
import com.hospitalManagementSystem.module35.entity.Patient;
import com.hospitalManagementSystem.module35.repository.AppointmentRepository;
import com.hospitalManagementSystem.module35.repository.DoctorRepository;
import com.hospitalManagementSystem.module35.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Appointment createNewAppointment(Appointment appointment, Long patientId, Long doctorId){
        Patient patient=patientRepository.findById(patientId).orElseThrow();
        Doctor doctor=doctorRepository.findById(doctorId).orElseThrow();

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        appointmentRepository.save(appointment);
        return appointment;
    }
}
