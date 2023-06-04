package com.example.movieservice.util.movie;

import com.example.movieservice.model.Movie;
import com.example.movieservice.util.movie.MovieCreator;

public class MoviePostBodyCreator {

        public static Movie MoviePostBody(){
            Movie movie = new Movie();
            movie.setName(MovieCreator.createMovieToBeSaved().getName());
            movie.setGenre(MovieCreator.createMovieToBeSaved().getGenre());
            movie.setUrlStream(MovieCreator.createMovieToBeSaved().getUrlStream());
            return movie;
        }
}
