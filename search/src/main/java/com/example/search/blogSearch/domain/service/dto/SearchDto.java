package com.example.search.blogSearch.domain.service.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public abstract class SearchDto {

  private final String query;

  private final String sort;

  private final Integer page;

  private final Integer size;

  public SearchDto(String query, String sort, Integer page, Integer size) {
    this.query = query;
    this.sort = sort;
    this.page = page;
    this.size = size;
  }
}
