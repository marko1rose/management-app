package com.demo.project.managementapp.controller;

import com.demo.project.managementapp.actorservice.ActorService;
import com.demo.project.managementapp.model.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @PostMapping("/create")
    public ResponseEntity<Actor> createMovie(@RequestBody Actor actor) {
        return ResponseEntity.ok(actorService.createActor(actor));
    }

    @GetMapping("/allActors")
    public ResponseEntity<List<Actor>> getAllActors() {
        return ResponseEntity.ok(actorService.getAllActors());
    }

    @GetMapping("/allActors/pagination")
    public ResponseEntity<List<Actor>> getActorsPagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(actorService.getAllActorsPagination(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Actor> getActor(@PathVariable Long id) {
        return ResponseEntity.ok(actorService.getActor(id));
    }

    @DeleteMapping("/{id}")
    void deleteEmployee(@PathVariable Long id) {
        actorService.deleteActor(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Actor> updateMovie(@PathVariable Long id, @RequestBody Actor actor) {
        return ResponseEntity.ok(actorService.updateActor(id, actor));
    }

}
