package com.example.movieservice.controller;

import com.example.movieservice.model.Movie;
import com.example.movieservice.service.MovieService;
import com.example.movieservice.util.movie.MovieCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DisplayName("Testes para os EndPoints de Movies")
class MovieControllerTest {

    @InjectMocks
    private MovieController movieController;

    @Mock
    private MovieService movieServiceMock;

    @BeforeEach
    void setUp() {

        BDDMockito.when(movieServiceMock.save(ArgumentMatchers.any(Movie.class)))
                .thenReturn(MovieCreator.createValidMovie());

        BDDMockito.when(movieServiceMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(MovieCreator.createValidMovie());

        BDDMockito.doNothing().when(movieServiceMock).deleteById(ArgumentMatchers.anyLong());

        BDDMockito.when(movieServiceMock.update(ArgumentMatchers.any(Movie.class)))
                .thenReturn(MovieCreator.createValidMovie());

        BDDMockito.when(movieServiceMock.findByGenre(ArgumentMatchers.anyString()))
                .thenReturn(java.util.List.of(MovieCreator.createValidMovie()));

        BDDMockito.when(movieServiceMock.findAll())
                .thenReturn(java.util.List.of(MovieCreator.createValidMovie()));
    }

    @Test
    @DisplayName("Busca uma lista de todos os filmes com sucesso")
    void findAll() {

        String expectedName = MovieCreator.createValidMovie().getName();
        String expectedGenre = MovieCreator.createValidMovie().getGenre();

        ResponseEntity<List<Movie>> movieControllerAll = movieController.findAll();

        Assertions.assertThat(movieControllerAll).isNotNull();

        Assertions.assertThat(movieControllerAll.getBody().get(0).getName()).isEqualTo(expectedName);
        Assertions.assertThat(movieControllerAll.getBody().get(0).getGenre()).isEqualTo(expectedGenre);
    }

    @Test
    @DisplayName("Busca uma lista de filmes por generos com sucesso")
    void findByGenre() {

            String expectedName = MovieCreator.createValidMovie().getName();
            String expectedGenre = MovieCreator.createValidMovie().getGenre();

            ResponseEntity<List<Movie>> movieControllerByGenre = movieController.findByGenre("Ação");

            Assertions.assertThat(movieControllerByGenre).isNotNull();

            Assertions.assertThat(movieControllerByGenre.getBody().get(0).getName()).isEqualTo(expectedName);
            Assertions.assertThat(movieControllerByGenre.getBody().get(0).getGenre()).isEqualTo(expectedGenre);
    }
}