package com.example.project.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.*;

import java.time.LocalDateTime;

@Builder
public record GithubDto(@JsonAlias("full_name") String fullName,
                        String description,
                        @JsonAlias("clone_url") String cloneUrl,
                        @JsonAlias("stargazers_count") int stars,
                        @JsonAlias("created_at") LocalDateTime createdAt) {
}
