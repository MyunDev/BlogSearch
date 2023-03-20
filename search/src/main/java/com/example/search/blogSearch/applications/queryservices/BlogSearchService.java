package com.example.search.blogSearch.applications.queryservices;


import com.example.search.blogSearch.applications.helperservice.PagingHelper;
import com.example.search.blogSearch.constants.SearchSourceType;
import com.example.search.blogSearch.domain.factory.SearchServiceFactory;
import com.example.search.blogSearch.domain.service.SearchService;
import com.example.search.blogSearch.infrastructure.rest.dto.SearchDto;
import com.example.search.blogSearch.infrastructure.rest.dto.SearchDtoFactory;
import com.example.search.blogSearch.infrastructure.rest.dto.SearchResultTestDto;
import com.example.search.blogSearch.interfaces.rest.dto.BlogSearchRequestDto;
import com.example.search.blogSearch.interfaces.rest.dto.BlogSearchResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlogSearchService {
  private final PagingHelper pagingHelper;

  Integer totalPage = 10;

  private final SearchServiceFactory searchServiceFactory;

  public BlogSearchResponseDto getSearchResult(BlogSearchRequestDto blogSearchRequestDto,
      Integer page, Integer size) {

    SearchSourceType sourceType = SearchSourceType.findByCode(blogSearchRequestDto.getSource());
    final SearchDto searchDto = SearchDtoFactory.create(sourceType, blogSearchRequestDto.getQuery(),
        blogSearchRequestDto.getSort(), page, size);

    SearchService searchService = searchServiceFactory.find(sourceType);
    SearchResultTestDto searchResultDto = searchService.search(searchDto);

    return  pagingHelper.pagingDto(searchResultDto, page, size);

  }

}
