package com.example.search.libs.exceptions;

import com.example.search.constants.ResponseCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

public class BusinessException extends RuntimeException{

  @Getter
  private final String resultMessage;
  @Getter
  private final String resultCode;
  @Getter
  private final HttpStatus httpStatus;

  public BusinessException(String resultMessage, String resultCode, HttpStatus httpStatus) {
    super("[" + resultCode + "] " + resultMessage);
    this.resultMessage = resultMessage;
    this.resultCode = resultCode;
    this.httpStatus = httpStatus;
  }

  public BusinessException(final ResponseCode responseCode) {
    super("[" + responseCode.getResponseCode() + "] " + responseCode.getMessage());
    this.resultMessage = responseCode.getMessage();
    this.resultCode = responseCode.getResponseCode();
    this.httpStatus = responseCode.getHttpStatus();
  }

  public String resultCode() {
    return this.resultCode;
  }

  public String resultMessage() {
    return this.resultMessage;
  }

  public HttpStatus httpStatus() {
    return this.httpStatus;
  }

}
