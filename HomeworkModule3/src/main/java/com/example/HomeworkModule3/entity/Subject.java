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
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    // Many Subjects -> One Professor (Owning Side)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professor_id")
    @ToString.Exclude
    private Professor professor;


    // ManyToMany (Inverse Side)
    @ManyToMany(mappedBy = "subjects", fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<Student> students = new HashSet<>();
}
