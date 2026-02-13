package com.example.HomeworkModule3.Repository;

import com.example.HomeworkModule3.entity.AdmissionRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdmissionRecordRepository extends JpaRepository<AdmissionRecord, Long> {
}