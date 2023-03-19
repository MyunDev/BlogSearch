package com.example.search.blogSearch.infrastructure.rest.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class KakaoSearchResponseDto {

  private MetaResponseDto meta;

  private List<Documents> documents;

  @Getter
  @NoArgsConstructor
  public static class Documents {

    private String title; //블로그 글 제목
    private String contents; //블로그 글 요약

    private String url; //블로그 글 url

    private String blogname; //블로그의 이름

    private String thumbnail; //검색 시스템에서 추출한 대표 미리보기 이미지 URL, 미리보기 크기 및 화질은 변경될 수 있음

    private LocalDateTime datetime; //블로그 글 작성 시간


  }

}
