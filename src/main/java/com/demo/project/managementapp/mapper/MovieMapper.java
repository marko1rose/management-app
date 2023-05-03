package com.demo.project.managementapp.mapper;

import com.demo.project.managementapp.dto.ActorDto;
import com.demo.project.managementapp.dto.MovieDto;
import com.demo.project.managementapp.model.Actor;
import com.demo.project.managementapp.model.Movie;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {

  Movie toMovie(MovieDto movieDto);

  MovieDto fromMovie(Movie movie);

  List<MovieDto> fromMovieList(List<Movie> movies);
}
