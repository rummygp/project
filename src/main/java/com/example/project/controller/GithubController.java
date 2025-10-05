package com.example.project.controller;

import com.example.project.dto.GithubDto;
import com.example.project.service.GithubService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/github")
public class GithubController {
    private final GithubService githubService;

    @GetMapping("/{owner}/{repo}")
    public GithubDto get(@PathVariable String owner, @PathVariable String repo) {
        return githubService.fetchRepoDetails(owner, repo);
    }
}
