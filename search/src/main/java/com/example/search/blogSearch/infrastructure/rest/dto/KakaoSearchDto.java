package com.example.search.blogSearch.infrastructure.rest.dto;

public class KakaoSearchDto extends SearchDto{

  public KakaoSearchDto(String query, String sort, Integer page, Integer size) {
    super(query, sort, page, size);
  }
}
