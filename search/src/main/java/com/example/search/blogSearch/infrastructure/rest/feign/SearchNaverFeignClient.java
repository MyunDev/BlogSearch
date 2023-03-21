package com.example.search.blogSearch.infrastructure.rest.feign;


import static com.example.search.constants.BlogSearchApiUrl.ENDPOINT_NAVER_URL;
import static com.example.search.libs.utils.RequestScopeUtil.NAVER_CLIENT_ID;
import static com.example.search.libs.utils.RequestScopeUtil.NAVER_CLIENT_SECRET;

import com.example.search.blogSearch.infrastructure.rest.dto.NaverResultDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "SearchNaverFeignClient", url = ENDPOINT_NAVER_URL)
public interface SearchNaverFeignClient {

  /**
   *
   * @param naverClientId
   * @param naverClientSecret
   * @param query
   * @param display
   * @param start
   * @param sort
   * @return
   */
  @GetMapping("/v1/search/blog.json")
  NaverResultDto getSearchResult(
      @RequestHeader(NAVER_CLIENT_ID) String naverClientId,
      @RequestHeader(NAVER_CLIENT_SECRET) String naverClientSecret,
      @RequestParam("query") String query,
      @RequestParam("display") Integer display,
      @RequestParam("start") Integer start,
      @RequestParam("sort") String sort);

}
