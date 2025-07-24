package com.proof.cat.infraestructure.controller;

import com.proof.cat.aplication.service.ImageService;
import com.proof.cat.domain.model.Image;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/images")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @GetMapping("/bybreedid")
    public List<Image> getImagesByBreedId(@RequestParam("breed_id") String breedId) {
        return imageService.getImagesByBreedId(breedId);
    }
}
