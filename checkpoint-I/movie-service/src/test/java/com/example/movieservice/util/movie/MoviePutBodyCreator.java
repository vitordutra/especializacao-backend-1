package com.example.movieservice.util.movie;

import com.example.movieservice.model.Movie;
import com.example.movieservice.util.movie.MovieCreator;

public class MoviePutBodyCreator {

        public static Movie MoviePutBody(){
            Movie movie = new Movie();
            movie.setId(MovieCreator.createValidUpdateMovie().getId());
            movie.setName(MovieCreator.createValidUpdateMovie().getName());
            movie.setGenre(MovieCreator.createValidUpdateMovie().getGenre());
            movie.setUrlStream(MovieCreator.createValidUpdateMovie().getUrlStream());
            return movie;
        }
}
