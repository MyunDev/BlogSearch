package com.example.search.blogSearch.interfaces.rest.dto;

import com.example.search.blogSearch.infrastructure.rest.dto.SearchResultDto;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BlogSearchResponseDto {


  private Integer pageNumber; //현재 페이지 번호

  private Integer pageSize; //한 페이지에 보여질 데이터 수

  private String currentPage;

  private String nextPage;

  private String lastPage;

  private Integer totalPage; //총 페이지 수

  private Integer totalCount; //총 검색 된 데이터 수

//  private Integer pageableCount;

  private List<SearchResultDto.Documents> documents;

}
