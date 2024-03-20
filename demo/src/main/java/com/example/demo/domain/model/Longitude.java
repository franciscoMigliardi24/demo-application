package com.example.demo.domain.model;

import com.example.demo.domain.exceptions.InvalidParameterException;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record Longitude(String value) {
    public Longitude {
        if (isBlank(value)) {
            throw new InvalidParameterException("Longitude is required");
        }
    }
}
