package com.hospitalManagementSystem.module35.repository;
import com.hospitalManagementSystem.module35.dto.BloodGroupStats;
import com.hospitalManagementSystem.module35.dto.CPatientInfo;
import com.hospitalManagementSystem.module35.dto.IPatientInfo;
import com.hospitalManagementSystem.module35.entity.Patient;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.security.cert.CertPath;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("SELECT p.id AS id, p.name AS name, p.email AS email FROM Patient p")
    List<IPatientInfo> getAllPatientsInfo();

    @Query("SELECT new com.hospitalManagementSystem.module35.dto.CPatientInfo(p.id, p.name) "+ "FROM Patient p")
    List<CPatientInfo> getAllPatientsInfoConcrete();

    @Query("SELECT new com.hospitalManagementSystem.module35.dto.BloodGroupStats(p.bloodGroup, COUNT(p)) from Patient p group by p.bloodGroup order by COUNT(p) DESC")
    List<BloodGroupStats> getBloodGroupStat();

    @Transactional
    @Modifying
    @Query("UPDATE Patient p set p.name=:name where p.id=:id")
    int updatePatientNameWithId(@Param("name") String name,@Param("id") Long id);
}