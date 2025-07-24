package com.proof.cat.aplication.service;

import com.proof.cat.domain.model.Cat;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CatService {

    private final RestTemplate restTemplate;
    private static final String BASE_URL = "https://api.thecatapi.com/v1";

    public List<Cat> getBreeds() {
        ResponseEntity<Cat[]> response = restTemplate.getForEntity(BASE_URL + "/breeds", Cat[].class);
        return Arrays.asList(response.getBody());
    }

    public Cat getBreedById(String breedId) {
        // No existe endpoint directo por ID, así que se puede buscar en la lista
        return getBreeds().stream()
                .filter(b -> b.getId().equalsIgnoreCase(breedId))
                .findFirst()
                .orElse(null);
    }

    public List<Cat> searchBreeds(String query) {
        ResponseEntity<Cat[]> response = restTemplate.getForEntity(BASE_URL + "/breeds/search?q=" + query, Cat[].class);
        return Arrays.asList(response.getBody());
    }
}
