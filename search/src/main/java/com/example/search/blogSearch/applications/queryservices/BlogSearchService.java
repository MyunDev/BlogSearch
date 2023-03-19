package com.example.search.blogSearch.applications.queryservices;


import com.example.search.blogSearch.constants.SearchSourceType;
import com.example.search.blogSearch.domain.factory.SearchServiceFactory;
import com.example.search.blogSearch.domain.service.SearchService;
import com.example.search.blogSearch.domain.service.dto.SearchDto;
import com.example.search.blogSearch.domain.service.dto.SearchDtoFactory;
import com.example.search.blogSearch.domain.service.dto.SearchResultDto;
import com.example.search.blogSearch.infrastructure.rest.feign.SearchKakaoFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlogSearchService {

  String query = "코딩";
  String sort = "accuracy";
  Integer page = 1;

  Integer size = 10;

  private final String restApiKey = "KakaoAK 0843e64cd14a049e15aea40c5451f049";

  private final SearchKakaoFeignClient searchKakaoFeignClient;
  public SearchResultDto getSearchResult() {

    final SearchDto searchDto =
        SearchDtoFactory.create(SearchSourceType.KAKAO_SOURCE, query, sort,
            page, size);

    SearchService searchService = SearchServiceFactory.getService(searchDto);
    SearchResultDto searchResultDto = searchService.search(searchDto);

    SearchResultDto searchResult = searchKakaoFeignClient.getSearchResult(restApiKey, query, sort,
        page, size);
    return searchResult;


  }


}
