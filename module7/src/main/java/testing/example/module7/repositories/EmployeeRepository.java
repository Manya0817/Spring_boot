package testing.example.module7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import testing.example.module7.entities.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByEmail(String email);
}
