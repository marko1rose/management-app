package com.demo.project.managementapp.resource;

import lombok.Data;

import java.util.List;

@Data
public class MovieResponse {
  private String imdbId;
  private String title;
  private int releaseYear;
  private String description;
  private List<String> pictures;
  private List<ActorResponse> actors;
}