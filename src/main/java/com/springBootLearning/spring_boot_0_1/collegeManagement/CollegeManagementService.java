package com.springBootLearning.spring_boot_0_1.collegeManagement;

import com.springBootLearning.spring_boot_0_1.collegeManagement.Repository.ProfessorRepository;
import com.springBootLearning.spring_boot_0_1.collegeManagement.Repository.StudentRepository;
import com.springBootLearning.spring_boot_0_1.collegeManagement.Repository.SubjectRepository;
import com.springBootLearning.spring_boot_0_1.collegeManagement.Model.AdmissionRecord;
import com.springBootLearning.spring_boot_0_1.collegeManagement.Model.Professor;
import com.springBootLearning.spring_boot_0_1.collegeManagement.Model.Student;
import com.springBootLearning.spring_boot_0_1.collegeManagement.Model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;



@Service
public class CollegeManagementService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private ProfessorRepository professorRepository;


    public Student createStudent(Student student) {
        AdmissionRecord admissionRecord = AdmissionRecord.builder().fees(50000).student(student).build();
        student.setAdmissionRecord(admissionRecord);
        return studentRepository.save(student);
    }

    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public Professor createProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    public Professor assignStudentToprofessor(Long professorId, Long studentId) {
        Optional<Professor> professor = professorRepository.findById(professorId);
        Optional<Student> student = studentRepository.findById(studentId);

        return professor.flatMap(prof ->
                student.map(stu -> {
                    prof.getProfessorStudent().add(stu);
                    professorRepository.save(prof);
                    return prof;
                })).orElse(null);
    }

    public Professor assignSubjectToProfessor(Long professorId, Long subjectId) {
        Optional<Professor> professor = professorRepository.findById(professorId);
        Optional<Subject> subject = subjectRepository.findById(subjectId);

        return professor.flatMap(prof ->
                subject.map(sub -> {
                    sub.setProfessor(professor.get());
                    subjectRepository.save(sub);
                    prof.getSubjects().add(sub);
                    return prof;
                })).orElse(null);
    }

}
