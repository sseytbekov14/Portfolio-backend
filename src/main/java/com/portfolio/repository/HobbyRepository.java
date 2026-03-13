package com.portfolio.repository;

import com.portfolio.entity.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HobbyRepository extends JpaRepository<Hobby, Long> {
    List<Hobby> findByUserId(Long userId);
}