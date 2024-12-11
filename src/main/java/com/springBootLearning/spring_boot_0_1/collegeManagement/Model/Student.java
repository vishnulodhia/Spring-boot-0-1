package com.springBootLearning.spring_boot_0_1.collegeManagement.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "student")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id", nullable = false)
    private long studentId;

    @Column(name = "student_name", nullable = false, length = 60)
    private String name;

    @ManyToMany(mappedBy = "professorStudent")
    private List<Professor> professors;

    @ManyToMany(mappedBy = "subjectStudents")
    private  List<Subject> subject;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "admissionRecord_id")
    private AdmissionRecord admissionRecord;

}
