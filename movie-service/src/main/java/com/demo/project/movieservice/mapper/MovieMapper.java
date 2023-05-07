package com.demo.project.movieservice.mapper;

import com.demo.project.common.model.Actor;
import com.demo.project.common.model.Movie;
import com.demo.project.movieservice.resource.ActorResource;
import com.demo.project.movieservice.resource.ActorResponse;
import com.demo.project.movieservice.resource.MovieResource;
import com.demo.project.movieservice.resource.MovieResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {

  Movie toMovie(MovieResource movieResource);

  @Mapping(target = "id", ignore = true)
  Actor toActor(ActorResource actorResource);

  MovieResponse fromMovie(Movie movie);

  @Mapping(target = "movies", ignore = true)
  ActorResponse toActorResponse(Actor actor);

  List<MovieResponse> fromMovieList(List<Movie> movies);
}
