package com.example.search.blogSearch.domain.service;

import static com.example.search.constants.Constants.KAKAO_API_KEY;

import com.example.search.blogSearch.constants.SearchSourceType;
import com.example.search.blogSearch.domain.exceptions.DefaultFeignException;
import com.example.search.blogSearch.infrastructure.rest.dto.KaKaoSearchResultDto;
import com.example.search.blogSearch.infrastructure.rest.dto.KakaoSearchDto;
import com.example.search.blogSearch.infrastructure.rest.dto.SearchResultDto;
import com.example.search.blogSearch.infrastructure.rest.feign.SearchKakaoFeignClient;
import com.example.search.blogSearch.infrastructure.rest.mapper.ResultDtoMapper;
import com.example.search.config.feign.DefaultClientErrorDecoder;
import feign.FeignException;
import feign.FeignException.FeignClientException;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class KaKaoSearchService implements SearchService<KakaoSearchDto> {

  private final SearchKakaoFeignClient searchKakaoFeignClient;

  private final ResultDtoMapper resultDtoMapper;

  @Value(KAKAO_API_KEY)
  private String restApiKey;

  @Override
  public SearchSourceType getSearchSourceType() {
    return SearchSourceType.KAKAO_SOURCE;
  }

  @Override
  public SearchResultDto search(KakaoSearchDto kakaoSearchDto) {

    try {
      KaKaoSearchResultDto kaKaoSearchResultDto = searchKakaoFeignClient.getSearchResult(restApiKey,
          kakaoSearchDto.getQuery(), kakaoSearchDto.getSort(),
          kakaoSearchDto.getPage(), kakaoSearchDto.getSize());

      return SearchResultDto.builder()
          .total_count(kaKaoSearchResultDto.getMeta().getTotal_count())
          .pageable_count(null)
          .documents(kaKaoSearchResultDto.getDocuments().stream()
              .map(resultDtoMapper::toDocuments).collect(Collectors.toList()))
          .build();

    } catch (FeignClientException e) {
      throw new DefaultFeignException();
    }

  }
}
