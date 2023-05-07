package com.demo.project.movieservice.service;

import com.demo.project.common.model.Movie;
import com.demo.project.common.repository.MovieRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class MovieServiceTest {

   @Autowired
    private IMovieService movieService;
    @MockBean
    private MovieRepository movieRepository;

    @Test
    public void createMovieTest() {
        Movie movie = createMovie("tt5675363");

        when(movieRepository.findById(movie.getImdbId())).thenReturn(null);
        when(movieRepository.save(movie)).thenReturn(movie);

        Movie result = movieService.createMovie(movie);

        assertEquals(movie, result);
    }

    @Test
    public void testGetAllMovies() {
        List<Movie> movies = new ArrayList<>();
        movies.add(createMovie("tt2741602"));
        movies.add(createMovie("tt2741468"));

        when(movieRepository.findAll()).thenReturn(movies);

        List<Movie> result = movieService.getAllMovies();

        assertEquals(movies, result);
        assertEquals(2, result.size());
    }

    @Test
    public void testGetAllMoviesPagination() {
        List<Movie> movies = new ArrayList<>();
        movies.add(createMovie("tt2741602"));
        movies.add(createMovie("tt2741468"));

        Page<Movie> moviePage = new PageImpl<>(movies);
        when(movieRepository.findAll(any(Pageable.class))).thenReturn(moviePage);

        List<Movie> result = movieService.getAllMoviesPagination(0, 2);

        assertEquals(movies, result);
        assertEquals(2, result.size());
    }

    @Test
    public void testGetMovie() {
        Movie movie = createMovie("tt2741602");

        when(movieRepository.findById(movie.getImdbId())).thenReturn(Optional.of(movie));

        Movie result = movieService.getMovie(movie.getImdbId());

        assertEquals(movie, result);
    }

    @Test
    public void testDeleteMovie() {
        String id = "tt21302401";
        movieService.deleteMovie(id);
        verify(movieRepository, times(1)).deleteById(id);
    }

    @Test
    public void testUpdateMovieNotFound() {
        String id = "tt21302401";
        Movie movie = createMovie(id);
        when(movieRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> movieService.updateMovie(id, movie));
    }

    @Test
    public void testUpdateMovie() {
        String id = "tt21302401";
        Movie existingMovie = createMovie(id);
        Movie updatedMovie = new Movie("Inception", 2010, "Movie description");
        when(movieRepository.findById(id)).thenReturn(Optional.of(existingMovie));
        when(movieRepository.save(existingMovie)).thenReturn(existingMovie);

        Movie result = movieService.updateMovie(id, updatedMovie);

        assertEquals(result.getTitle(), updatedMovie.getTitle());
        assertEquals(result.getReleaseYear(), updatedMovie.getReleaseYear());
        assertEquals(result.getDescription(), updatedMovie.getDescription());
    }

    @Test
    public void testFindMovieByTitle() {
        String id = "tt21302401";
        Movie movie = createMovie(id);
        when(movieRepository.findByTitleContainsIgnoreCase(movie.getTitle())).thenReturn(singletonList(movie));

        List<Movie> result = movieService.findByTitle(movie.getTitle());

        assertEquals(1, result.size());
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
