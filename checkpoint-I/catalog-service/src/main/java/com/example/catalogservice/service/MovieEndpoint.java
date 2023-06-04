package com.example.catalogservice.service;

import com.example.catalogservice.model.Movie;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "MOVIE-SERVICE")
@LoadBalancerClient(name = "MOVIE-SERVICE")
public interface MovieEndpoint {

    @RequestMapping(method = RequestMethod.GET, value = "/movies/movie/{genre}")
    List<Movie> getMoviesByGenre(@PathVariable String genre);
}
