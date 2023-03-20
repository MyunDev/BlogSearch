package com.example.search.blogSearch.interfaces.rest;


import static com.example.search.constants.BlogSearchApiUrl.API_V1;
import static com.example.search.constants.BlogSearchApiUrl.BLOG_BASE_URL;
import static com.example.search.constants.BlogSearchApiUrl.BLOG_SEARCH;

import com.example.search.blogSearch.applications.queryservices.BlogSearchService;
import com.example.search.blogSearch.interfaces.rest.dto.BlogSearchRequestDto;
import com.example.search.blogSearch.interfaces.rest.dto.BlogSearchResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping(BLOG_BASE_URL + API_V1)
public class BlogSearchController {

  private final BlogSearchService blogSearchService;


  /**
   * 블로그 검색 API
   * @param blogSearchRequestDto
   * @param page
   * @param size
   * @return
   */
  @PostMapping(BLOG_SEARCH)
  public BlogSearchResponseDto getBlogSearchResult(
      @RequestBody BlogSearchRequestDto blogSearchRequestDto,
      @RequestParam("page") Integer page,
      @RequestParam("size") Integer size) {

    return blogSearchService.getSearchResult(blogSearchRequestDto, page, size);

  }

}
