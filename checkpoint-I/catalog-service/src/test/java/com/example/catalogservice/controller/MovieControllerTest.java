package com.example.catalogservice.controller;

import com.example.catalogservice.model.DTO.MovieDTO;
import com.example.catalogservice.service.MovieEndpoint;
import com.example.catalogservice.util.moveEndPoint.MovieEndPointCreator;
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
    private MovieEndpoint movieEndpoint;

    @BeforeEach
    void setUp() {

        BDDMockito.when(movieEndpoint.getMoviesByGenre(ArgumentMatchers.anyString()))
                .thenReturn(List.of(MovieEndPointCreator.createMovieEndPoint()));
    }

    @Test
    @DisplayName("Busca uma lista de filmes por generos com sucesso")
    void getCatalog() {

        Long expectedId = MovieEndPointCreator.createMovieEndPoint().getId();
        String expectedName = MovieEndPointCreator.createMovieEndPoint().getName();
        String expectedGenre = MovieEndPointCreator.createMovieEndPoint().getGenre();
        String expectedUrl = MovieEndPointCreator.createMovieEndPoint().getUrlStream();

        ResponseEntity<List<MovieDTO>> movieControllerAll = movieController.getCatalog("Crime");

        Assertions.assertThat(movieControllerAll).isNotNull();
        Assertions.assertThat(movieControllerAll.getBody()).isNotNull();
        Assertions.assertThat(movieControllerAll.getBody().get(0).getId()).isEqualTo(expectedId);
        Assertions.assertThat(movieControllerAll.getBody().get(0).getName()).isEqualTo(expectedName);
        Assertions.assertThat(movieControllerAll.getBody().get(0).getGenre()).isEqualTo(expectedGenre);
        Assertions.assertThat(movieControllerAll.getBody().get(0).getUrlStream()).isEqualTo(expectedUrl);
    }

    @Test
    @DisplayName("Busca uma lista de filmes por generos que nao existe")
    void getCatalogNotFound() {

        ResponseEntity<List<MovieDTO>> movieControllerAll = movieController.getCatalog("Acao");

        Assertions.assertThat(movieControllerAll).isNotNull();
        Assertions.assertThat(movieControllerAll.getBody()).isNotNull();
        Assertions.assertThat(movieControllerAll.getBody().size()).isEqualTo(1);
    }
}