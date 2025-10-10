package com.example.project.repository;

import com.example.project.model.GithubRepositoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GithubRepository extends JpaRepository<GithubRepositoryEntity, Long> {

    Optional<GithubRepositoryEntity> findByFullName(String fullName);
}
