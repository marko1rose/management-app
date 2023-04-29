package com.demo.project.managementapp.actorservice;

import com.demo.project.managementapp.model.Actor;
import com.demo.project.managementapp.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService implements IActorService{

    @Autowired
    private ActorRepository actorRepository;

    @Override
    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

}
