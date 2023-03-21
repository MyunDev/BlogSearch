package com.example.search.config.feign;

import static com.example.search.libs.utils.RequestScopeUtil.ACCEPT;
import static com.example.search.libs.utils.RequestScopeUtil.CALL_KEY;
import static com.example.search.libs.utils.RequestScopeUtil.CALL_VAL;
import static com.example.search.libs.utils.RequestScopeUtil.CONTENT_TYPE;

import feign.codec.ErrorDecoder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import feign.RequestInterceptor;

@Configuration
public class OpenFeignConfig {

  @Bean
  public RequestInterceptor requestInterceptor() {
    return requestTemplate -> {
      requestTemplate.header(CALL_KEY, CALL_VAL);  //header에 Caller Domain 정보를 넣어서 REST API 호출
      requestTemplate.header(CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
      requestTemplate.header(ACCEPT, MediaType.APPLICATION_JSON_VALUE);
    };
  }

  @Bean
  @ConditionalOnMissingBean(value = ErrorDecoder.class)
  public DefaultClientErrorDecoder commonFeignErrorDecoder() {
    return new DefaultClientErrorDecoder();
  }

}
