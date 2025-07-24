package com.proof.cat.infraestructure.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CatApiProperties {

    @Value("${cat.api.base-url}")
    private String baseUrl;

    @Value("${cat.api.key}")
    private String apiKey;

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getApiKey() {
        return apiKey;
    }
}
