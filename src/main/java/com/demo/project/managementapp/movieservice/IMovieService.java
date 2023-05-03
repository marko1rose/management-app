package com.demo.project.managementapp.movieservice;

import com.demo.project.managementapp.model.Movie;

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
