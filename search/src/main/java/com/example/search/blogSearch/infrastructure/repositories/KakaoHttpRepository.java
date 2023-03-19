package com.example.search.blogSearch.infrastructure.repositories;

import com.example.search.blogSearch.domain.service.dto.SearchResultDto;
import com.example.search.blogSearch.infrastructure.rest.dto.KakaoSearchResponseDto;

public interface KakaoHttpRepository {

  SearchResultDto search(String authorization, String query, String sort, Integer page, Integer size);

}
