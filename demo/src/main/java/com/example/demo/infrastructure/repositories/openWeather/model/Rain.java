package com.example.demo.infrastructure.repositories.openWeather.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;


@Getter
@Builder
@ToString
public class Rain {
    @JsonProperty("1h")
    private double _1h;
}
