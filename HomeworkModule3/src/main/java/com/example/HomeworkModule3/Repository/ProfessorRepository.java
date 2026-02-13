package com.example.HomeworkModule3.Repository;

import com.example.HomeworkModule3.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor,Long> {
}
