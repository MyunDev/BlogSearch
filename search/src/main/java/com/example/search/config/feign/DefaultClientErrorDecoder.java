package com.example.search.config.feign;

import com.example.search.blogSearch.domain.exceptions.DefaultFeignException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultClientErrorDecoder implements ErrorDecoder {

  @Override
  public Exception decode(String methodKey, Response response) {

    log.error("httpStatus={}, url={}, httpMethod={}",
        response.status(), response.request().url(), response.request().httpMethod());

    return new DefaultFeignException();

  }
}
