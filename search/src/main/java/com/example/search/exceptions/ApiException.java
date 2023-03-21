package com.example.search.exceptions;

import static com.example.search.constants.ResponseCode.SERVER_ERROR;

import com.example.search.constants.ResponseCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException{

  @Getter
  private final String resultCode;
  @Getter
  private final String resultMessage;
  @Getter
  private final HttpStatus httpStatus;
  @Getter
  private final transient Object body;

  public ApiException() {
    this(SERVER_ERROR);
  }

  public ApiException(ResponseCode responseCode) {
    super("[" + responseCode.getResponseCode() + "] " + responseCode.getMessage());
    this.resultCode = responseCode.getResponseCode();
    this.resultMessage = responseCode.getMessage();
    this.body = null;
    this.httpStatus = responseCode.getHttpStatus();
  }

  public ApiException(String resultCode, String resultMessage) {
    this.resultCode = resultCode;
    this.resultMessage = resultMessage;
    this.body = null;
    this.httpStatus = ResponseCode.getHttpStatusFromResponseCode(resultCode);
  }

  public ApiException(String resultCode, String resultMessage, HttpStatus httpStatus) {
    super("[" + resultCode + "] " + resultMessage);
    this.resultCode = resultCode;
    this.resultMessage = resultMessage;
    this.body = null;
    this.httpStatus = httpStatus;
  }

  public ApiException(String resultCode, String resultMessage, Object responseBody) {
    super("[" + resultCode + "] " + resultMessage);
    this.resultCode = resultCode;
    this.resultMessage = resultMessage;
    this.body = responseBody;
    this.httpStatus = ResponseCode.getHttpStatusFromResponseCode(resultCode);
  }

  public String resultCode() {
    return this.resultCode;
  }

  public String resultMessage() {
    return this.resultMessage;
  }

}
