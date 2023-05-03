package com.demo.project.managementapp.mapper;

import com.demo.project.managementapp.dto.ActorDto;
import com.demo.project.managementapp.dto.MovieDto;
import com.demo.project.managementapp.model.Actor;
import com.demo.project.managementapp.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ActorMapper {

  Actor toActor(ActorDto actorDto);

  ActorDto fromActor(Actor actor);

  @Mapping(target = "actors", ignore = true)
  MovieDto toMovieDto(Movie movie);

  List<ActorDto> fromActorList(List<Actor> actors);

}
