package com.example.project.mapper;

import com.example.project.dto.GithubResponseDto;
import com.example.project.model.GithubRepositoryEntity;
import com.example.project.model.GithubResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GithubResponseMapper {
    GithubResponseDto responseToDto(GithubResponse githubResponse);
    GithubRepositoryEntity toEntity(GithubResponse githubResponse);
    GithubResponseDto toDto(GithubRepositoryEntity githubRepositoryEntity);
}
