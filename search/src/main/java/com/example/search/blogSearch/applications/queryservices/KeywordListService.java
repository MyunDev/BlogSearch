package com.example.search.blogSearch.applications.queryservices;

import com.example.search.blogSearch.applications.helperservice.KeywordHelper;
import com.example.search.blogSearch.domain.model.aggregate.Keyword;
import com.example.search.blogSearch.interfaces.rest.dto.KeywordListResponseDto;
import com.example.search.blogSearch.interfaces.rest.mapper.KeywordMapper;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KeywordListService {

  private final KeywordHelper keywordHelper;

  private final KeywordMapper keywordMapper;

  public KeywordListResponseDto getKeywordList() {

    List<Keyword> keywordList = keywordHelper.findKeywordList();

    List<KeywordListResponseDto.KeywordResponse> resultList
        = keywordList.stream()
        .map(keywordMapper::toResponseDto)
        .collect(Collectors.toList());

    return KeywordListResponseDto.builder().keywordList(resultList).build();
  }

}
