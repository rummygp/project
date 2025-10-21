package com.example.project.service;

import com.example.project.client.GithubClient;
import com.example.project.dto.GithubResponseDto;
import com.example.project.mapper.GithubResponseMapper;
import com.example.project.model.GithubResponse;
import com.example.project.repository.GithubRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.Mockito;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class GithubServiceTest {
    private GithubClient githubClient;
    private GithubResponseMapper githubResponseMapper;
    private GithubService githubService;
    private GithubRepository githubRepository;

    @BeforeEach
    void setUp() {
        this.githubClient = Mockito.mock(GithubClient.class);
        this.githubResponseMapper = Mappers.getMapper(GithubResponseMapper.class);
        this.githubService = new GithubService(githubClient, githubResponseMapper, githubRepository);
    }

    @Test
    void fetchRepositoryDetails_DataCorrect_GithubResponseDtoReturned() {
        //given
        String owner = "owner";
        String repository = "repository-name";
        GithubResponse response = GithubResponse.builder()
                .fullName("owner/repository-name")
                .description("repositoryDescription")
                .cloneUrl("https://github.com/owner/repository-name.git")
                .stars(100)
                .createdAt(LocalDateTime.of(2025, 9, 9, 12, 0))
                .build();
        when(githubClient.getRepositoryDetails(owner, repository)).thenReturn(response);
        //when
        GithubResponseDto result = githubService.fetchRepositoryDetails(owner, repository);
        //then
        Assertions.assertAll(
                () -> assertEquals("owner/repository-name", result.fullName()),
                () -> assertEquals("repositoryDescription", result.description()),
                () -> assertEquals("https://github.com/owner/repository-name.git", result.cloneUrl()),
                () -> assertEquals(100, result.stars()),
                () -> assertEquals(LocalDateTime.of(2025, 9, 9, 12, 0), result.createdAt())
        );
    }
}
