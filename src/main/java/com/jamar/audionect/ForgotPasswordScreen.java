package com.jamar.audionect;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class ForgotPasswordScreen extends AppCompatActivity {
  private Button back;
  
  private FirebaseFirestore db = FirebaseFirestore.getInstance();
  
  private Button done;
  
  private EditText email;
  
  private String emailLine;
  
  private String[] letters = new String[] { 
      "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", 
      "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", 
      "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", 
      "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", 
      "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", 
      "Y", "Z" };
  
  private String phoneLine;
  
  private EditText phoneNumber;
  
  private String[] punctuation = new String[] { 
      ".", ",", "'", "/", "\\", "!", "@", "#", "$", "%", 
      "^", "&", "*", "(", ")", "_", "=", "+", "<", ">", 
      "`", "~", "?", "-", "|", "[", "]", "{", "}", ":", 
      ";" };
  
  private ScrollView scrollView;
  
  private EditText securityKey;
  
  private SharedPreferences sharedPreferences;
  
  private TextView text1;
  
  private TextView text2;
  
  private TextView title;
  
  private CollectionReference user_auth_collection = this.db.collection("Users");
  
  private String removePunctuation(String paramString) {
    byte b3;
    String str;
    byte b1 = 0;
    byte b2 = 0;
    while (true) {
      String[] arrayOfString = this.punctuation;
      b3 = b1;
      str = paramString;
      if (b2 < arrayOfString.length) {
        str = paramString;
        if (paramString.contains(arrayOfString[b2]))
          str = paramString.replace(this.punctuation[b2], ""); 
        b2++;
        paramString = str;
        continue;
      } 
      break;
    } 
    while (true) {
      String[] arrayOfString = this.letters;
      if (b3 < arrayOfString.length) {
        paramString = str;
        if (str.contains(arrayOfString[b3]))
          paramString = str.replace(this.letters[b3], ""); 
        b3++;
        str = paramString;
        continue;
      } 
      return str.replace("\\s+", "").replace(" ", "").trim();
    } 
  }
  
  private String searchForAccount(String paramString1, final String phoneNum, final String keyWord) {
    final String[] userId = new String[1];
    arrayOfString1[0] = "";
    final String[] category = new String[1];
    arrayOfString2[0] = "";
    this.user_auth_collection.whereEqualTo("email", paramString1).addSnapshotListener(new EventListener<QuerySnapshot>() {
          public void onEvent(QuerySnapshot param1QuerySnapshot, FirebaseFirestoreException param1FirebaseFirestoreException) {
            if (param1FirebaseFirestoreException != null) {
              param1FirebaseFirestoreException.printStackTrace();
            } else if (!param1QuerySnapshot.isEmpty()) {
              for (QueryDocumentSnapshot queryDocumentSnapshot : param1QuerySnapshot) {
                if (queryDocumentSnapshot.getString("phoneNumber").equals(phoneNum) && queryDocumentSnapshot.getString("securityKey").equals(keyWord)) {
                  userId[0] = queryDocumentSnapshot.getString("userId");
                  category[0] = queryDocumentSnapshot.getString("category");
                } 
              } 
            } 
          }
        });
    paramString1 = arrayOfString1[0];
    phoneNum = arrayOfString2[0];
    if (paramString1 != null && !paramString1.equals("")) {
      this.sharedPreferences.edit().putString("currentUser", paramString1).putString("userCategory", phoneNum).apply();
      return "true";
    } 
    return "false";
  }
  
  private void setColor() {
    boolean bool = this.sharedPreferences.getString("darkMode", "false").equals("false");
    byte b = -1;
    if (bool) {
      String str = this.sharedPreferences.getString("colorSelect", "");
      switch (str.hashCode()) {
        case 98619139:
          if (str.equals("green"))
            b = 0; 
          break;
        case 94011702:
          if (str.equals("brown"))
            b = 6; 
          break;
        case 93819586:
          if (str.equals("blaze"))
            b = 10; 
          break;
        case 93618148:
          if (str.equals("beige"))
            b = 14; 
          break;
        case 3441014:
          if (str.equals("pink"))
            b = 13; 
          break;
        case 3181155:
          if (str.equals("gray"))
            b = 5; 
          break;
        case 3178592:
          if (str.equals("gold"))
            b = 2; 
          break;
        case 3027034:
          if (str.equals("blue"))
            b = 4; 
          break;
        case 112785:
          if (str.equals("red"))
            b = 9; 
          break;
        case -267278044:
          if (str.equals("light blue"))
            b = 3; 
          break;
        case -734239628:
          if (str.equals("yellow"))
            b = 1; 
          break;
        case -816343937:
          if (str.equals("violet"))
            b = 12; 
          break;
        case -909707666:
          if (str.equals("salmon"))
            b = 8; 
          break;
        case -976943172:
          if (str.equals("purple"))
            b = 11; 
          break;
        case -1008851410:
          if (str.equals("orange"))
            b = 7; 
          break;
      } 
      switch (b) {
        default:
          return;
        case 14:
          this.scrollView.setBackgroundResource(2131230815);
        case 13:
          this.scrollView.setBackgroundResource(2131230897);
        case 12:
          this.scrollView.setBackgroundResource(2131230910);
        case 11:
          this.scrollView.setBackgroundResource(2131230902);
        case 10:
          this.scrollView.setBackgroundResource(2131230816);
        case 9:
          this.scrollView.setBackgroundResource(2131230903);
        case 8:
          this.scrollView.setBackgroundResource(2131230904);
        case 7:
          this.scrollView.setBackgroundResource(2131230895);
        case 6:
          this.scrollView.setBackgroundResource(2131230823);
        case 5:
          this.scrollView.setBackgroundResource(2131230867);
        case 4:
          this.scrollView.setBackgroundResource(2131230818);
        case 3:
          this.scrollView.setBackgroundResource(2131230877);
        case 2:
          this.scrollView.setBackgroundResource(2131230864);
        case 1:
          this.scrollView.setBackgroundResource(2131230879);
        case 0:
          break;
      } 
      this.scrollView.setBackgroundResource(2131230878);
    } 
    this.scrollView.setBackgroundResource(2131230855);
    this.email.setHintTextColor(-256);
    this.email.setTextColor(-1);
    this.phoneNumber.setHintTextColor(-256);
    this.phoneNumber.setTextColor(-1);
    this.securityKey.setHintTextColor(-256);
    this.securityKey.setTextColor(-1);
    this.back.setTextColor(-1);
    this.back.setBackgroundResource(2131230854);
    this.done.setTextColor(-1);
    this.done.setBackgroundResource(2131230854);
    this.title.setTextColor(-1);
    this.text1.setTextColor(-1);
    this.text2.setTextColor(-1);
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2131492926);
    if (getSupportActionBar() != null)
      getSupportActionBar().setElevation(0.0F); 
    this.sharedPreferences = getSharedPreferences("com.jamar.sharedpreferences", 0);
    this.email = (EditText)findViewById(2131296457);
    this.phoneNumber = (EditText)findViewById(2131296458);
    this.securityKey = (EditText)findViewById(2131296460);
    this.scrollView = (ScrollView)findViewById(2131296459);
    this.back = (Button)findViewById(2131296455);
    this.done = (Button)findViewById(2131296456);
    this.title = (TextView)findViewById(2131296463);
    this.text1 = (TextView)findViewById(2131296461);
    this.text2 = (TextView)findViewById(2131296462);
    setColor();
  }
  
  public void onForgotPasswordBackClicked(View paramView) {
    startActivity(new Intent((Context)this, LogInScreen.class));
    finish();
  }
  
  public void onForgotPasswordDoneClicked(View paramView) {
    this.emailLine = this.email.getText().toString().trim();
    String str2 = this.phoneNumber.getText().toString().trim();
    String str1 = this.securityKey.getText().toString().trim().toLowerCase();
    this.phoneLine = removePunctuation(str2);
    str2 = this.emailLine;
    if (str2 != null && !str2.equals("")) {
      str2 = this.phoneLine;
      if (str2 != null && !str2.equals("") && str1 != null && !str1.equals(""))
        if (searchForAccount(this.emailLine, this.phoneLine, str1).equals("true")) {
          startActivity(new Intent((Context)this, ChangePasswordScreen.class));
          finish();
        } else {
          Toast.makeText((Context)this, 2131689510, 1).show();
        }  
    } 
  }
}
