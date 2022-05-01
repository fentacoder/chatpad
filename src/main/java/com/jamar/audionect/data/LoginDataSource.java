package com.jamar.audionect.data;

import com.jamar.audionect.data.model.LoggedInUser;
import java.io.IOException;
import java.util.UUID;

public class LoginDataSource {
  public Result<LoggedInUser> login(String paramString1, String paramString2) {
    try {
      LoggedInUser loggedInUser = new LoggedInUser();
      this(UUID.randomUUID().toString(), "Jane Doe");
      return new Result.Success<>(loggedInUser);
    } catch (Exception exception) {
      return new Result.Error(new IOException("Error logging in", exception));
    } 
  }
  
  public void logout() {}
}
