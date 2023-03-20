package com.example.search.blogSearch.domain.service;

import com.example.search.blogSearch.constants.SearchSourceType;
import com.example.search.blogSearch.infrastructure.rest.dto.SearchDto;
import com.example.search.blogSearch.infrastructure.rest.dto.SearchResultDto;
import com.example.search.blogSearch.infrastructure.rest.dto.SearchResultTestDto;

public interface SearchService<T extends SearchDto> {

  public abstract SearchSourceType getSearchSourceType();
  SearchResultTestDto search(T t);

}
