package com.springBootLearning.spring_boot_0_1.collegeManagement.Model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "professor")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "professor_id", nullable = false)
    private long professorId;

    @Column(name = "professor_name", nullable = false, length = 60)
    private String name;


    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "professor_student_mapping" ,joinColumns = @JoinColumn(name="professor_id"),inverseJoinColumns = @JoinColumn(name="student_id"))
    private List<Student> professorStudent;

    @OneToMany(mappedBy = "professor",cascade = CascadeType.ALL,orphanRemoval = true)
    List<Subject> subjects;

}
