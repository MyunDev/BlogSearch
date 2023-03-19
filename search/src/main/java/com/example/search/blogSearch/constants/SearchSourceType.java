package com.example.search.blogSearch.constants;


import com.google.common.collect.ImmutableMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.Getter;

@Getter
public enum SearchSourceType {

  KAKAO_SOURCE("K", "카카오"),

  NAVER_SOURCE("N", "네이버");

  private final String code;
  private final String typeName;

  private static final ImmutableMap<String, SearchSourceType> types = ImmutableMap.copyOf(
      Stream.of(values())
          .collect(Collectors.toMap(SearchSourceType::getCode, Function.identity())));

  SearchSourceType(String code,
      String typeName) {
    this.code = code;
    this.typeName = typeName;
  }

}
