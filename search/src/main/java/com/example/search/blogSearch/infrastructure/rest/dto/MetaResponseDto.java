package com.example.search.blogSearch.infrastructure.rest.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MetaResponseDto {

  private Integer total_count; //검색된 문서 수

  private Integer pageable_count; //total_count 중 노출 가능 문서 수

  private boolean is_end; //현재 페이지가 마지막 페이지인지 여부, 값이 false면 page를 증가시켜 다음 페이지를 요청할 수 있음

}
