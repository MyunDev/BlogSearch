package com.example.search.blogSearch.interfaces.rest.dto;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BlogSearchRequestDto {

  private String query; //검색 키워드
  private String source; //검색 소스 K(카카오), N(네이버)
  private String sort; //결과 문서 정렬 방식 정확도순 최신순

}
