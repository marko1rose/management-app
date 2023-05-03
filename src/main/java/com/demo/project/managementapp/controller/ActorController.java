package com.demo.project.managementapp.controller;

import com.demo.project.managementapp.actorservice.ActorService;
import com.demo.project.managementapp.dto.ActorDto;
import com.demo.project.managementapp.mapper.ActorMapper;
import com.demo.project.managementapp.model.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController {

    @Autowired
    private ActorService actorService;
    @Autowired
    private ActorMapper actorMapper;

    @PostMapping("/create")
    public ResponseEntity<ActorDto> createMovie(@RequestBody ActorDto actorDto) {
        Actor actor = actorMapper.toActor(actorDto);
        return ResponseEntity.ok(actorMapper.fromActor(actorService.createActor(actor)));
    }

    @GetMapping("/allActors")
    public ResponseEntity<List<ActorDto>> getAllActors() {
        return ResponseEntity.ok(actorMapper.fromActorList(actorService.getAllActors()));
    }

    @GetMapping("/allActors/pagination")
    public ResponseEntity<List<Actor>> getActorsPagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(actorMapper.fromActorList(actorService.getAllActorsPagination(page, size)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Actor> getActor(@PathVariable Long id) {
        return ResponseEntity.ok(actorMapper.fromActor(actorService.getActor(id)));
    }

    @DeleteMapping("/{id}")
    void deleteEmployee(@PathVariable Long id) {
        actorService.deleteActor(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Actor> updateMovie(@PathVariable Long id, @RequestBody ActorDto actorDto) {
        Actor actor = actorMapper.toActor(actorDto);
        return ResponseEntity.ok(actorMapper.fromActor(actorService.updateActor(id, actor)));
    }

}
