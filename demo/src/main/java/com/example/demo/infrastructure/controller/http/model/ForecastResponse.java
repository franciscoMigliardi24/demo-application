package com.example.demo.infrastructure.controller.http.model;

import com.example.demo.domain.model.Forecast;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@Builder
@ToString
public class ForecastResponse {
    private List<Forecast> forecastList;
}
