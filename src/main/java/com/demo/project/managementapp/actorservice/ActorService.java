package com.demo.project.managementapp.actorservice;

import com.demo.project.managementapp.model.Actor;
import com.demo.project.managementapp.repository.ActorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService implements IActorService {

    @Autowired
    private ActorRepository actorRepository;

    @CacheEvict(value = "actors", allEntries = true)
    @Override
    public Actor createActor(Actor actor) {
        return actorRepository.save(actor);
    }

    @Cacheable("actors")
    @Override
    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    @Cacheable("actors")
    @Override
    public List<Actor> getAllActorsPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id"));
        Page<Actor> actors = actorRepository.findAll(pageable);
        return actors.getContent();
    }

    @Override
    public Actor getActor(Long id) {
        return actorRepository.findById(id).orElse(null);
    }

    @CacheEvict(value = "actors", allEntries = true)
    @Override
    public void deleteActor(Long id) {
        actorRepository.deleteById(id);
    }

    @CacheEvict(value = "actors", allEntries = true)
    @Override
    public Actor updateActor(Long id, Actor actor) {
        Actor dbActor = actorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Actor with id = " + id + " not found"));
        dbActor.setFirstName(actor.getFirstName());
        dbActor.setLastName(actor.getLastName());
        dbActor.setDateOfBirth(actor.getDateOfBirth());
        return actorRepository.save(dbActor);
    }

}
