package com.hospitalManagementSystem.module35.repository;

import com.hospitalManagementSystem.module35.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}