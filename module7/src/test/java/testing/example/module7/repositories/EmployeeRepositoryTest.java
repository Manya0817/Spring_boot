package testing.example.module7.repositories;
import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import testing.example.module7.TestContainerConfiguration;
import testing.example.module7.dto.EmployeeDto;
import testing.example.module7.entities.Employee;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
@Import(TestContainerConfiguration.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    private Employee employee;

    @BeforeEach
    void setUp(){
        employee=Employee.builder()
                .name("Khushi")
                .email("maheshwarikhushi7@gmail.com")
                .salary(100L)
                .build();
    }

    @Test
    void testFindByEmail_whenEmailIsPresent_thenReturnEmployee() {
       //arrange , Given
        employeeRepository.save(employee);
        //act, when
        List<Employee> employeeList=employeeRepository.findByEmail(employee.getEmail());
        //assert , then
        assertThat(employeeList).isNotNull();
        assertThat(employeeList).isNotEmpty();
        assertThat(employeeList.get(0).getEmail()).isEqualTo(employee.getEmail());
    }

    @Test
    void testFindByEmail_whenEmailIsNotFound_thenReturnEmptyEmployeeList(){
        //given
        String email="notPresent. tanvi@gmail.com";
        //when
        List<Employee>employeeList=employeeRepository.findByEmail(email);
        //then
        assertThat(employeeList).isNotNull();
        assertThat(employeeList).isEmpty();

    }
}