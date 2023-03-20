package com.example.search.blogSearch.infrastructure.rest.mapper;

import com.example.search.blogSearch.infrastructure.rest.dto.KaKaoSearchDocumentDto;
import com.example.search.blogSearch.infrastructure.rest.dto.NaverResultItemDto;
import com.example.search.blogSearch.infrastructure.rest.dto.SearchResultDto;
import com.example.search.config.MapStructConfig;
import com.example.search.libs.utils.DateMapperUtil;
import org.mapstruct.Mapper;

@Mapper(config = MapStructConfig.class, uses = DateMapperUtil.class)
public abstract class ResultDtoMapper {

  public abstract SearchResultDto.Documents toDocuments(NaverResultItemDto naverResultItemDto);


  public abstract SearchResultDto.Documents toDocuments(
      KaKaoSearchDocumentDto kaKaoSearchDocumentDto);
}
