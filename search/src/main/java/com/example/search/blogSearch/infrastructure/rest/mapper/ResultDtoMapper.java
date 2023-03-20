package com.example.search.blogSearch.infrastructure.rest.mapper;

import com.example.search.blogSearch.infrastructure.rest.dto.NaverResultItemDto;
import com.example.search.blogSearch.infrastructure.rest.dto.SearchResultTestDto;
import com.example.search.config.MapStructConfig;
import com.example.search.libs.utils.DateMapperUtil;
import org.mapstruct.Mapper;

@Mapper(config = MapStructConfig.class, uses = DateMapperUtil.class)
public abstract class ResultDtoMapper {

  public abstract SearchResultTestDto.Documents toDocuments(NaverResultItemDto naverResultItemDto);
}
