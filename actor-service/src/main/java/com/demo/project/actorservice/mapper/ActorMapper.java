package com.demo.project.actorservice.mapper;


import com.demo.project.actorservice.resource.ActorResource;
import com.demo.project.actorservice.resource.ActorResponse;
import com.demo.project.actorservice.resource.MovieResponse;
import com.demo.project.common.model.Actor;
import com.demo.project.common.model.Movie;
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
