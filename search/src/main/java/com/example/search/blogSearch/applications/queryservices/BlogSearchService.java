package com.example.search.blogSearch.applications.queryservices;


import com.example.search.blogSearch.constants.SearchSourceType;
import com.example.search.blogSearch.domain.factory.SearchServiceFactory;
import com.example.search.blogSearch.domain.service.SearchService;
import com.example.search.blogSearch.domain.service.dto.SearchDto;
import com.example.search.blogSearch.domain.service.dto.SearchDtoFactory;
import com.example.search.blogSearch.domain.service.dto.SearchResultDto;
import com.example.search.blogSearch.interfaces.rest.dto.BlogSearchRequestDto;
import com.example.search.blogSearch.interfaces.rest.dto.BlogSearchResponseDto;
import com.example.search.blogSearch.interfaces.rest.mapper.BlogSearchMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlogSearchService {

  private final BlogSearchMapper blogSearchMapper;

  Integer totalPage = 10;

  private final SearchServiceFactory searchServiceFactory;

  public BlogSearchResponseDto getSearchResult(BlogSearchRequestDto blogSearchRequestDto,
      Integer page, Integer size) {

    SearchSourceType sourceType = SearchSourceType.findByCode(blogSearchRequestDto.getSource());
    final SearchDto searchDto = SearchDtoFactory.create(sourceType, blogSearchRequestDto.getQuery(),
        blogSearchRequestDto.getSort(), page, size);

    SearchService searchService = searchServiceFactory.find(SearchSourceType.KAKAO_SOURCE);
    SearchResultDto searchResultDto = searchService.search(searchDto);

    return blogSearchMapper.toSearchResponseDto(searchResultDto, page, size, totalPage);

  }

}
