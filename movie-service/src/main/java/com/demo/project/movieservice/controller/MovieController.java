package com.demo.project.movieservice.controller;

import com.demo.project.common.model.Movie;
import com.demo.project.movieservice.mapper.MovieMapper;
import com.demo.project.movieservice.resource.MovieResource;
import com.demo.project.movieservice.resource.MovieResponse;
import com.demo.project.movieservice.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;
    @Autowired
    private MovieMapper movieMapper;

    @PostMapping("/create")
    public ResponseEntity<MovieResponse> createMovie(@RequestBody MovieResource movieResource) {
        Movie movie = movieMapper.toMovie(movieResource);
        return ResponseEntity.ok(movieMapper.fromMovie(movieService.createMovie(movie)));
    }

    @GetMapping("/allMovies")
    public ResponseEntity<List<MovieResponse>> getAllMovies() {
        return ResponseEntity.ok(movieMapper.fromMovieList(movieService.getAllMovies()));
    }

    @GetMapping("/allMovies/pagination")
    public ResponseEntity<List<MovieResponse>> getMoviesPagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(movieMapper.fromMovieList(movieService.getAllMoviesPagination(page, size)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponse> getMovieById(@PathVariable String id) {
        return ResponseEntity.ok(movieMapper.fromMovie(movieService.getMovie(id)));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteMovie(@PathVariable String id) {
       movieService.deleteMovie(id);
       return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieResponse> updateMovie(@PathVariable String id, @RequestBody MovieResource movieResource) {
        Movie movie = movieMapper.toMovie(movieResource);
        return ResponseEntity.ok(movieMapper.fromMovie(movieService.updateMovie(id, movie)));
    }

    @GetMapping("/search")
    public ResponseEntity<List<MovieResponse>> searchMovieByTitle(@RequestParam String title) {
        return ResponseEntity.ok(movieMapper.fromMovieList(movieService.findByTitle(title)));
    }

}
