package com.example.search.blogSearch.infrastructure.rest;

import com.example.search.blogSearch.domain.service.dto.SearchResultDto;
import com.example.search.blogSearch.infrastructure.repositories.KakaoHttpRepository;
import com.example.search.blogSearch.infrastructure.rest.dto.KakaoSearchResponseDto;
import com.example.search.blogSearch.infrastructure.rest.feign.SearchKakaoFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class KakaoHttpRepositoryImpl implements KakaoHttpRepository {

  private final SearchKakaoFeignClient searchKakaoFeignClient;

  @Override
  public SearchResultDto search(String authorization, String query, String sort, Integer page, Integer size) {
    return searchKakaoFeignClient.getSearchResult(authorization, query, sort, page, size);
  }

}
