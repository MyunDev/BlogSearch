package com.example.search.blogSearch.domain.exceptions;

import static com.example.search.constants.ResponseCode.NO_DATA;

import com.example.search.exceptions.BusinessException;

public class KeywordInfoNotExistException extends BusinessException {

  public KeywordInfoNotExistException() {
    super(NO_DATA);
  }
}
