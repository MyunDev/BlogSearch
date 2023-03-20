package com.example.search.blogSearch.domain.service;

import com.example.search.blogSearch.constants.SearchSourceType;
import com.example.search.blogSearch.infrastructure.rest.dto.SearchDto;
import com.example.search.blogSearch.infrastructure.rest.dto.SearchResultDto;

public interface SearchService<T extends SearchDto> {

  public abstract SearchSourceType getSearchSourceType();
  SearchResultDto search(T t);

}
