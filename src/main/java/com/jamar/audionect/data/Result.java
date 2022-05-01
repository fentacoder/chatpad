package com.jamar.audionect.data;

public class Result<T> {
  private Result() {}
  
  public String toString() {
    if (this instanceof Success) {
      Success<T> success = (Success)this;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Success[data=");
      stringBuilder.append(success.getData().toString());
      stringBuilder.append("]");
      return stringBuilder.toString();
    } 
    if (this instanceof Error) {
      Error error = (Error)this;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Error[exception=");
      stringBuilder.append(error.getError().toString());
      stringBuilder.append("]");
      return stringBuilder.toString();
    } 
    return "";
  }
  
  public static final class Error extends Result {
    private Exception error;
    
    public Error(Exception param1Exception) {
      this.error = param1Exception;
    }
    
    public Exception getError() {
      return this.error;
    }
  }
  
  public static final class Success<T> extends Result {
    private T data;
    
    public Success(T param1T) {
      this.data = param1T;
    }
    
    public T getData() {
      return this.data;
    }
  }
}
