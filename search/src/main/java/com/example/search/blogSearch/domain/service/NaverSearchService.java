package com.example.search.blogSearch.domain.service;

import com.example.search.blogSearch.constants.SearchSourceType;
import com.example.search.blogSearch.domain.service.dto.NaverSearchDto;
import com.example.search.blogSearch.domain.service.dto.SearchResultDto;

public class NaverSearchService implements SearchService<NaverSearchDto>{

  @Override
  public SearchResultDto search(NaverSearchDto naverSearchDto) {
    return null;
  }

  @Override
  public SearchSourceType getSearchSourceType() {
    return SearchSourceType.NAVER_SOURCE;
  }
}
