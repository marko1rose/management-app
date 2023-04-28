package com.demo.project.managementapp.movieservice;

import com.demo.project.managementapp.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IMovieService{

    @Override
    public List<Movie> getAllMovies() {
        return null;
    }
    
}
