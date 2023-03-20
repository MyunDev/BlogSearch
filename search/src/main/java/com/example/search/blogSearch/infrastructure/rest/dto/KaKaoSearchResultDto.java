package com.example.search.blogSearch.infrastructure.rest.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
@AllArgsConstructor
public class KaKaoSearchResultDto {

  private MetaResponseDto meta;

  private List<KaKaoSearchDocumentDto> documents;

}
