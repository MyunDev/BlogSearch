package com.example.search.blogSearch.domain.exceptions;

import static com.example.search.constants.ResponseCode.INVALID_SOURCE_TYPE;

import com.example.search.exceptions.BusinessException;

public class InvalidSearchSourceTypeException extends BusinessException {

  public InvalidSearchSourceTypeException() {
    super(INVALID_SOURCE_TYPE);
  }
}
