package com.demo.project.managementapp.actorservice;

import com.demo.project.managementapp.model.Actor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService implements IActorService{

    @Override
    public List<Actor> getAllActors() {
        return null;
    }

}
