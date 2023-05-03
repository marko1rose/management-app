package com.demo.project.managementapp.controller;

import com.demo.project.managementapp.dto.MovieDto;
import com.demo.project.managementapp.mapper.ActorMapper;
import com.demo.project.managementapp.mapper.MovieMapper;
import com.demo.project.managementapp.model.Movie;
import com.demo.project.managementapp.movieservice.MovieService;
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
    public ResponseEntity<Movie> createMovie(@RequestBody MovieDto movieDto) {
        Movie movie = movieMapper.toMovie(movieDto);
        return ResponseEntity.ok(movieMapper.fromMovie(movieService.createMovie(movie)));
    }

    @GetMapping("/allMovies")
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieMapper.fromMovieList(movieService.getAllMovies()));
    }

    @GetMapping("/allMovies/pagination")
    public ResponseEntity<List<Movie>> getMoviesPagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(movieMapper.fromMovieList(movieService.getAllMoviesPagination(page, size)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable String id) {
        return ResponseEntity.ok(movieMapper.fromMovie(movieService.getMovie(id)));
    }

    @DeleteMapping("/{id}")
    void deleteEmployee(@PathVariable String id) {
        movieService.deleteMovie(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable String id, @RequestBody MovieDto movieDto) {
        Movie movie = movieMapper.toMovie(movieDto);
        return ResponseEntity.ok(movieMapper.fromMovie(movieService.updateMovie(id, movie)));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Movie>> searchMovieByTitle(@RequestParam String title) {
        return ResponseEntity.ok(movieMapper.fromMovieList(movieService.findByTitle(title)));
    }

}
