package com.example.search.blogSearch.interfaces.rest.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class KeywordResponseDto {

  private String keyword;

  private Integer count;

}
