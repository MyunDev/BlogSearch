package com.example.search.blogSearch.interfaces.rest.dto;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class KeywordListResponseDto {

  List<KeywordResponse> keywordList;

  @Getter
  @Builder
  public static class KeywordResponse {

    private String keyword;
    private Integer count;
  }
}
