package com.example.project.exception;

import org.springframework.http.HttpStatus;

public class RepositoryAlreadyAddedException extends GithubProxyException {
    public RepositoryAlreadyAddedException() {
        super("The repository has been already added to the database", HttpStatus.CONFLICT);
    }
}
