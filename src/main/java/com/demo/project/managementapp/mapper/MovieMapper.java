package com.demo.project.managementapp.mapper;

import com.demo.project.managementapp.model.Actor;
import com.demo.project.managementapp.model.Movie;
import com.demo.project.managementapp.resource.ActorResource;
import com.demo.project.managementapp.resource.ActorResponse;
import com.demo.project.managementapp.resource.MovieResource;
import com.demo.project.managementapp.resource.MovieResponse;
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
