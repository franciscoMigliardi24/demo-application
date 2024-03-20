package com.example.demo.infrastructure.repositories.openWeather.error;

public class RestClientError extends RuntimeException{
    public RestClientError(String message) {
        super(message);
    }
}
