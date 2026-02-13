package com.example.HomeworkModule3.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    // One Professor -> Many Subjects
    @OneToMany(mappedBy = "professor", fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<Subject> subjects = new HashSet<>();


    // ManyToMany (Inverse side)
    @ManyToMany(mappedBy = "professors", fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<Student> students = new HashSet<>();
}
