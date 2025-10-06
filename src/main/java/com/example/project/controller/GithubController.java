package com.example.project.controller;

import com.example.project.dto.GithubResponseDto;
import com.example.project.service.GithubService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/repositories")
public class GithubController {
    private final GithubService githubService;

    @GetMapping("/{owner}/{repo}")
    public GithubResponseDto get(@PathVariable String owner, @PathVariable String repo) {
        return githubService.fetchRepositoryDetails(owner, repo);
    }
}
