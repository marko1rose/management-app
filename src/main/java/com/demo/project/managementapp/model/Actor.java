package com.demo.project.managementapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private LocalDate bornDate;

    @ManyToMany
    @JoinTable(name = "movie_actor", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "imdbId"))
    private List<Movie> movies;

}
