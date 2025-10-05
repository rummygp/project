package com.example.project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Builder
public record GithubDto(@JsonProperty("full_name") String fullName,
                        String description,
                        @JsonProperty("clone_url") String cloneUrl,
                        @JsonProperty("stargazers_count") int stars,
                        @JsonProperty("created_at") LocalDateTime createdAt) {
}
