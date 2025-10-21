package com.example.project.controller;

import com.example.project.dto.GithubResponseDto;
import com.example.project.service.GithubService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/repositories")
public class GithubController {
    private final GithubService githubService;

    @GetMapping("/{owner}/{repo}")
    public GithubResponseDto get(@PathVariable String owner, @PathVariable String repo) {
        return githubService.fetchRepositoryDetails(owner, repo);
    }

    @PostMapping("/{owner}/{repo}")
    @ResponseStatus(HttpStatus.CREATED)
    public GithubResponseDto add(@PathVariable String owner, @PathVariable String repo) {
        return githubService.add(owner, repo);
    }

    @GetMapping("/local/{owner}/{repo}")
    public GithubResponseDto find(@PathVariable String owner, @PathVariable String repo) {
        return githubService.find(owner, repo);
    }

    @PutMapping("/{owner}/{repo}")
    public GithubResponseDto update(@PathVariable String owner, @PathVariable String repo) {
        return githubService.update(owner, repo);
    }

    @DeleteMapping("/{owner}/{repo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String owner, @PathVariable String repo) {
        githubService.delete(owner, repo);
    }
}
