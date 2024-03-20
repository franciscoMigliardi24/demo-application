package com.example.demo.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Forecast {

    private String date;
    private String temperature;
}
