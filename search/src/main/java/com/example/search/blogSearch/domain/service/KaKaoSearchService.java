package com.example.search.blogSearch.domain.service;

import com.example.search.blogSearch.domain.service.dto.KakaoSearchDto;
import com.example.search.blogSearch.domain.service.dto.SearchResultDto;
import com.example.search.blogSearch.infrastructure.rest.feign.SearchKakaoFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class KaKaoSearchService implements SearchService<KakaoSearchDto>{

  private final SearchKakaoFeignClient searchKakaoFeignClient;

  private final String restApiKey = "KakaoAK 0843e64cd14a049e15aea40c5451f049";

  @Override
  public SearchResultDto search(KakaoSearchDto kakaoSearchDto) {
    return searchKakaoFeignClient.getSearchResult(restApiKey, kakaoSearchDto.getQuery(), kakaoSearchDto.getSort(),
        kakaoSearchDto.getPage(), kakaoSearchDto.getSize());
  }
}
