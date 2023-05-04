package com.demo.project.managementapp.movieservice;

import com.demo.project.managementapp.model.Movie;
import com.demo.project.managementapp.repository.MovieRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

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

    @Override
    public void deleteMovie(String id) {
        movieRepository.deleteById(id);
    }

    @Override
    public Movie updateMovie(String id , Movie movie) {
        Movie dbMovie = movieRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Movie with id = " + id + " not found"));
        dbMovie.setTitle(movie.getTitle());
        dbMovie.setReleaseYear(movie.getReleaseYear());
        dbMovie.setDescription(movie.getDescription());
        return movieRepository.save(dbMovie);
    }

    @Override
    public List<Movie> findByTitle(String title) {
        return movieRepository.findByTitleContainsIgnoreCase(title);
    }

}
