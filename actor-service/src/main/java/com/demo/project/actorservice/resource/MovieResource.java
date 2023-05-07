package com.demo.project.actorservice.resource;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class MovieResource {

    @NotNull
    private String imdbId;
    @NotNull
    private String title;
    @NotNull
    private int releaseYear;
    @NotNull
    private String description;
    private List<String> pictures;
    private List<ActorResource> actors;

}
