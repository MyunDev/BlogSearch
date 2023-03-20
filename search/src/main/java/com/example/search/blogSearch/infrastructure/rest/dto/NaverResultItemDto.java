package com.example.search.blogSearch.infrastructure.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import org.mapstruct.Mapping;

@Getter
@Builder
public class NaverResultItemDto {

  @JsonProperty("title")
  private String title; //블로그 포스트의 제목
  @JsonProperty("link")
  private String url; //블로그 포스트의 URL


  @JsonProperty("description")
  private String contents; //블로그 포스트의 내용을 요약한 패시지 정보

  @JsonProperty("bloggername")
  private String blogname; //블로그 포스트가 있는 블로그의 이름

  @JsonProperty("bloggerlink")
  private String thumbnail; //블로그 포스트가 있는 블로그의 주소

  @JsonProperty("postdate")
  private String datetime; //블로그 포스트가 작성된 날짜

}