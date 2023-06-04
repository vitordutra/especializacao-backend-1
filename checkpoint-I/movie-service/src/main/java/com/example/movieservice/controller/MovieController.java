package com.example.movieservice.controller;

import com.example.movieservice.model.Movie;
import com.example.movieservice.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/movies")
@CrossOrigin(origins = "*")
public class MovieController {
    private static Logger log = Logger.getLogger(MovieController.class.getName());

    @Autowired
    private MovieService movieService;

    @RequestMapping(method = RequestMethod.GET, path = "/movie")
    public ResponseEntity<List<Movie>> findAll() {
        return ResponseEntity.ok(movieService.findAll());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/movie/{genre}")
    public ResponseEntity<List<Movie>> findByGenre(@PathVariable String genre) {
        return new ResponseEntity<>(movieService.findByGenre(genre), HttpStatus.OK);
    }
}
