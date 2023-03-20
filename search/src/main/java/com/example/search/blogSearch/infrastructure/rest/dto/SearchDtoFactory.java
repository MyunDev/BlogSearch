package com.example.search.blogSearch.infrastructure.rest.dto;

import com.example.search.blogSearch.constants.SearchSourceType;
import com.example.search.blogSearch.domain.exceptions.InvalidSearchSourceTypeException;
import com.example.search.constants.ResponseCode;
import com.example.search.libs.exceptions.ApiException;

public class SearchDtoFactory {

  public static SearchDto create(SearchSourceType searchSourceType, String query, String sort,
      Integer page, Integer size) {

    switch (searchSourceType) {
      case KAKAO_SOURCE:
        return new KakaoSearchDto(query, sort, page, size);
      case NAVER_SOURCE:
        return new NaverSearchDto(query, sort, page, size);
      default:
        throw new ApiException(ResponseCode.INVALID_REQUEST);
    }

  }

}
