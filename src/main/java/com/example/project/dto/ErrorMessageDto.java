package com.example.project.dto;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record ErrorMessageDto(LocalDate createdAt, String message, int status, String error) {
}
