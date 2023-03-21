package com.example.search.exceptions;


import static com.example.search.constants.Constants.RESULT_CODE;
import static com.example.search.constants.Constants.RESULT_MESSAGE;

import feign.FeignException.FeignClientException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

  @org.springframework.web.bind.annotation.ExceptionHandler({ApiException.class})
  protected void handle(ApiException apiException, HttpServletRequest request,
      HttpServletResponse response) {

    final String COUPON_SUCCESS_RESULT_MESSAGE = URLEncoder
        .encode(apiException.getResultMessage(), StandardCharsets.UTF_8);

    response.setHeader(RESULT_CODE, apiException.getResultCode());
    response.setHeader(RESULT_MESSAGE, COUPON_SUCCESS_RESULT_MESSAGE);
    response.setStatus(apiException.getHttpStatus().value());
  }

  @org.springframework.web.bind.annotation.ExceptionHandler(BusinessException.class)
  protected void handle(BusinessException businessException, HttpServletResponse response) {

    final String COUPON_SUCCESS_RESULT_MESSAGE = URLEncoder
        .encode(businessException.getResultMessage(), StandardCharsets.UTF_8);

    response.setHeader(RESULT_CODE, businessException.getResultCode());
    response.setHeader(RESULT_MESSAGE, COUPON_SUCCESS_RESULT_MESSAGE);
    response.setStatus(businessException.getHttpStatus().value());
  }

}
