package com.project.department.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.department.annotations.PasswordStringValidation;
import com.project.department.annotations.PrimeNumberValidation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {

    @NotNull(message = "Password is required")
    @PasswordStringValidation
    private String password;
    private Long id;
    @PrimeNumberValidation
    private Integer salary;
    @NotBlank(message="Department title cannot be NULL")
    @Size(min=5,max=20, message="Department title name should be minimum of length 5 and at max of length 20")
    private String title;
    @JsonProperty("isActive")
    private Boolean isActive;
    @PastOrPresent(message="Date of creation cannot be in future")
    private LocalDate createdAt;
}
