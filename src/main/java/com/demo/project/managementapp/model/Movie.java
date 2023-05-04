package com.demo.project.managementapp.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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

    @ManyToMany(mappedBy = "movies", cascade = CascadeType.DETACH)
    private List<Actor> actors;

    @ElementCollection
    private List<String> pictures = new ArrayList<>();

    public Movie(String title, int releaseYear, String description) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.description = description;
    }
}
