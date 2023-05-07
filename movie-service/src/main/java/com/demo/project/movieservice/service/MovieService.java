package com.demo.project.movieservice.service;

import com.demo.project.common.model.Movie;
import com.demo.project.common.repository.MovieRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IMovieService {

    @Autowired
    private MovieRepository movieRepository;

    @CacheEvict(value = "movies", allEntries = true)
    @Override
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Cacheable("movies")
    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Cacheable("movies")
    @Override
    public List<Movie> getAllMoviesPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("title"));
        Page<Movie> movies = movieRepository.findAll(pageable);
        return movies.getContent();
    }

    @Override
    public Movie getMovie(String id) {
        return movieRepository.findById(id).orElse(null);
    }

    @CacheEvict(value = "movies", allEntries = true)
    @Override
    public void deleteMovie(String id) {
        movieRepository.deleteById(id);
    }

    @CacheEvict(value = "movies", allEntries = true)
    @Override
    public Movie updateMovie(String id , Movie movie) {
        Movie dbMovie = movieRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Movie with id = " + id + " not found"));
        dbMovie.setTitle(movie.getTitle());
        dbMovie.setReleaseYear(movie.getReleaseYear());
        dbMovie.setDescription(movie.getDescription());
        return movieRepository.save(dbMovie);
    }

    @Cacheable("movies")
    @Override
    public List<Movie> findByTitle(String title) {
        return movieRepository.findByTitleContainsIgnoreCase(title);
    }

}
