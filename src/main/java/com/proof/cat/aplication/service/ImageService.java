package com.proof.cat.aplication.service;

import com.proof.cat.domain.model.Image;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final RestTemplate restTemplate;
    private static final String BASE_URL = "https://api.thecatapi.com/v1";

    public List<Image> getImagesByBreedId(String breedId) {
        ResponseEntity<Image[]> response = restTemplate.getForEntity(
            BASE_URL + "/images/search?breed_ids=" + breedId, Image[].class);
        return Arrays.asList(response.getBody());
    }
}

