package com.example.search.blogSearch.domain.service.dto;

import static com.example.search.blogSearch.constants.SearchSourceType.KAKAO_SOURCE;
import static com.example.search.blogSearch.constants.SearchSourceType.NAVER_SOURCE;

import com.example.search.blogSearch.constants.SearchSourceType;
import com.example.search.blogSearch.domain.exceptions.InvalidSearchSourceTypeException;

public class SearchDtoFactory {

  public static SearchDto create(SearchSourceType searchSourceType, String query, String sort,
      Integer page, Integer size) {

    switch (searchSourceType) {
      case KAKAO_SOURCE:
        return new KakaoSearchDto(query, sort, page, size);
      case NAVER_SOURCE:
        return new NaverSearchDto(query, sort, page, size);
      default:
        throw new InvalidSearchSourceTypeException();
    }

  }

}
