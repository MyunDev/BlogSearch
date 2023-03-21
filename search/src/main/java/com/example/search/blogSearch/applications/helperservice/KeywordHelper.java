package com.example.search.blogSearch.applications.helperservice;

import com.example.search.blogSearch.domain.exceptions.KeywordInfoNotExistException;
import com.example.search.blogSearch.domain.model.aggregate.Keyword;
import com.example.search.blogSearch.domain.repositories.KeywordRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KeywordHelper {

  private final KeywordRepository keywordRepository;

  public Keyword save(Keyword keyword) {
    return keywordRepository.save(keyword);
  }

  public Keyword saveByKeywordString(String keyword) {

    Keyword saveKey = Keyword.builder()
        .keyword(keyword)
        .regDate(LocalDateTime.now())
        .count(1)
        .build();
    keywordRepository.save(saveKey);
    return saveKey;
  }

  public Optional<Keyword> findByKeyword(String keyword) {
    return keywordRepository.findByKeyword(keyword);
  }

  public List<Keyword> findKeywordList(){
    return keywordRepository.findTop10ByOrderByCountDesc();
  }

}
