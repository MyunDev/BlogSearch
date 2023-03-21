package com.example.search.blogSearch.domain.service;

import static com.example.search.constants.Constants.NAVER_CLIENT_ID_KEY;
import static com.example.search.constants.Constants.NAVER_CLIENT_SECRET_KEY;

import com.example.search.blogSearch.constants.SearchSourceType;
import com.example.search.blogSearch.infrastructure.rest.dto.NaverRequestDto;
import com.example.search.blogSearch.infrastructure.rest.dto.NaverResultDto;
import com.example.search.blogSearch.infrastructure.rest.dto.NaverSearchDto;
import com.example.search.blogSearch.infrastructure.rest.dto.SearchResultDto;
import com.example.search.blogSearch.infrastructure.rest.feign.SearchNaverFeignClient;
import com.example.search.blogSearch.infrastructure.rest.mapper.ResultDtoMapper;
import com.example.search.blogSearch.infrastructure.rest.mapper.SearchDtoMapper;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class NaverSearchService implements SearchService<NaverSearchDto> {

  private final SearchNaverFeignClient searchNaverFeignClient;

  private final SearchDtoMapper searchDtoMapper;

  private final ResultDtoMapper resultDtoMapper;

  private final String naverClientId = "W4ltIYBe53CA8UymY6Ge";

  private final String naverClientSecret = "fNctmFMBfq";

  @Value(NAVER_CLIENT_ID_KEY)
  private String naverClientIdTest;

  @Value(NAVER_CLIENT_SECRET_KEY)
  public String naverClientSecretTest;

  @Override
  public SearchSourceType getSearchSourceType() {
    return SearchSourceType.NAVER_SOURCE;
  }

  @Override
  public SearchResultDto search(NaverSearchDto naverSearchDto) throws UnsupportedEncodingException {

    //네이버 형식으로 Request Mapping
    NaverRequestDto naverRequestDto = searchDtoMapper.toRequestDto(naverSearchDto);

    String encodedText = URLEncoder.encode(naverSearchDto.getQuery(), "UTF-8");

    NaverResultDto naverResultDto = searchNaverFeignClient.getSearchResult(naverClientIdTest,
        naverClientSecretTest,
        encodedText, naverRequestDto.getDisplay(), naverRequestDto.getStart(),
        naverRequestDto.getSort());

    return SearchResultDto.builder()
        .total_count(naverResultDto.getTotal())
        .pageable_count(null)
        .documents(naverResultDto.getItems().stream()
            .map(resultDtoMapper::toDocuments).collect(
                Collectors.toList()))
        .build();
  }

}