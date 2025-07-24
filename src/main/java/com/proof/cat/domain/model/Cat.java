package com.proof.cat.domain.model;


import lombok.Data;

@Data
public class Cat {
    private String id;
    private String name;
    private String temperament;
    private String origin;
    private String description;
}
