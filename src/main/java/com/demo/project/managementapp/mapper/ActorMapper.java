package com.demo.project.managementapp.mapper;

import com.demo.project.managementapp.model.Actor;
import com.demo.project.managementapp.model.Movie;
import com.demo.project.managementapp.resource.ActorResource;
import com.demo.project.managementapp.resource.ActorResponse;
import com.demo.project.managementapp.resource.MovieResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ActorMapper {

  @Mapping(target = "id", ignore = true)
  Actor toActor(ActorResource actorResource);

  ActorResponse fromActor(Actor actor);

  @Mapping(target = "actors", ignore = true)
  MovieResponse toMovieResponse(Movie movie);

  List<ActorResponse> fromActorList(List<Actor> actors);

}
