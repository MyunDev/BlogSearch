package com.example.search.blogSearch.interfaces.rest;

import static com.example.search.constants.BlogSearchApiUrl.API_V1;
import static com.example.search.constants.BlogSearchApiUrl.BLOG_BASE_URL;
import static com.example.search.constants.BlogSearchApiUrl.KEYWORD;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.search.blogSearch.applications.queryservices.KeywordListService;
import com.example.search.blogSearch.interfaces.rest.dto.KeywordListResponseDto;
import com.example.search.blogSearch.interfaces.rest.dto.KeywordListResponseDto.KeywordResponse;
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

@WebMvcTest(KeywordSumController.class)
class KeywordSumControllerTest {

  @Autowired
  protected MockMvc mvc;

  @Autowired
  protected ObjectMapper objectMapper;

  @MockBean
  protected KeywordListService keywordListService;

  @BeforeEach
  public void beforeEach(WebApplicationContext ctx) {
    this.mvc = MockMvcBuilders.webAppContextSetup(ctx)
        .addFilters(new SuccessResponseHeaderFilter())
        .alwaysDo(print())
        .build();
  }

  @Test
  @DisplayName("인기 검색어 목록 조햐 API 가 정상적으로 응답한 경우")
  void getKeywordList_success() throws Exception {


    //given
    KeywordListResponseDto.KeywordResponse keywordResponse = KeywordListResponseDto.KeywordResponse.builder()
        .keyword("카카오뱅크")
        .count(300)
        .build();

    List<KeywordResponse> keywordResponses = new ArrayList<>();
    keywordResponses.add(keywordResponse);

    KeywordListResponseDto keywordListResponseDto = KeywordListResponseDto.builder()
        .keywordList(keywordResponses)
        .build();


    //when
    given(keywordListService.getKeywordList()).willReturn(keywordListResponseDto);


    //then
    mvc.perform(get(BLOG_BASE_URL + API_V1 + KEYWORD)
        .accept(MediaType.APPLICATION_JSON)
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(keywordListResponseDto))
    ).andExpect(status().isOk());

  }
}