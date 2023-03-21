package com.example.search.blogSearch.interfaces.rest;

import static com.example.search.constants.BlogSearchApiUrl.API_V1;
import static com.example.search.constants.BlogSearchApiUrl.BLOG_BASE_URL;
import static com.example.search.constants.BlogSearchApiUrl.KEYWORD;

import com.example.search.blogSearch.applications.queryservices.KeywordListService;
import com.example.search.blogSearch.interfaces.rest.dto.KeywordListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(BLOG_BASE_URL + API_V1)
public class KeywordSumController {

  private final KeywordListService keywordListService;

  @GetMapping(KEYWORD)
  public KeywordListResponseDto getKeywordList() {

    return keywordListService.getKeywordList();
  }

}
