package com.example.search.blogSearch.domain.service;

import com.example.search.blogSearch.constants.SearchSourceType;
import com.example.search.blogSearch.infrastructure.rest.dto.NaverRequestDto;
import com.example.search.blogSearch.infrastructure.rest.dto.NaverResultDto;
import com.example.search.blogSearch.infrastructure.rest.dto.NaverSearchDto;
import com.example.search.blogSearch.infrastructure.rest.dto.SearchResultTestDto;
import com.example.search.blogSearch.infrastructure.rest.feign.SearchNaverFeignClient;
import com.example.search.blogSearch.infrastructure.rest.mapper.ResultDtoMapper;
import com.example.search.blogSearch.infrastructure.rest.mapper.SearchDtoMapper;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class NaverSearchService implements SearchService<NaverSearchDto> {

  private final SearchNaverFeignClient searchNaverFeignClient;

  private final SearchDtoMapper searchDtoMapper;

  private final ResultDtoMapper resultDtoMapper;

  private final String naverClientId = "W4ltIYBe53CA8UymY6Ge";

  private final String naverClientSecret = "fNctmFMBfq";

  @Override
  public SearchSourceType getSearchSourceType() {
    return SearchSourceType.NAVER_SOURCE;
  }

  @Override
  public SearchResultTestDto search(NaverSearchDto naverSearchDto) {

    //네이버 형식으로 Request Mapping
    NaverRequestDto naverRequestDto = searchDtoMapper.toRequestDto(naverSearchDto);

    NaverResultDto naverResultDto = searchNaverFeignClient.getSearchResult(naverClientId,
        naverClientSecret,
        naverRequestDto.getQuery(), naverRequestDto.getDisplay(), naverRequestDto.getStart(),
        naverRequestDto.getSort());

    //NaverResultDto --> SearchResultTestDto 로 매핑 필요
    //naver 검색결과의 item 들을 documents로 mapping 한다.
//    naverResultDto.getItems().stream().map(searchDtoMapper::toDocuments);

    List<SearchResultTestDto.Documents> documentsList =
        naverResultDto.getItems().stream()
            .map(resultDtoMapper::toDocuments)
            .collect(Collectors.toList());

    System.out.println("naver ==============" + documentsList.get(0).getUrl());

    SearchResultTestDto searchResultTestDto = SearchResultTestDto.builder()
        .total_count(naverResultDto.getTotal())
        .pageable_count(null)
        .documents(naverResultDto.getItems().stream().map(resultDtoMapper::toDocuments).collect(
            Collectors.toList()))
        .build();

//    System.out.println(
//        "-------------------" + searchResultTestDto.getDocuments().get(0).getBlogname());
    return searchResultTestDto;
  }

}