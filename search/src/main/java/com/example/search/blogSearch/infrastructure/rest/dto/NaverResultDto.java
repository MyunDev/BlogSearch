package com.example.search.blogSearch.infrastructure.rest.dto;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
public class NaverResultDto {

  private String lastBuildDate;

  private Integer total; //총 검색 결과 개수

  private Integer start; //검색 시작 위치(기본값: 1, 최댓값: 1000)
  private Integer display; //한 번에 표시할 검색 결과 개수(기본값: 10, 최댓값: 100)

  @Getter
  private List<NaverResultItemDto> items;

}
