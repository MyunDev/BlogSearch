package com.example.search.blogSearch.applications.queryservices;


import com.example.search.blogSearch.applications.helperservice.KeywordHelper;
import com.example.search.blogSearch.applications.helperservice.PagingHelper;
import com.example.search.blogSearch.constants.SearchSourceType;
import com.example.search.blogSearch.domain.factory.SearchServiceFactory;
import com.example.search.blogSearch.domain.model.aggregate.Keyword;
import com.example.search.blogSearch.domain.service.SearchService;
import com.example.search.blogSearch.infrastructure.rest.dto.SearchDto;
import com.example.search.blogSearch.infrastructure.rest.dto.SearchDtoFactory;
import com.example.search.blogSearch.infrastructure.rest.dto.SearchResultDto;
import com.example.search.blogSearch.interfaces.rest.dto.BlogSearchRequestDto;
import com.example.search.blogSearch.interfaces.rest.dto.BlogSearchResponseDto;
import java.io.UnsupportedEncodingException;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class BlogSearchService {

  private final PagingHelper pagingHelper;

  private final KeywordHelper keywordHelper;

  Integer totalPage = 10;

  private final SearchServiceFactory searchServiceFactory;

  public BlogSearchResponseDto getSearchResult(BlogSearchRequestDto blogSearchRequestDto,
      Integer page, Integer size) throws UnsupportedEncodingException {

    SearchSourceType sourceType = SearchSourceType.findByCode(blogSearchRequestDto.getSource());
    final SearchDto searchDto = SearchDtoFactory.create(sourceType, blogSearchRequestDto.getQuery(),
        blogSearchRequestDto.getSort(), page, size);

    //serviceFactory를 사용하여 sourceType에 맞는 외부 연동 service를 불러옴
    SearchService searchService = searchServiceFactory.find(sourceType);
    SearchResultDto searchResultDto = searchService.search(searchDto);

    //검색어 키워드 DB 저장
    addKeywordCount(blogSearchRequestDto);

    return pagingHelper.pagingDto(searchResultDto, page, size);
  }

  private void addKeywordCount(BlogSearchRequestDto blogSearchRequestDto) {
    Optional<Keyword> keyword = keywordHelper.findByKeyword(blogSearchRequestDto.getQuery());

    //없다면 새로운 keyword Save
    if (keyword.isEmpty()) {
      keywordHelper.saveByKeywordString(blogSearchRequestDto.getQuery());
    }

    //있다면 keyword count증가
    keyword.ifPresent(Keyword::addCount);
  }

}
