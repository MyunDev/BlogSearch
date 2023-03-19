package com.example.search.blogSearch.infrastructure.rest.feign;

import static com.example.search.constants.BlogSearchApiUrl.ENDPOINT_KAKAO_URL;

import com.example.search.blogSearch.domain.service.dto.SearchResultDto;
import com.example.search.blogSearch.infrastructure.rest.dto.KakaoSearchResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import com.example.search.libs.utils.RequestScopeUtil;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "SearchKakaoFeignClient", url = ENDPOINT_KAKAO_URL)
public interface SearchKakaoFeignClient {


  /**
   * 카카오 블로그 검색하기 API 호출하기
   * @param authorization
   * @param query
   * @param sort
   * @param page
   * @param size
   * @return
   */
  @GetMapping("/v2/search/blog")
  SearchResultDto getSearchResult(
      @RequestHeader(RequestScopeUtil.AUTHORIZATION) String authorization,
      @RequestParam("query") String query,
      @RequestParam("sort") String sort,
      @RequestParam("page") Integer page,
      @RequestParam("size") Integer size);

}
