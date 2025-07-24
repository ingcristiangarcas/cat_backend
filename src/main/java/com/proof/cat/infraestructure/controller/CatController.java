package com.proof.cat.infraestructure.controller;

import com.proof.cat.aplication.service.CatService;
import com.proof.cat.domain.model.Cat;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/breeds")
@RequiredArgsConstructor
public class CatController {

    private final CatService catService;

    @GetMapping
    public List<Cat> getBreeds() {
        return catService.getBreeds();
    }

    @GetMapping("/{breed_id}")
    public Cat getBreedById(@PathVariable("breed_id") String breedId) {
        return catService.getBreedById(breedId);
    }

    @GetMapping("/search")
    public List<Cat> searchBreeds(@RequestParam("q") String query) {
        return catService.searchBreeds(query);
    }
}
