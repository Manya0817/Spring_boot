package com.Maheshwari.Manya.Module2.repositories;

import com.Maheshwari.Manya.Module2.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {

}
