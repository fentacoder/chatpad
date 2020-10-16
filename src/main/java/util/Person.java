package util;

import android.app.Application;

public class Person extends Application {
  private static Person instance;
  
  private String chatUsersList;
  
  private String lat;
  
  private String lng;
  
  private String person_age;
  
  private String person_bio;
  
  private String person_category;
  
  private String person_city;
  
  private String person_email;
  
  private String person_name;
  
  private String person_password;
  
  private String person_pictures_list;
  
  private String person_userId;
  
  private String person_username;
  
  private String phoneNumber;
  
  private String showMe;
  
  private String swipeLeftList;
  
  private String swipeRightList;
  
  private String urlList;
  
  public Person() {}
  
  public Person(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18) {
    this.showMe = paramString1;
    this.person_name = paramString2;
    this.person_age = paramString3;
    this.person_city = paramString4;
    this.person_category = paramString5;
    this.person_bio = paramString6;
    this.person_username = paramString7;
    this.person_email = paramString8;
    this.person_password = paramString9;
    this.person_userId = paramString10;
    this.person_pictures_list = paramString11;
    this.urlList = paramString12;
    this.lat = paramString13;
    this.lng = paramString14;
    this.swipeRightList = paramString15;
    this.swipeLeftList = paramString16;
    this.phoneNumber = paramString17;
    this.chatUsersList = paramString18;
  }
  
  public static Person getInstance() {
    // Byte code:
    //   0: ldc util/Person
    //   2: monitorenter
    //   3: getstatic util/Person.instance : Lutil/Person;
    //   6: ifnonnull -> 21
    //   9: new util/Person
    //   12: astore_0
    //   13: aload_0
    //   14: invokespecial <init> : ()V
    //   17: aload_0
    //   18: putstatic util/Person.instance : Lutil/Person;
    //   21: getstatic util/Person.instance : Lutil/Person;
    //   24: astore_0
    //   25: ldc util/Person
    //   27: monitorexit
    //   28: aload_0
    //   29: areturn
    //   30: astore_0
    //   31: ldc util/Person
    //   33: monitorexit
    //   34: aload_0
    //   35: athrow
    // Exception table:
    //   from	to	target	type
    //   3	21	30	finally
    //   21	25	30	finally
  }
  
  public String getChatUsersList() {
    return this.chatUsersList;
  }
  
  public String getLat() {
    return this.lat;
  }
  
  public String getLng() {
    return this.lng;
  }
  
  public String getPerson_age() {
    return this.person_age;
  }
  
  public String getPerson_bio() {
    return this.person_bio;
  }
  
  public String getPerson_category() {
    return this.person_category;
  }
  
  public String getPerson_city() {
    return this.person_city;
  }
  
  public String getPerson_email() {
    return this.person_email;
  }
  
  public String getPerson_name() {
    return this.person_name;
  }
  
  public String getPerson_password() {
    return this.person_password;
  }
  
  public String getPerson_pictures_list() {
    return this.person_pictures_list;
  }
  
  public String getPerson_userId() {
    return this.person_userId;
  }
  
  public String getPerson_username() {
    return this.person_username;
  }
  
  public String getPhoneNumber() {
    return this.phoneNumber;
  }
  
  public String getShowMe() {
    return this.showMe;
  }
  
  public String getSwipeLeftList() {
    return this.swipeLeftList;
  }
  
  public String getSwipeRightList() {
    return this.swipeRightList;
  }
  
  public String getUrlList() {
    return this.urlList;
  }
  
  public void setChatUsersList(String paramString) {
    this.chatUsersList = paramString;
  }
  
  public void setLat(String paramString) {
    this.lat = paramString;
  }
  
  public void setLng(String paramString) {
    this.lng = paramString;
  }
  
  public void setPerson_age(String paramString) {
    this.person_age = paramString;
  }
  
  public void setPerson_bio(String paramString) {
    this.person_bio = paramString;
  }
  
  public void setPerson_category(String paramString) {
    this.person_category = paramString;
  }
  
  public void setPerson_city(String paramString) {
    this.person_city = paramString;
  }
  
  public void setPerson_email(String paramString) {
    this.person_email = paramString;
  }
  
  public void setPerson_name(String paramString) {
    this.person_name = paramString;
  }
  
  public void setPerson_password(String paramString) {
    this.person_password = paramString;
  }
  
  public void setPerson_pictures_list(String paramString) {
    this.person_pictures_list = paramString;
  }
  
  public void setPerson_userId(String paramString) {
    this.person_userId = paramString;
  }
  
  public void setPerson_username(String paramString) {
    this.person_username = paramString;
  }
  
  public void setPhoneNumber(String paramString) {
    this.phoneNumber = paramString;
  }
  
  public void setShowMe(String paramString) {
    this.showMe = paramString;
  }
  
  public void setSwipeLeftList(String paramString) {
    this.swipeLeftList = paramString;
  }
  
  public void setSwipeRightList(String paramString) {
    this.swipeRightList = paramString;
  }
  
  public void setUrlList(String paramString) {
    this.urlList = paramString;
  }
}
