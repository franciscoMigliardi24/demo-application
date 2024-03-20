package com.example.demo.infrastructure.controller.http;

import com.example.demo.domain.query.ForecastQuery;
import com.example.demo.domain.WeatherService;
import com.example.demo.infrastructure.controller.http.model.ForecastResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/demo-fran", produces = APPLICATION_JSON_VALUE)
public class WeatherController {

    private WeatherService service;

    @GetMapping(value = "/forecast")
    public ResponseEntity<ForecastResponse> getForecast() {

        return ResponseEntity.ok()
                .body(ForecastResponse.builder()
                        .forecastList(service.getForecast())
                        .build());
    }
}
