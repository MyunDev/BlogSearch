package com.example.search.libs.filters;

import static com.example.search.constants.Constants.RESULT_CODE;
import static com.example.search.constants.Constants.RESULT_MESSAGE;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.example.search.constants.ResponseCode;
import org.springframework.web.filter.OncePerRequestFilter;

public class SuccessResponseHeaderFilter extends OncePerRequestFilter {

  //정상 처리에 대한 메시지
  private final String SUCCESS_RESULT_MESSAGE = ResponseCode.SUCCESS.getUrlEncodingMessage();

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {

    setResponseHeader(request, response);
    filterChain.doFilter(request, response);
  }

  private void setResponseHeader(HttpServletRequest request, HttpServletResponse response) {
    response.setHeader(RESULT_CODE, ResponseCode.SUCCESS.getResponseCode());
    response.setHeader(RESULT_MESSAGE, SUCCESS_RESULT_MESSAGE);
  }

}
