package com.example.HomeworkModule3.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class AdmissionRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer fees;

    // Owning side (FK here)
    @OneToOne
    @JoinColumn(name = "student_id", unique = true, nullable = false)
    private Student student;
}
