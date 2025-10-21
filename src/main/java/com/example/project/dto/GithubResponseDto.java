package com.example.project.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
public record GithubResponseDto(String fullName, String description, String cloneUrl, int stars, LocalDateTime createdAt) {
}
