package com.example.project.service;

import com.example.project.dto.GithubResponseDto;
import com.example.project.client.GithubClient;
import com.example.project.exception.NotFoundException;
import com.example.project.exception.RepositoryAlreadyAddedException;
import com.example.project.mapper.GithubResponseMapper;

import com.example.project.model.GithubRepositoryEntity;
import com.example.project.repository.GithubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class GithubService {
    private final GithubClient githubClient;
    private final GithubResponseMapper githubResponseMapper;
    private final GithubRepository githubRepository;

    public GithubResponseDto fetchRepositoryDetails(String owner, String repo) {
        return githubResponseMapper.responseToDto(githubClient.getRepositoryDetails(owner, repo));
    }

    public GithubResponseDto add(String owner, String repo) {
        String fullName = owner + "/" + repo;
        if (githubRepository.findByFullName(fullName).isPresent()) {
            throw new RepositoryAlreadyAddedException();
        }
        return githubResponseMapper.toDto(githubRepository.save(githubResponseMapper.toEntity(githubClient.getRepositoryDetails(owner, repo))));
    }

    public GithubResponseDto find(String owner, String repo) {
        String fullName = owner + "/" + repo;
        GithubRepositoryEntity githubRepositoryEntity = githubRepository.findByFullName(fullName)
                .orElseThrow(NotFoundException::new);
        return githubResponseMapper.toDto(githubRepositoryEntity);
    }

    public GithubResponseDto update(String owner, String repo) {
        String fullName = owner + "/" + repo;
        GithubRepositoryEntity githubRepositoryEntity = githubRepository.findByFullName(fullName)
                .orElseThrow(NotFoundException::new);
        GithubRepositoryEntity newData = githubResponseMapper.toEntity(githubClient.getRepositoryDetails(owner, repo));
        githubRepositoryEntity.update(newData);
        return githubResponseMapper.toDto(githubRepository.save(githubRepositoryEntity));
    }

    public void delete(String owner, String repo) {
        String fullName = owner + "/" + repo;
        GithubRepositoryEntity githubRepositoryEntity = githubRepository.findByFullName(fullName)
                .orElseThrow(NotFoundException::new);
        githubRepository.delete(githubRepositoryEntity);
    }
}
