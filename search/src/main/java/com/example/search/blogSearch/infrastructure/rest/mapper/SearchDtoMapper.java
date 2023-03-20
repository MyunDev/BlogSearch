package com.example.search.blogSearch.infrastructure.rest.mapper;


import com.example.search.blogSearch.infrastructure.rest.dto.KaKaoSearchResultDto;
import com.example.search.blogSearch.infrastructure.rest.dto.NaverRequestDto;
import com.example.search.blogSearch.infrastructure.rest.dto.NaverSearchDto;
import com.example.search.blogSearch.infrastructure.rest.dto.SearchResultDto;
import com.example.search.config.MapStructConfig;
import com.example.search.libs.utils.DateMapperUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapStructConfig.class, uses = DateMapperUtil.class)
public abstract class SearchDtoMapper {

  @Mapping(source = "size", target = "display")
  @Mapping(source = "page", target = "start")
  @Mapping(target = "sort", expression = "java(getSort(result.getSort()))")
  public abstract NaverRequestDto toRequestDto(NaverSearchDto result);


  @Mapping(target = "total_count", source = "meta.total_count")
  @Mapping(target = "pageable_count", source = "meta.pageable_count")
  public abstract SearchResultDto toResponseDto(KaKaoSearchResultDto kaKaoSearchResultDto);

  public String getSort(String sort) {
    if (sort.equals("accuracy")) {
      return "sim";
    } else {
      return "date";
    }
  }
}
