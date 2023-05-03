package com.demo.project.managementapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ActorDto {
  private Long id;
  private String firstName;
  private String lastName;
  private LocalDate dateOfBirth;
  @JsonIgnoreProperties("actors")
  private List<MovieDto> movies;
}
