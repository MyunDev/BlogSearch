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

//  @Getter
//  @NoArgsConstructor
//  public static class Items {
//
//    private String title; //블로그 포스트의 제목
//    private String link; //블로그 포스트의 URL
//
//    private String description; //블로그 포스트의 내용을 요약한 패시지 정보
//
//    private String bloggername; //블로그 포스트가 있는 블로그의 이름
//
//    private String bloggerlink; //블로그 포스트가 있는 블로그의 주소
//
//    private String postdate; //블로그 포스트가 작성된 날짜
//
//  }
}
