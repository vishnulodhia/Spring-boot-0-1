package com.springBootLearning.spring_boot_0_1.Repository;

import com.springBootLearning.spring_boot_0_1.Model.Session;
import com.springBootLearning.spring_boot_0_1.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SessionRepository extends JpaRepository<Session,Long> {

    List<Session> findByUser(User user);

    Optional<Session> findByRefreshToken(String refreshToken);

    void deleteByUser(User user);
}
