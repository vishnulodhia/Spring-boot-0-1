package com.springBootLearning.spring_boot_0_1.collegeManagement.Repository;

import com.springBootLearning.spring_boot_0_1.collegeManagement.Model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject,Long> {
}
