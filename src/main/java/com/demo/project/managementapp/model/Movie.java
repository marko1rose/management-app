package com.demo.project.managementapp.model;

import jakarta.persistence.*;
import lombok.*;

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
    private String title;
    private int releaseYear;
    private String description;

    @ManyToMany(mappedBy = "movies")
    private List<Actor> actors;

    @ElementCollection
    private List<String> pictures = new ArrayList<>();

}
