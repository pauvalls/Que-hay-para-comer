package com.lookiero.appname.domain.error;

import com.lookiero.common.requestresponse.error.ErrorCode;
import lombok.Getter;

@Getter
public enum Errors implements ErrorCode {

  NOT_FOUND_ERROR("D-0001", "Not found error");

  private final String code;
  private final String message;

  Errors(final String code, final String message) {
    this.code = code;
    this.message = message;
  }
}
