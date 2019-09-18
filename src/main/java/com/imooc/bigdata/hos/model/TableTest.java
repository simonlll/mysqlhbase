package com.imooc.bigdata.hos.model;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by jixin on 18-3-8.
 */
@Component
public class TableTest {

  private String userId;
  private String userName;

  public TableTest(String userId, String userName) {
    this.userId = userId;
    this.userName = userName;
  }

  public TableTest() {
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  @Override
  public String toString() {
    return "TableTest{" +
            "userId='" + userId + '\'' +
            ", userName='" + userName + '\'' +
            '}';
  }
}
