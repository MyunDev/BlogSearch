package com.example.search.blogSearch.interfaces.rest.mapper;


import com.example.search.blogSearch.domain.model.aggregate.Keyword;
import com.example.search.blogSearch.interfaces.rest.dto.KeywordListResponseDto;
import com.example.search.blogSearch.interfaces.rest.dto.KeywordResponseDto;
import com.example.search.config.MapStructConfig;
import com.example.search.libs.utils.DateMapperUtil;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapStructConfig.class, uses = DateMapperUtil.class)
public abstract class KeywordMapper {


//  @Mapping(target = "keyword", source = "keyword")
//  public abstract KeywordResponseDto toResponseDto(Keyword keyword);

  public abstract KeywordListResponseDto.KeywordResponse toResponseDto(Keyword keyword);

//  public abstract KeywordListResponseDto. toResponseDto(List<Keyword> keyword);
}
