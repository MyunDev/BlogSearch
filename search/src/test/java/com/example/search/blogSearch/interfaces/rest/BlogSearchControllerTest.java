package com.example.search.blogSearch.interfaces.rest;

import static com.example.search.constants.BlogSearchApiUrl.API_V1;
import static com.example.search.constants.BlogSearchApiUrl.BLOG_BASE_URL;
import static com.example.search.constants.BlogSearchApiUrl.BLOG_SEARCH;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.search.blogSearch.applications.queryservices.BlogSearchService;
import com.example.search.blogSearch.infrastructure.rest.dto.SearchResultDto;
import com.example.search.blogSearch.interfaces.rest.dto.BlogSearchRequestDto;
import com.example.search.blogSearch.interfaces.rest.dto.BlogSearchResponseDto;
import com.example.search.libs.filters.SuccessResponseHeaderFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@WebMvcTest(BlogSearchController.class)
class BlogSearchControllerTest {

  @Autowired
  protected MockMvc mvc;

  @Autowired
  protected ObjectMapper objectMapper;
  @MockBean
  protected BlogSearchService blogSearchService;

  @BeforeEach
  public void beforeEach(WebApplicationContext ctx) {
    this.mvc = MockMvcBuilders.webAppContextSetup(ctx)
        .addFilters(new SuccessResponseHeaderFilter())
        .alwaysDo(print())
        .build();
  }

  @Test
  @DisplayName("블로그 검색 API 가 정상적으로 응답한 경우")
  void getBlogSearchResult_success() throws Exception {

    //given
    BlogSearchRequestDto blogSearchRequestDto = BlogSearchRequestDto.builder()
        .query("키워드")
        .source("K")
        .sort("accuracy")
        .build();

    Integer page = 1;
    Integer size = 10;

    SearchResultDto.Documents documents = SearchResultDto.Documents.builder()
        .url("http://gyulnlove.tistory.com/461")
        .blogname("쉿  너만 있어")
        .contents(
            "<b>카카오</b><b>뱅크</b> 저금통 동전 모으기 결과 공개 안녕하세요! 여러분은 혹시 <b>카카오</b> <b>뱅크</b>를 사용하고 계신가요? 저는 은행에 갈 필요없는 <b>카카오</b><b>뱅크</b>로 진작 갈아탔습니다 . <b>카카오</b><b>뱅크</b>에 활용할수 있는 아이템들이 여러가지가 있는데요. 오늘은 저는 잔돈모으기를 하는 저금통에 관련된 이야기를 써보려고 합니다 . <b>카카오</b>...")
        .title("<b>카카오</b><b>뱅크</b> 저금통 동전 모으기 결과 공개")
        .thumbnail("")
        .datetime("2023-02-03T09:10:46.000+09:00")
        .build();

    List<SearchResultDto.Documents> documentsList = new ArrayList<>();
    documentsList.add(documents);

    BlogSearchResponseDto blogSearchResponseDto = BlogSearchResponseDto.builder()
        .totalCount(10)
        .totalPage(1)
        .nextPage("https://localhost:8080")
        .currentPage("https://localhost:8080")
        .lastPage("https://localhost:8080")
        .pageSize(size)
        .pageNumber(page)
        .documents(documentsList)
        .build();

    String body = objectMapper.writeValueAsString(
        blogSearchRequestDto
    );

    //when
    given(blogSearchService.getSearchResult(blogSearchRequestDto, page, size)).willReturn(
        blogSearchResponseDto);

    //then
    mvc.perform(post(BLOG_BASE_URL + API_V1 + BLOG_SEARCH)
        .param("page", String.valueOf(page))
        .param("size", String.valueOf(size))
        .content(body)
        .accept(MediaType.APPLICATION_JSON)
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(blogSearchResponseDto))
    ).andExpect(status().isOk());
  }

}