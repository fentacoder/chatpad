package com.infotechnano.audionect.data;

import com.infotechnano.audionect.data.model.LoggedInUser;

public class LoginRepository {
  private static volatile LoginRepository instance;
  
  private LoginDataSource dataSource;
  
  private LoggedInUser user = null;
  
  private LoginRepository(LoginDataSource paramLoginDataSource) {
    this.dataSource = paramLoginDataSource;
  }
  
  public static LoginRepository getInstance(LoginDataSource paramLoginDataSource) {
    if (instance == null)
      instance = new LoginRepository(paramLoginDataSource); 
    return instance;
  }
  
  private void setLoggedInUser(LoggedInUser paramLoggedInUser) {
    this.user = paramLoggedInUser;
  }
  
  public boolean isLoggedIn() {
    boolean bool;
    if (this.user != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public Result<LoggedInUser> login(String paramString1, String paramString2) {
    Result<LoggedInUser> result = this.dataSource.login(paramString1, paramString2);
    if (result instanceof Result.Success)
      setLoggedInUser(((Result.Success<LoggedInUser>)result).getData()); 
    return result;
  }
  
  public void logout() {
    this.user = null;
    this.dataSource.logout();
  }
}
