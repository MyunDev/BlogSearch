package com.example.search.blogSearch.infrastructure.rest.dto;

public class NaverSearchDto extends SearchDto{

  public NaverSearchDto(String query, String sort, Integer start, Integer display) {
    super(query, sort, start, display);
  }
}
