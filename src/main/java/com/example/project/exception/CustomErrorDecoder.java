package com.example.project.exception;

import feign.FeignException;
import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;

public class CustomErrorDecoder implements ErrorDecoder {
    private final ErrorDecoder defaultErrorDecoder = new ErrorDecoder.Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        return switch (response.status()) {
            case 404 -> {
                FeignException exception = feign.FeignException.errorStatus(methodKey, response);
                yield new RetryableException (
                        response.status(),
                        "Repository could not be found on github",
                        response.request().httpMethod(),
                        exception,
                        50L,
                        response.request()
                );
        }
            case 500 -> new GithubProxyException("Github unexpected error", HttpStatus.INTERNAL_SERVER_ERROR);
            default -> defaultErrorDecoder.decode(methodKey, response);
        };
    }
}
