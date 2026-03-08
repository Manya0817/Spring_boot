package com.module5.springSecurity.project1.repositories;

import com.module5.springSecurity.project1.entities.SessionEntity;
import com.module5.springSecurity.project1.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SessionRepository extends JpaRepository<SessionEntity,Long> {
    Optional<SessionEntity> findByToken(String token);
    Optional<SessionEntity> findByUser(User user);
    void deleteByUser(User user);
}
