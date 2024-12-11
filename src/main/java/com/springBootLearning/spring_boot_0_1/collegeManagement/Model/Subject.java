package com.springBootLearning.spring_boot_0_1.collegeManagement.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "subject")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id", nullable = false)
    private long subjectId;

    @Column(name = "subject_name", nullable = false, length = 60)
    private String name;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "subject_student_mapping",joinColumns = @JoinColumn(name="subject_id"),inverseJoinColumns = @JoinColumn(name="student_id"))
    private List<Student> subjectStudents;

}
