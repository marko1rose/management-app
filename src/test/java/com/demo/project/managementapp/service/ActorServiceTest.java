package com.demo.project.managementapp.service;

import com.demo.project.managementapp.actorservice.IActorService;
import com.demo.project.managementapp.model.Actor;
import com.demo.project.managementapp.repository.ActorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ActorServiceTest {

    @Autowired
    private IActorService actorService;
    @MockBean
    private ActorRepository actorRepository;

    @Test
    public void createActorTest() {
        Actor actor = createActor(1L);

        when(actorRepository.findById(actor.getId())).thenReturn(Optional.of(actor));
        when(actorRepository.save(actor)).thenReturn(actor);

        Actor result = actorService.createActor(actor);

        assertEquals(actor, result);
    }

    @Test
    public void getAllActorsTest() {
        List<Actor> actors = new ArrayList<>();
        actors.add(createActor(1L));
        actors.add(createActor(2L));

        when(actorRepository.findAll()).thenReturn(actors);

        List<Actor> result = actorService.getAllActors();

        assertEquals(actors, result);
        assertEquals(2, result.size());
    }

    @Test
    public void getActorTest() {
        Actor actor = createActor(1L);

        when(actorRepository.findById(actor.getId())).thenReturn(Optional.of(actor));

        Actor result = actorService.getActor(actor.getId());

        assertEquals(actor, result);
    }

    private Actor createActor(Long id) {
        Actor actor = new Actor();
        actor.setId(id);
        actor.setFirstName("John");
        actor.setLastName("Doe");
        actor.setDateOfBirth(LocalDate.of(1990, 1, 1));
        return actor;
    }
}
