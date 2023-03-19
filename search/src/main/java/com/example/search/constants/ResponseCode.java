package com.example.search.constants;

import com.google.common.collect.ImmutableMap;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ResponseCode {

  INVALID_RESPONSE("9999", "요청이 처리 되지 않았습니다.", HttpStatus.INTERNAL_SERVER_ERROR),

  /**
   * 공통
   */
  SUCCESS("0000", "정상 처리되었습니다.", HttpStatus.OK),
  NO_SESSION("0001", "SESSION 정보가 없습니다.", HttpStatus.UNAUTHORIZED),
  INVALID_PARAMETER("0003", "요청 파라미터의 값이 잘못되었습니다.", HttpStatus.BAD_REQUEST),
  INVALID_REQUEST("0005", "잘못된 요청입니다.", HttpStatus.BAD_REQUEST),
  DEFAULT_FEIGN_EXCEPTION("0006", "외부 API 호출 중 에러가 발생했습니다.",
      HttpStatus.INTERNAL_SERVER_ERROR),

  SERVER_ERROR( "0099", "서비스 접속이 원활하지 않습니다. 잠시 후 다시 이용해주세요.",
      HttpStatus.INTERNAL_SERVER_ERROR),

  INVALID_SOURCE_TYPE("0010", "잘못된 검색 서비스 타입입니다.",
      HttpStatus.BAD_REQUEST),
  NO_DATA("0009", "조회된 데이터가 없습니다.", HttpStatus.NOT_FOUND);

  private final String responseCode;
  private final String message;
  private final HttpStatus httpStatus;

  private static final ImmutableMap<String, ResponseCode> codes = ImmutableMap.copyOf(
      Stream.of(values())
          .collect(Collectors.toMap(ResponseCode::getResponseCode, Function.identity())));

  ResponseCode(String responseCode,
      String message, HttpStatus httpStatus) {
    this.responseCode = responseCode;
    this.message = message;
    this.httpStatus = httpStatus;
  }

  public String getUrlEncodingMessage() {
    return URLEncoder.encode(this.message, StandardCharsets.UTF_8);
  }

  public static HttpStatus getHttpStatusFromResponseCode(String responseCode) {
    if (codes.get(responseCode) != null) {
      return codes.get(responseCode).getHttpStatus();
    } else {
      return HttpStatus.INTERNAL_SERVER_ERROR;
    }
  }

  public static ResponseCode getResponseCode(String responseCode) {
    if (codes.get(responseCode) != null) {
      return codes.get(responseCode);
    } else {
      return INVALID_RESPONSE;
    }
  }

}
