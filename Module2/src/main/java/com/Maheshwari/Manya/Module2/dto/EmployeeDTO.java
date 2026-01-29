package com.Maheshwari.Manya.Module2.dto;
import com.Maheshwari.Manya.Module2.annotations.EmployeeRoleValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO{

    private Long id;
    @NotBlank(message="Name of the employee can not be empty")
    @Size(min=3,max=10, message ="Number of characters in name should be in the range: [3,10]")
    private String name;
    @NotNull(message = "Email of the employee can not be blank")
    @Email(message = "Email should be a valid email")
    private String email;
    @Max(value=80, message = "Age of Employee cannot be greater than 80")
    @Min(value=18, message= "Age of Employee cannot be less than 18")
    private Integer age;
    @NotBlank(message = "Role of the employee can not be blank")
//    @Pattern(regexp="^(ADMIN|USER)$", message="Role of Employee can be either admin or user")
    @EmployeeRoleValidation
    private String role;
    @NotNull @Positive
    @Digits(integer = 6,fraction = 2,message = "the salary can be in the form xxxxxx.yy")
    @DecimalMax(value="100000")
    private Double salary;
    @PastOrPresent(message = "doj cannot be in the future")
    private LocalDate dateOfJoining;
    @AssertTrue(message ="Employee should be active" )
    @JsonProperty("isActive")
    private Boolean isActive;
}
