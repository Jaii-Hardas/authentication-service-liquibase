package org.dnyanyog.common;

public enum ResponseCodes {
  LOGIN_SUCCESS("Success", "Login successful"),
  LOGIN_FAIL("Fail", "Login failed"),
  ADD_USER_SUCCESS("Success", "User added successfuly"),
  USER_FOUND_SUCCESS("Success", "User found"),
  USER_NOT_FOUND("Fail", "User not found");

  public final String status;
  public final String message;

  public String getStatus() {
    return status;
  }

  public String getMessage() {
    return message;
  }

  ResponseCodes(String status, String message) {
    this.message = message;
    this.status = status;
  }
}
