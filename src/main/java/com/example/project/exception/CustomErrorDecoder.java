package com.example.project.exception;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;

public class CustomErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        return switch (response.status()) {
            case 404 -> new NotFoundException("Resource not found");
            case 500 -> new GithubProxyException("Github unexpected error", HttpStatus.INTERNAL_SERVER_ERROR);
            default -> new Exception("Unexpected error");
        };
    }
}
