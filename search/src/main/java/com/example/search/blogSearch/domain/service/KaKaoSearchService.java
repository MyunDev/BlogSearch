package com.example.search.blogSearch.domain.service;

import com.example.search.blogSearch.constants.SearchSourceType;
import com.example.search.blogSearch.infrastructure.rest.dto.KaKaoSearchResultDto;
import com.example.search.blogSearch.infrastructure.rest.dto.KakaoSearchDto;
import com.example.search.blogSearch.infrastructure.rest.dto.SearchResultDto;
import com.example.search.blogSearch.infrastructure.rest.feign.SearchKakaoFeignClient;
import com.example.search.blogSearch.infrastructure.rest.mapper.ResultDtoMapper;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class KaKaoSearchService implements SearchService<KakaoSearchDto> {

  private final SearchKakaoFeignClient searchKakaoFeignClient;

  private final ResultDtoMapper resultDtoMapper;

  private final String restApiKey = "KakaoAK 0843e64cd14a049e15aea40c5451f049";

  @Override
  public SearchSourceType getSearchSourceType() {
    return SearchSourceType.KAKAO_SOURCE;
  }

  @Override
  public SearchResultDto search(KakaoSearchDto kakaoSearchDto) {

    KaKaoSearchResultDto kaKaoSearchResultDto = searchKakaoFeignClient.getSearchResult(restApiKey,
        kakaoSearchDto.getQuery(), kakaoSearchDto.getSort(),
        kakaoSearchDto.getPage(), kakaoSearchDto.getSize());

    return SearchResultDto.builder()
        .total_count(kaKaoSearchResultDto.getMeta().getTotal_count())
        .pageable_count(null)
        .documents(kaKaoSearchResultDto.getDocuments().stream()
            .map(resultDtoMapper::toDocuments).collect(Collectors.toList()))
        .build();
  }
}
