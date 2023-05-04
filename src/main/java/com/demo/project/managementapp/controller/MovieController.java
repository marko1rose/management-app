package com.demo.project.managementapp.controller;

import com.demo.project.managementapp.dto.MovieDto;
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
    public ResponseEntity<MovieDto> createMovie(@RequestBody MovieDto movieDto) {
        Movie movie = movieMapper.toMovie(movieDto);
        return ResponseEntity.ok(movieMapper.fromMovie(movieService.createMovie(movie)));
    }

    @GetMapping("/allMovies")
    public ResponseEntity<List<MovieDto>> getAllMovies() {
        return ResponseEntity.ok(movieMapper.fromMovieList(movieService.getAllMovies()));
    }

    @GetMapping("/allMovies/pagination")
    public ResponseEntity<List<MovieDto>> getMoviesPagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(movieMapper.fromMovieList(movieService.getAllMoviesPagination(page, size)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getMovieById(@PathVariable String id) {
        return ResponseEntity.ok(movieMapper.fromMovie(movieService.getMovie(id)));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteMovie(@PathVariable String id) {
       movieService.deleteMovie(id);
       return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> updateMovie(@PathVariable String id, @RequestBody MovieDto movieDto) {
        Movie movie = movieMapper.toMovie(movieDto);
        return ResponseEntity.ok(movieMapper.fromMovie(movieService.updateMovie(id, movie)));
    }

    @GetMapping("/search")
    public ResponseEntity<List<MovieDto>> searchMovieByTitle(@RequestParam String title) {
        return ResponseEntity.ok(movieMapper.fromMovieList(movieService.findByTitle(title)));
    }

}
