package com.springBootLearning.spring_boot_0_1.Repository;

import com.springBootLearning.spring_boot_0_1.Model.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity,Long> {
}
