package com.example.search.blogSearch.interfaces.rest;


import static com.example.search.constants.BlogSearchApiUrl.API_V1;
import static com.example.search.constants.BlogSearchApiUrl.BLOG_BASE_URL;
import static com.example.search.constants.BlogSearchApiUrl.BLOG_SEARCH;

import com.example.search.blogSearch.applications.queryservices.BlogSearchService;
import com.example.search.blogSearch.domain.service.dto.SearchResultDto;
import com.example.search.blogSearch.interfaces.rest.dto.BlogSearchListResponseDto;
import com.example.search.blogSearch.interfaces.rest.dto.BlogSearchRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping(BLOG_BASE_URL + API_V1)
public class BlogSearchController {

  private final BlogSearchService blogSearchService;


  @PostMapping(BLOG_SEARCH)
  public SearchResultDto getBlogSearchResult(
      @RequestBody BlogSearchRequestDto blogSearchRequestDto) {

    SearchResultDto searchResult = blogSearchService.getSearchResult();
    return searchResult;

  }

}
