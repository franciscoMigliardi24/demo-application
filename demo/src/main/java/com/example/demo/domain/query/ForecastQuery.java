package com.example.demo.domain.query;

import com.example.demo.domain.model.Latitude;
import com.example.demo.domain.model.Longitude;
import lombok.Getter;

@Getter
public class ForecastQuery {
    private Latitude latitude;
    private Longitude longitude;

    public ForecastQuery(Latitude latitude, Longitude longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public static ForecastQuery from(final String latitude, final String longitude) {
        return new ForecastQuery(new Latitude(latitude), new Longitude(longitude));
    }
}
