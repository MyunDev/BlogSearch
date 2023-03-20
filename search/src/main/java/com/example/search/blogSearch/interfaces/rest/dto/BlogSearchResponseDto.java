package com.example.search.blogSearch.interfaces.rest.dto;

import com.example.search.blogSearch.infrastructure.rest.dto.SearchResultDto;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
public class BlogSearchResponseDto {


  private Integer pageNumber; //현재 페이지 번호

  private Integer pageSize; //한 페이지에 보여질 데이터 수

  private String firstPage;

  private String nextPage;

  private String lastPage;

  private Integer totalPage; //총 페이지 수

  private Integer totalCount; //총 검색 된 데이터 수

//  private Integer pageableCount;

  private List<SearchResultDto.Documents> documents;

  @Getter
  @NoArgsConstructor
  public static class Documents {

    private String title; //블로그 글 제목
    private String contents; //블로그 글 요약

    private String url; //블로그 글 url

    private String blogname; //블로그의 이름

    private String thumbnail; //검색 시스템에서 추출한 대표 미리보기 이미지 URL, 미리보기 크기 및 화질은 변경될 수 있음

    private String datetime; //블로그 글 작성 시간

  }

}
