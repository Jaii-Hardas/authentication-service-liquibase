package org.dnyanyog.dto;

import org.springframework.stereotype.Component;

// @JsonInclude(JsonInclude.Include.NON_NULL)
@Component
public class UserData {

  private String username;
  private String password;
  private String email;
  private String age;
  private long user_id;

  public long getUser_id() {
    return user_id;
  }

  public void setUser_id(long user_id) {
    this.user_id = user_id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }
}
