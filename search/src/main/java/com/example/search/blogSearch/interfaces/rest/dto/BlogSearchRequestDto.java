package com.example.search.blogSearch.interfaces.rest.dto;


import lombok.Getter;

@Getter
public class BlogSearchRequestDto {

  private String query;
  private String source;
  private String sort;

}
