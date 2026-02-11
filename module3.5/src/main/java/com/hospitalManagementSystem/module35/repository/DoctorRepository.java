package com.hospitalManagementSystem.module35.repository;

import com.hospitalManagementSystem.module35.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}