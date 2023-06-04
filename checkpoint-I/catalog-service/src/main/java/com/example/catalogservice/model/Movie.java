package com.example.catalogservice.model;

import lombok.Data;

@Data
public class Movie {
    private Long id;
    private String name;
    private String genre;
    private String urlStream;

}
