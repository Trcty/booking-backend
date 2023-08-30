package com.example.staybooking.config;

import com.google.maps.GeoApiContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
@Configuration
public class GoogleGeoCodingConfig {



    @Bean
    public GeoApiContext geoApiContext(
            @Value("${geocoding.apikey}")
            String apiKey
    ) {
        return new GeoApiContext.Builder().apiKey(apiKey).build();
    }
}
