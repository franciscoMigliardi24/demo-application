package com.example.demo.domain.model;

import com.example.demo.domain.exceptions.InvalidParameterException;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record Latitude(String value) {
    public Latitude {
        if (isBlank(value)) {
            throw new InvalidParameterException("Latitude is required");
        }
    }
}
