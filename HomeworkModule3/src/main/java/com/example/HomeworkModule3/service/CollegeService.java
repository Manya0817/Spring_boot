package com.example.HomeworkModule3.service;

import com.example.HomeworkModule3.Repository.AdmissionRecordRepository;
import com.example.HomeworkModule3.Repository.ProfessorRepository;
import com.example.HomeworkModule3.Repository.StudentRepository;
import com.example.HomeworkModule3.Repository.SubjectRepository;
import com.example.HomeworkModule3.entity.AdmissionRecord;
import com.example.HomeworkModule3.entity.Professor;
import com.example.HomeworkModule3.entity.Student;
import com.example.HomeworkModule3.entity.Subject;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CollegeService {
    private final StudentRepository studentRepo;
    private final ProfessorRepository professorRepo;
    private final SubjectRepository subjectRepo;
    private final AdmissionRecordRepository admissionRepo;

    public CollegeService(StudentRepository studentRepo, ProfessorRepository professorRepo, SubjectRepository subjectRepo, AdmissionRecordRepository admissionRepo) {
        this.studentRepo = studentRepo;
        this.professorRepo = professorRepo;
        this.subjectRepo = subjectRepo;
        this.admissionRepo = admissionRepo;
    }

    public Student createStudent(Student s) {
        return studentRepo.save(s);
    }

    public Professor createProfessor(Professor p) {
        return professorRepo.save(p);
    }

    public Subject createSubject(Subject s) {
        return subjectRepo.save(s);
    }

    // Assign Professor to Student (ManyToMany)
    public Student assignProfessorToStudent(Long studentId, Long professorId) {

        Student student = studentRepo.findById(studentId)
                .orElseThrow();

        Professor professor = professorRepo.findById(professorId)
                .orElseThrow();

        student.getProfessors().add(professor);

        return studentRepo.save(student);
    }

    // Assign Subject to Student (ManyToMany)
    public Student assignSubjectToStudent(Long studentId, Long subjectId) {

        Student student = studentRepo.findById(studentId)
                .orElseThrow();

        Subject subject = subjectRepo.findById(subjectId)
                .orElseThrow();

        student.getSubjects().add(subject);

        return studentRepo.save(student);
    }

    // Assign Professor to Subject (ManyToOne)
    public Subject assignProfessorToSubject(Long subjectId, Long professorId) {

        Subject subject = subjectRepo.findById(subjectId)
                .orElseThrow();

        Professor professor = professorRepo.findById(professorId)
                .orElseThrow();

        subject.setProfessor(professor);

        return subjectRepo.save(subject);
    }

    // Create Admission (OneToOne)
    public AdmissionRecord createAdmission(Long studentId, Integer fees) {

        Student student = studentRepo.findById(studentId)
                .orElseThrow();

        AdmissionRecord admission = new AdmissionRecord();
        admission.setFees(fees);
        admission.setStudent(student);

        return admissionRepo.save(admission);
    }

}
