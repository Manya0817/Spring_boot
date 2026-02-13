package com.example.HomeworkModule3.controller;

import com.example.HomeworkModule3.entity.AdmissionRecord;
import com.example.HomeworkModule3.entity.Professor;
import com.example.HomeworkModule3.entity.Student;
import com.example.HomeworkModule3.entity.Subject;
import com.example.HomeworkModule3.service.CollegeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/college")
public class CollegeController {
    private final CollegeService service;

    public CollegeController(CollegeService service) {
        this.service = service;
    }

    @PostMapping("/student")
    public Student createStudent(@RequestBody Student student) {
        return service.createStudent(student);
    }

    @PostMapping("/professor")
    public Professor createProfessor(@RequestBody Professor professor) {
        return service.createProfessor(professor);
    }

    @PostMapping("/subject")
    public Subject createSubject(@RequestBody Subject subject) {
        return service.createSubject(subject);
    }

    // Student <-> Professor
    @PutMapping("/assign/professor/student")
    public Student assignProfessorToStudent(
            @RequestParam Long studentId,
            @RequestParam Long professorId) {

        return service.assignProfessorToStudent(studentId, professorId);
    }

    // Student <-> Subject
    @PutMapping("/assign/subject/student")
    public Student assignSubjectToStudent(
            @RequestParam Long studentId,
            @RequestParam Long subjectId) {

        return service.assignSubjectToStudent(studentId, subjectId);
    }

    // Professor -> Subject
    @PutMapping("/assign/professor/subject")
    public Subject assignProfessorToSubject(
            @RequestParam Long subjectId,
            @RequestParam Long professorId) {

        return service.assignProfessorToSubject(subjectId, professorId);
    }

    // Student -> Admission
    @PostMapping("/admission")
    public AdmissionRecord createAdmission(
            @RequestParam Long studentId,
            @RequestParam Integer fees) {

        return service.createAdmission(studentId, fees);
    }
}
