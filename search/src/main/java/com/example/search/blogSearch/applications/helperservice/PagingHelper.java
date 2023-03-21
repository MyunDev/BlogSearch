package com.example.search.blogSearch.applications.helperservice;

import static com.example.search.constants.BlogSearchApiUrl.API_V1;
import static com.example.search.constants.BlogSearchApiUrl.BLOG_BASE_URL;
import static com.example.search.constants.BlogSearchApiUrl.BLOG_SEARCH;
import static com.example.search.constants.BlogSearchApiUrl.LOCAL_HOST;

import com.example.search.blogSearch.infrastructure.rest.dto.SearchResultDto;
import com.example.search.blogSearch.interfaces.rest.dto.BlogSearchResponseDto;
import org.springframework.stereotype.Service;

@Service
public class PagingHelper {

  public BlogSearchResponseDto pagingDto(SearchResultDto searchResultDto, Integer page,
      Integer size) {

    //총 페이지 수 구하기
    //1 - 50 사이의 값
    int totalPage = searchResultDto.getTotal_count() / size;
    int calcTotalPage = Math.min(totalPage, 50);

    //다음 페이지의 페이지 번호
    int nextPageNumber = page + 1;

    //현재페이지 url
    String firstPageUrl =
        LOCAL_HOST + BLOG_BASE_URL + API_V1 + BLOG_SEARCH + "?page=" + page + "&size=" + size;

    //다음페이지 url
    String nextPageUrl =
        LOCAL_HOST + BLOG_BASE_URL + API_V1 + BLOG_SEARCH + "?page=" + nextPageNumber + "&size="
            + size;

    //마지막페이지 url
    String lastPageUrl =
        LOCAL_HOST + BLOG_BASE_URL + API_V1 + BLOG_SEARCH + "?page=" + calcTotalPage + "&size="
            + size;

    return BlogSearchResponseDto.builder()
        .pageNumber(page)
        .pageSize(size)
        .currentPage(firstPageUrl)
        .nextPage(nextPageUrl)
        .lastPage(lastPageUrl)
        .totalPage(totalPage)
        .totalCount(searchResultDto.getTotal_count())
        .documents(searchResultDto.getDocuments())
        .build();
  }

}
