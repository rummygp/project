package com.example.project.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends GithubProxyException{
    public NotFoundException() {
        super("Requested repository could not be found.", HttpStatus.NOT_FOUND);
    }
}
