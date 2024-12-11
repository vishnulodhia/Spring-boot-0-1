package com.springBootLearning.spring_boot_0_1.collegeManagement.Repository;

import com.springBootLearning.spring_boot_0_1.collegeManagement.Model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor,Long> {
}
