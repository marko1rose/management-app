package com.demo.project.managementapp.mapper;

import com.demo.project.managementapp.dto.ActorDto;
import com.demo.project.managementapp.model.Actor;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ActorMapper {

  Actor toActor(ActorDto actorDto);

  ActorDto fromActor(Actor actor);

  List<ActorDto> fromActorList(List<Actor> actors);

}
