package com.example.search.blogSearch.domain.service.dto;

public class NaverSearchDto extends SearchDto{

  public NaverSearchDto(String query, String sort, Integer start, Integer display) {
    super(query, sort, start, display);
  }
}
