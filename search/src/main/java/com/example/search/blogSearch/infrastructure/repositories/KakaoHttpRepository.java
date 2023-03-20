package com.example.search.blogSearch.infrastructure.repositories;

import com.example.search.blogSearch.infrastructure.rest.dto.SearchResultDto;

public interface KakaoHttpRepository {

  SearchResultDto search(String authorization, String query, String sort, Integer page, Integer size);

}
