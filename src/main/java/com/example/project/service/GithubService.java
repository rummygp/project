package com.example.project.service;

import com.example.project.dto.GithubDto;
import com.example.project.feign.GithubReposClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GithubService {
    private final GithubReposClient githubReposClient;

    public GithubDto fetchRepoDetails(String owner, String repo) {
        return githubReposClient.getRepoDetails(owner, repo);
    }
}
