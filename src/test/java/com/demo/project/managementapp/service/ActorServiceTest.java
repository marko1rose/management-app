package com.demo.project.managementapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.demo.project.managementapp.actorservice.IActorService;
import com.demo.project.managementapp.model.Actor;
import com.demo.project.managementapp.repository.ActorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ActorServiceTest {

    @Autowired
    private IActorService actorService;
    @MockBean
    private ActorRepository actorRepository;

    @Test
    public void testCreateActor() {
        Actor actor = createActor(1L);

        when(actorRepository.findById(actor.getId())).thenReturn(Optional.of(actor));
        when(actorRepository.save(actor)).thenReturn(actor);

        Actor result = actorService.createActor(actor);

        assertEquals(actor, result);
    }

    @Test
    public void testGetAllActors() {
        List<Actor> actors = new ArrayList<>();
        actors.add(createActor(1L));
        actors.add(createActor(2L));

        when(actorRepository.findAll()).thenReturn(actors);

        List<Actor> result = actorService.getAllActors();

        assertEquals(actors, result);
        assertEquals(2, result.size());
    }

    @Test
    public void testGetAllActorsPagination() {
        List<Actor> actors = new ArrayList<>();
        actors.add(createActor(1L));
        actors.add(createActor(2L));

        Page<Actor> actorPage = new PageImpl<>(actors);
        when(actorRepository.findAll(any(Pageable.class))).thenReturn(actorPage);

        List<Actor> result = actorService.getAllActorsPagination(0, 2);

        assertEquals(actors, result);
        assertEquals(2, result.size());
    }

    @Test
    public void testGetActor() {
        Actor actor = createActor(1L);

        when(actorRepository.findById(actor.getId())).thenReturn(Optional.of(actor));

        Actor result = actorService.getActor(actor.getId());

        assertEquals(actor, result);
    }

    @Test
    public void testDeleteActor() {
        Long id = 1L;
        actorService.deleteActor(id);
        verify(actorRepository, times(1)).deleteById(id);
    }

    @Test
    public void testUpdateActorNotFound() {
        Long id = 1L;
        Actor actor = createActor(id);
        when(actorRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> actorService.updateActor(id, actor));
    }

    @Test
    public void testUpdateActor() {
        Long id = 1L;
        Actor existingActor = createActor(id);
        Actor updatedActor = new Actor("Jane", "Doe", LocalDate.of(1995, 1, 1));
        when(actorRepository.findById(id)).thenReturn(Optional.of(existingActor));
        when(actorRepository.save(existingActor)).thenReturn(existingActor);

        Actor result = actorService.updateActor(id, updatedActor);

        assertEquals(result.getFirstName(), updatedActor.getFirstName());
        assertEquals(result.getLastName(), updatedActor.getLastName());
        assertEquals(result.getDateOfBirth(), updatedActor.getDateOfBirth());
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
