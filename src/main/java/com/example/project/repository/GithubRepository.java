package com.example.project.repository;

import com.example.project.model.GithubRepositoryEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface GithubRepository extends MongoRepository<GithubRepositoryEntity, UUID> {

    Optional<GithubRepositoryEntity> findByFullName(String fullName);
}
