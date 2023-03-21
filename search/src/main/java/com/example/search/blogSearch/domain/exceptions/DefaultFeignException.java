package com.example.search.blogSearch.domain.exceptions;

import static com.example.search.constants.ResponseCode.DEFAULT_FEIGN_EXCEPTION;

import com.example.search.exceptions.BusinessException;

public class DefaultFeignException extends BusinessException {

  public DefaultFeignException() {
    super(DEFAULT_FEIGN_EXCEPTION);
  }
}
