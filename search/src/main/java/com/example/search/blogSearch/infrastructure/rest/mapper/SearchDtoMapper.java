package com.example.search.blogSearch.infrastructure.rest.mapper;


import com.example.search.blogSearch.infrastructure.rest.dto.KaKaoDocumentsDto;
import com.example.search.blogSearch.infrastructure.rest.dto.KaKaoSearchResultDto;
import com.example.search.blogSearch.infrastructure.rest.dto.NaverRequestDto;
import com.example.search.blogSearch.infrastructure.rest.dto.NaverResultDto;
import com.example.search.blogSearch.infrastructure.rest.dto.NaverResultItemDto;
import com.example.search.blogSearch.infrastructure.rest.dto.NaverSearchDto;
import com.example.search.blogSearch.infrastructure.rest.dto.SearchResultTestDto;
import com.example.search.blogSearch.interfaces.rest.dto.BlogSearchResponseDto;
import com.example.search.config.MapStructConfig;
import com.example.search.libs.utils.DateMapperUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(config = MapStructConfig.class, uses = DateMapperUtil.class)
public abstract class SearchDtoMapper {

  @Mapping(source = "size", target = "display")
  @Mapping(source = "page", target = "start")
  @Mapping(target = "sort", expression = "java(getSort(result.getSort()))")
  public abstract NaverRequestDto toRequestDto(NaverSearchDto result);


//  @Mapping(target = "contents", source = "contents")
//  @Mapping(target = "url", source = "url")
//  @Mapping(target = "blogname", source = "blogname")
//  @Mapping(target = "thumbnail", ignore = true)
//  @Mapping(target = "datetime", source = "datetime")
//  @Mapping(target = "title", source = "title")
//  public abstract SearchResultTestDto.Documents toDocuments(NaverResultItemDto naverResultItemDto);


//  public abstract SearchResultTestDto.Documents toDoc(NaverResultItemDto naverResultItemDto);
//  public abstract KaKaoDocumentsDto toDocumentsDtos(NaverResultItemDto naverResultItemDto);

//  @Mapping(target = "contents", source = "description")
//  @Mapping(target = "url", source = "link")
//  @Mapping(target = "blogname", source = "bloggername")
//  @Mapping(target = "thumbnail", ignore = true)
//  @Mapping(target = "datetime", source = "postdate")
//  public abstract KaKaoDocumentsDto toDocumentsTest(NaverResultItemDto naverResultItemDto);

//  @Mapping(target = "total_count", source = "total")
//  @Mapping(target = "pageable_count", ignore = true)
//  @Mapping(target = "documents", source = "items")
//  public abstract SearchResultTestDto toSearchResultTestDto(NaverResultDto naverResultDto);

  @Mapping(target = "total_count", source = "meta.total_count")
  @Mapping(target = "pageable_count", source = "meta.pageable_count")
  public abstract SearchResultTestDto toResponseDto(KaKaoSearchResultDto kaKaoSearchResultDto);

  public String getSort(String sort) {
    if (sort.equals("accuracy")) {
      return "sim";
    } else {
      return "date";
    }
  }
}
