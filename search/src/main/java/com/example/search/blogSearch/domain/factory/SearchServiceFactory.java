package com.example.search.blogSearch.domain.factory;

import com.example.search.blogSearch.domain.exceptions.InvalidSearchSourceTypeException;
import com.example.search.blogSearch.domain.service.KaKaoSearchService;
import com.example.search.blogSearch.domain.service.NaverSearchService;
import com.example.search.blogSearch.domain.service.SearchService;
import com.example.search.blogSearch.domain.service.dto.KakaoSearchDto;
import com.example.search.blogSearch.domain.service.dto.NaverSearchDto;
import com.example.search.blogSearch.domain.service.dto.SearchDto;
import com.example.search.blogSearch.infrastructure.rest.feign.SearchKakaoFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SearchServiceFactory {

  private static KaKaoSearchService kaKaoSearchService;

  private static NaverSearchService naverSearchService;

  private static SearchKakaoFeignClient searchKakaoFeignClient;

  private static boolean isInit = false;

  public static SearchService getService(SearchDto dto) {
    init();

    if (dto instanceof KakaoSearchDto) {
      return kaKaoSearchService;
    }

    if (dto instanceof NaverSearchDto) {
      return naverSearchService;
    }

    throw new InvalidSearchSourceTypeException();
  }

  public static synchronized void init() {
    if (!isInit) {
      kaKaoSearchService = new KaKaoSearchService(searchKakaoFeignClient);
      naverSearchService = new NaverSearchService();
      isInit = true;
    }
  }

}
