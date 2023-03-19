package com.example.search.blogSearch.domain.factory;

import com.example.search.blogSearch.constants.SearchSourceType;
import com.example.search.blogSearch.domain.service.SearchService;
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SearchServiceFactory {

  private final Map<SearchSourceType, SearchService> services;

  @Autowired
  public SearchServiceFactory(Set<SearchService> managersSet) {
    this.services = Maps.newHashMap();
    managersSet.forEach(manager -> {
      if (manager.getSearchSourceType() == SearchSourceType.KAKAO_SOURCE) {
        services.put(manager.getSearchSourceType(), manager);
      } else {
        services.put(manager.getSearchSourceType(), manager);
      }
    });
  }

  public SearchService find(SearchSourceType type) {
    return services.get(type);
  }

}
