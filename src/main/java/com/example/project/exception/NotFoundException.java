package com.example.project.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends GithubProxyException{
    public NotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
