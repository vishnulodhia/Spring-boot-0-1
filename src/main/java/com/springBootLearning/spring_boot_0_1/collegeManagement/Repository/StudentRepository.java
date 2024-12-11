package com.springBootLearning.spring_boot_0_1.collegeManagement.Repository;

import com.springBootLearning.spring_boot_0_1.collegeManagement.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
