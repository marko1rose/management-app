package com.demo.project.actorservice.resource;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ActorResponse {
  private Long id;
  private String firstName;
  private String lastName;
  private LocalDate dateOfBirth;
  private List<MovieResponse> movies;
}
