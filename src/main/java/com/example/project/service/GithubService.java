package com.example.project.service;

import com.example.project.dto.GithubResponseDto;
import com.example.project.feign.GithubClient;
import com.example.project.mapper.GithubResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GithubService {
    private final GithubClient githubClient;
    private final GithubResponseMapper githubResponseMapper;

    public GithubResponseDto fetchRepositoryDetails(String owner, String repo) {
        return githubResponseMapper.toDto(githubClient.getRepositoryDetails(owner, repo));
    }
}
