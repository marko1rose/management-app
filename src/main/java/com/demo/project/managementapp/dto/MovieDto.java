package com.demo.project.managementapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
public class MovieDto {
  private String imdbId;
  private String title;
  private int releaseYear;
  private String description;
  private List<String> pictures;
  @JsonIgnoreProperties("movies")
  private List<ActorDto> actors;
}