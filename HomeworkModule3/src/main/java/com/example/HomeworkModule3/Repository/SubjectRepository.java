package com.example.HomeworkModule3.Repository;

import com.example.HomeworkModule3.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}