package com.example.movieservice.service;

import com.example.movieservice.model.Movie;
import com.example.movieservice.repository.MovieRepository;
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
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@DisplayName("Testes para o serviço de filmes")
class MovieServiceTest {

    @InjectMocks
    private MovieService movieService;

    @Mock
    private MovieRepository movieRepositoryMock;

    @BeforeEach
    void setUp() {
        BDDMockito.when(movieRepositoryMock.save(ArgumentMatchers.any(Movie.class)))
                .thenReturn(MovieCreator.createValidMovie());

        BDDMockito.when(movieRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(MovieCreator.createValidMovie()));

        BDDMockito.doNothing().when(movieRepositoryMock).deleteById(ArgumentMatchers.anyLong());

        BDDMockito.when(movieRepositoryMock.findByGenre(ArgumentMatchers.anyString()))
                .thenReturn(List.of(MovieCreator.createValidMovie()));

        BDDMockito.when(movieRepositoryMock.findAll())
                .thenReturn(List.of(MovieCreator.createValidMovie()));
    }

    @Test
    @DisplayName("Salva um filme com sucesso")
    void save() {
        Movie movie = movieService.save(MovieCreator.createMovieToBeSaved());

        Assertions.assertThat(movie).isNotNull();

        Assertions.assertThat(movie.getId())
                .isNotNull()
                .isEqualTo(MovieCreator.createValidMovie().getId());

        Assertions.assertThat(movie.getName())
                .isNotNull()
                .isEqualTo(MovieCreator.createValidMovie().getName());

        Assertions.assertThat(movie.getGenre())
                .isNotNull()
                .isEqualTo(MovieCreator.createValidMovie().getGenre());

        Assertions.assertThat(movie.getUrlStream())
                .isNotNull()
                .isEqualTo(MovieCreator.createValidMovie().getUrlStream());
    }

    @Test
    @DisplayName("Retorna um filme por id com sucesso")
    void findById() {

        Long expectedId = MovieCreator.createValidMovie().getId();
        Movie movie = movieService.findById(1L);

        Assertions.assertThat(movie).isNotNull();

        Assertions.assertThat(movie.getId())
                .isNotNull()
                .isEqualTo(expectedId);

        Assertions.assertThat(movie.getName())
                .isNotNull()
                .isEqualTo(MovieCreator.createValidMovie().getName());

        Assertions.assertThat(movie.getGenre())
                .isNotNull()
                .isEqualTo(MovieCreator.createValidMovie().getGenre());

        Assertions.assertThat(movie.getUrlStream())
                .isNotNull()
                .isEqualTo(MovieCreator.createValidMovie().getUrlStream());
    }

    @Test
    @DisplayName("Deleta um filme com sucesso")
    void deleteById() {
        org.junit.jupiter.api.Assertions.assertDoesNotThrow(() -> movieService.deleteById(1L));
    }

    @Test
    @DisplayName("Atualiza um filme com sucesso")
    void update() {
        org.junit.jupiter.api.Assertions.assertDoesNotThrow(() -> movieService.update(MovieCreator.createValidMovie()));
    }

    @Test
    @DisplayName("Retorna uma lista de filmes por generos com sucesso")
    void findByGenre() {
        String expectedGenre = MovieCreator.createValidMovie().getGenre();
        List<Movie> movies = movieService.findByGenre("Ação");

        Assertions.assertThat(movies)
                .hasSize(1)
                .isNotEmpty()
                .isNotNull();

        Assertions.assertThat(movies.get(0).getGenre())
                .isEqualTo(expectedGenre);
    }

    @Test
    @DisplayName("Retorna uma lista de filmes com sucesso")
    void findAll() {
        List<Movie> movies = movieService.findAll();

        Assertions.assertThat(movies)
                .hasSize(1)
                .isNotEmpty()
                .isNotNull();
    }
}