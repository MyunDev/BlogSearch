package com.example.search.blogSearch.interfaces.rest.mapper;

import static com.example.search.constants.BlogSearchApiUrl.API_V1;
import static com.example.search.constants.BlogSearchApiUrl.BLOG_BASE_URL;
import static com.example.search.constants.BlogSearchApiUrl.BLOG_SEARCH;
import static com.example.search.constants.BlogSearchApiUrl.LOCAL_HOST;

import com.example.search.blogSearch.domain.service.dto.SearchResultDto;
import com.example.search.blogSearch.interfaces.rest.dto.BlogSearchResponseDto;
import com.example.search.config.MapStructConfig;
import com.example.search.libs.utils.DateMapperUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapStructConfig.class, uses = DateMapperUtil.class)
public abstract class BlogSearchMapper {

//  @Mapping(target = "pageableCount", source = "meta.pageable_count")
//  @Mapping(target = "totalCount", source = "meta.total_count")
//  public abstract BlogSearchResponseDto toResponseDto
//      (SearchResultDto result);


  public BlogSearchResponseDto toSearchResponseDto(SearchResultDto searchResultDto, Integer page, Integer size, Integer totalPage){
    return BlogSearchResponseDto.builder()
        .pageNumber(page)
        .pageSize(size)
        .firstPage(LOCAL_HOST + BLOG_BASE_URL + API_V1 + BLOG_SEARCH)
        .nextPage(LOCAL_HOST + BLOG_BASE_URL + API_V1 + BLOG_SEARCH)
        .lastPage(LOCAL_HOST + BLOG_BASE_URL + API_V1 + BLOG_SEARCH)
        .totalPage(totalPage)
        .totalCount(searchResultDto.getMeta().getTotal_count())
        .pageableCount(searchResultDto.getMeta().getPageable_count())
        .documents(searchResultDto.getDocuments())
        .build();
  }
}
