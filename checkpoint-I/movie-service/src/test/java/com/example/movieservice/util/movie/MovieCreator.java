package com.example.movieservice.util.movie;

import com.example.movieservice.model.Movie;

public class MovieCreator {

    private static Movie movie = new Movie();

    public static Movie createMovieToBeSaved() {
        movie.setName("The Godfather");
        movie.setGenre("Crime");
        movie.setUrlStream("https://www.youtube.com/watch?v=sY1S34973zA");
        return movie;
    }

    public static Movie createValidMovie() {
        movie.setId(1L);
        movie.setName("The Godfather");
        movie.setGenre("Crime");
        movie.setUrlStream("https://www.youtube.com/watch?v=sY1S34973zA");
        return movie;
    }

    public static Movie createValidUpdateMovie() {
        movie.setId(1L);
        movie.setName("The Godfather 2");
        movie.setGenre("Crime");
        movie.setUrlStream("https://www.youtube.com/watch?v=vWNv98w8uSg");
        return movie;
    }
}
