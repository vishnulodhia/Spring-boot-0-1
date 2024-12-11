package com.springBootLearning.spring_boot_0_1.collegeManagement.Model;


import com.springBootLearning.spring_boot_0_1.collegeManagement.Model.Student;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "admission_record")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class AdmissionRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admission_id", nullable = false)
    private long admissionId;

    @Column(name = "fees", nullable = false)
    private int fees;

    @OneToOne(mappedBy = "admissionRecord")
    @JoinColumn(name = "student_id")
    private Student student;
}
