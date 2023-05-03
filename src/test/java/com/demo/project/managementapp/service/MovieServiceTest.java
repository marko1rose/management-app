package com.demo.project.managementapp.service;

import com.demo.project.managementapp.model.Movie;
import com.demo.project.managementapp.movieservice.IMovieService;
import com.demo.project.managementapp.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class MovieServiceTest {

    @Autowired
    private IMovieService movieService;
    @MockBean
    private MovieRepository movieRepository;

    @Test
    public void createActorTest() {
        Movie movie = createMovie("tt2741602");

        when(movieRepository.findById(movie.getImdbId())).thenReturn(Optional.of(movie));
        when(movieRepository.save(movie)).thenReturn(movie);

        Movie result = movieService.createMovie(movie);

        assertEquals(movie, result);
    }

    @Test
    public void getAllActorsTest() {
        List<Movie> movies = new ArrayList<>();
        movies.add(createMovie("tt2741602"));
        movies.add(createMovie("tt2741468"));

        when(movieRepository.findAll()).thenReturn(movies);

        List<Movie> result = movieService.getAllMovies();

        assertEquals(movies, result);
        assertEquals(2, result.size());
    }

    @Test
    public void getActorTest() {
        Movie movie = createMovie("tt2741602");

        when(movieRepository.findById(movie.getImdbId())).thenReturn(Optional.of(movie));

        Movie result = movieService.getMovie(movie.getImdbId());

        assertEquals(movie, result);
    }

    private Movie createMovie(String id) {
        Movie movie = new Movie();
        movie.setImdbId(id);
        movie.setTitle("Movie title");
        movie.setDescription("Movie description");
        movie.setReleaseYear(2000);
        movie.setPictures(singletonList("Movie pictures"));
        return movie;
    }

}
