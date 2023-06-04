package com.example.catalogservice.controller;

import com.example.catalogservice.model.DTO.MovieDTO;
import com.example.catalogservice.service.MovieEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalogs")
@CrossOrigin(origins = "*")
public class MovieController {

    @Autowired
    private MovieEndpoint movieEndpoint;

    @RequestMapping(method = RequestMethod.GET, value = "/catalog/{genre}")
    public ResponseEntity<List<MovieDTO>> getCatalog(@PathVariable String genre){
        return new ResponseEntity<>(movieEndpoint.getMoviesByGenre(genre), HttpStatus.OK);
    }
}
