package com.example.search.blogSearch.applications.queryservices;


import com.example.search.blogSearch.constants.SearchSourceType;
import com.example.search.blogSearch.domain.factory.SearchServiceFactory;
import com.example.search.blogSearch.domain.service.KaKaoSearchService;
import com.example.search.blogSearch.domain.service.SearchService;
import com.example.search.blogSearch.domain.service.dto.SearchDto;
import com.example.search.blogSearch.domain.service.dto.SearchDtoFactory;
import com.example.search.blogSearch.domain.service.dto.SearchResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlogSearchService {

  String query = "코딩";
  String sort = "accuracy";
  Integer page = 1;

  Integer size = 10;

  private final SearchServiceFactory searchServiceFactory;

  public SearchResultDto getSearchResult() {

    SearchSourceType sourceType = SearchSourceType.valueOf("KAKAO_SOURCE");
    final SearchDto searchDto = SearchDtoFactory.create(sourceType, query, sort, page, size);

    SearchService searchService = searchServiceFactory.find(SearchSourceType.KAKAO_SOURCE);

    return searchService.search(searchDto);

  }

}
