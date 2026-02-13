package com.example.HomeworkModule3.Repository;

import com.example.HomeworkModule3.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}