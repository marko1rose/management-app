package com.demo.project.managementapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    private String imdbId;
    @NotNull
    private String title;
    @NotNull
    private int releaseYear;
    @NotNull
    private String description;

    @ManyToMany(mappedBy = "movies", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Actor> actors = new ArrayList<>();

    @ElementCollection
    private List<String> pictures = new ArrayList<>();

    public Movie(String title, int releaseYear, String description) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.description = description;
    }

    @PreRemove
    private void removeMoviesFromActors() {
        for (Actor a : actors) {
            a.getMovies().remove(this);
        }
    }
}
