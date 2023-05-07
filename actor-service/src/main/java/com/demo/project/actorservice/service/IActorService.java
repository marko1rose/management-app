package com.demo.project.actorservice.service;

import com.demo.project.common.model.Actor;

import java.util.List;

public interface IActorService {

    Actor createActor(Actor actor);

    List<Actor> getAllActors();

    List<Actor> getAllActorsPagination(int page, int size);

    Actor getActor(Long id);

    void deleteActor(Long id);

    Actor updateActor(Long id , Actor actor);

}
