package com.demo.project.managementapp.controller;

import com.demo.project.managementapp.actorservice.ActorService;
import com.demo.project.managementapp.mapper.ActorMapper;
import com.demo.project.managementapp.model.Actor;
import com.demo.project.managementapp.resource.ActorResource;
import com.demo.project.managementapp.resource.ActorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController {

    @Autowired
    private ActorService actorService;
    @Autowired
    private ActorMapper actorMapper;

    @PostMapping("/create")
    public ResponseEntity<ActorResponse> createActor(@RequestBody ActorResource actorResource) {
        Actor actor = actorMapper.toActor(actorResource);
        return ResponseEntity.ok(actorMapper.fromActor(actorService.createActor(actor)));
    }

    @GetMapping("/allActors")
    public ResponseEntity<List<ActorResponse>> getAllActors() {
        return ResponseEntity.ok(actorMapper.fromActorList(actorService.getAllActors()));
    }

    @GetMapping("/allActors/pagination")
    public ResponseEntity<List<ActorResponse>> getActorsPagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(actorMapper.fromActorList(actorService.getAllActorsPagination(page, size)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActorResponse> getActor(@PathVariable Long id) {
        return ResponseEntity.ok(actorMapper.fromActor(actorService.getActor(id)));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteActor(@PathVariable Long id) {
        actorService.deleteActor(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActorResponse> updateActor(@PathVariable Long id, @RequestBody ActorResource actorResource) {
        Actor actor = actorMapper.toActor(actorResource);
        return ResponseEntity.ok(actorMapper.fromActor(actorService.updateActor(id, actor)));
    }

}
