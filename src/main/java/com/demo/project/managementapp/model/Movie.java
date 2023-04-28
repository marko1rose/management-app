package com.demo.project.managementapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Movie {

    @Id
    private String imdbID;
    private String title;
    private int year;
    private String description;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Actor> actors;

    @ElementCollection
    private List<String> pictures;

}
