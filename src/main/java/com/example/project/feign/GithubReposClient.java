package com.example.project.feign;

import com.example.project.dto.GithubDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "github", url = "https://api.github.com")
public interface GithubReposClient {
    @GetMapping("repos/{owner}/{repo}")
    GithubDto getRepoDetails (@PathVariable("owner") String owner, @PathVariable("repo") String repo);
}
