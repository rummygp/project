package com.example.project.feign;

import com.example.project.model.GithubResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "github", url = "https://api.github.com")
public interface GithubClient {
    @GetMapping("repos/{owner}/{repo}")
    GithubResponse getRepositoryDetails (@PathVariable("owner") String owner, @PathVariable("repo") String repo);
}
