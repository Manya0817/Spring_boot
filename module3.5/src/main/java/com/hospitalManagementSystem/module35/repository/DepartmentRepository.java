package com.hospitalManagementSystem.module35.repository;

import com.hospitalManagementSystem.module35.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}