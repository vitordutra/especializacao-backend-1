package com.example.catalogservice.util.moveEndPoint;

import com.example.catalogservice.model.DTO.MovieDTO;

public class MovieEndPointCreator {

    private static MovieDTO movieEndPoint = new MovieDTO();

    public static MovieDTO createMovieEndPoint(){
        movieEndPoint.setId(1L);
        movieEndPoint.setName("The Godfather");
        movieEndPoint.setGenre("Crime");
        movieEndPoint.setUrlStream("https://www.youtube.com/watch?v=sY1S34973zA");
        movieEndPoint.setId(2L);
        movieEndPoint.setName("The Godfather 2");
        movieEndPoint.setGenre("Crime");
        movieEndPoint.setUrlStream("https://www.youtube.com/watch?v=vWNv98w8uSg");
        return movieEndPoint;
    }
}
