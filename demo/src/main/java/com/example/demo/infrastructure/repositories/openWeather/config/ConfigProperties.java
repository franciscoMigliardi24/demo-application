package com.example.demo.infrastructure.repositories.openWeather.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigProperties {
    @Value("${open.weather.apiKey}")
    public String apiKey;
    @Value("${open.weather.latitude}")
    public String latitude;
    @Value("${open.weather.longitude}")
    public String longitude;
}
