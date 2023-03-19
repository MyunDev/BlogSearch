package com.example.search.blogSearch.interfaces.rest.dto;


import lombok.Getter;

@Getter
public class BlogSearchRequestDto {

  private String query;

  private String sort;

  private Integer page;

  private Integer size;


}
