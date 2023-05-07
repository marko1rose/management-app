package com.demo.project.movieservice.service;

import com.demo.project.common.model.Movie;

import java.util.List;

public interface IMovieService {

    Movie createMovie(Movie movie);

    List<Movie> getAllMovies();

    List<Movie> getAllMoviesPagination(int page, int size);

    Movie getMovie(String id);

    void deleteMovie(String id);

    Movie updateMovie(String id , Movie movie);

    List<Movie> findByTitle(String title);

}
