package com.demo.project.managementapp.resource;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ActorResource {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private List<MovieResource> movies;

}
