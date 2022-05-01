package com.jamar.audionect.signUpProcess;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.jamar.audionect.LogInScreen;
import com.jamar.audionect.signUpProcessService;
import java.util.Calendar;

public class NameSignUp extends AppCompatActivity implements View.OnKeyListener, View.OnTouchListener, View.OnClickListener {
  private boolean activityCompleted;
  
  private String age;
  
  private Button backButton;
  
  private String birthday;
  
  private TextView birthdayTextView;
  
  private Button continueButton;
  
  private DatePickerDialog.OnDateSetListener dateSetListener;
  
  private FirebaseFirestore db = FirebaseFirestore.getInstance();
  
  private InputMethodManager inputMethodManager;
  
  private String name;
  
  private EditText nameEditText;
  
  private String nameReceiver;
  
  private ConstraintLayout nameSignUpLayout;
  
  private String nameUpperLetter;
  
  private String[] numberArray = new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
  
  private String[] numberFormat = new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09" };
  
  private SharedPreferences sharedPreferences;
  
  private String tempName;
  
  private String checkFirstLast(String paramString) {
    char[] arrayOfChar = paramString.toCharArray();
    byte b = 0;
    int i;
    for (i = 0; b < arrayOfChar.length; i = j) {
      int j = i;
      if (arrayOfChar[b] == ' ')
        j = i + 1; 
      b++;
    } 
    if (i == 0)
      paramString = ""; 
    return paramString;
  }
  
  private String checkFormatting() {
    if (!this.nameEditText.getText().toString().equals("") && !this.birthdayTextView.getText().toString().equals("")) {
      this.nameReceiver = this.nameEditText.getText().toString().trim();
      this.tempName = this.nameReceiver.replace("\\s+", " ");
      this.tempName = checkFirstLast(this.tempName);
      this.birthday = this.birthdayTextView.getText().toString().trim();
      if (this.tempName.equals("")) {
        Toast.makeText((Context)this, getString(2131689599), 0).show();
        return "";
      } 
      if (this.tempName.length() > 40) {
        Toast.makeText((Context)this, 2131689726, 1).show();
        return "";
      } 
      int i = 0;
      while (true) {
        String[] arrayOfString = this.numberArray;
        if (i < arrayOfString.length) {
          if (this.tempName.contains(arrayOfString[i])) {
            Toast.makeText((Context)this, 2131689643, 1).show();
            return "";
          } 
          i++;
          continue;
        } 
        i = Calendar.getInstance().get(1);
        if (Integer.parseInt(this.birthday.split("/")[2]) >= i - 17) {
          Toast.makeText((Context)this, 2131689594, 1).show();
          return "";
        } 
        this.age = String.valueOf(getAge(this.birthday));
        this.nameUpperLetter = this.tempName.substring(0, 1);
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(this.nameUpperLetter);
        stringBuilder1.append(this.tempName.substring(1));
        this.name = stringBuilder1.toString();
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(this.name);
        stringBuilder1.append("~");
        stringBuilder1.append(this.age);
        return stringBuilder1.toString();
      } 
    } 
    Toast.makeText((Context)this, 2131689716, 1).show();
    this.age = String.valueOf(getAge(this.birthday));
    this.nameUpperLetter = this.tempName.substring(0, 1);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.nameUpperLetter);
    stringBuilder.append(this.tempName.substring(1));
    this.name = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(this.name);
    stringBuilder.append("~");
    stringBuilder.append(this.age);
    return stringBuilder.toString();
  }
  
  private String checkNumFormat(String paramString) {
    byte b = 0;
    while (true) {
      String[] arrayOfString = this.numberFormat;
      if (b < arrayOfString.length) {
        if (paramString.equals(arrayOfString[b]))
          return paramString.substring(1); 
        b++;
        continue;
      } 
      return paramString;
    } 
  }
  
  private int getAge(String paramString) {
    String[] arrayOfString = paramString.split("/");
    int i = Integer.parseInt(checkNumFormat(arrayOfString[0]));
    int j = Integer.parseInt(checkNumFormat(arrayOfString[1]));
    int k = Integer.parseInt(arrayOfString[2]);
    Calendar calendar = Calendar.getInstance();
    int m = calendar.get(1);
    int n = calendar.get(2) + 1;
    int i1 = calendar.get(5);
    m -= k;
    if (n < i)
      return m - 1; 
    k = m;
    if (n == i) {
      k = m;
      if (i1 < j)
        k = m - 1; 
    } 
    return k;
  }
  
  public void onBackButtonClicked(View paramView) {
    startActivity(new Intent((Context)this, LogInScreen.class));
  }
  
  public void onBackPressed() {
    super.onBackPressed();
    Toast.makeText((Context)this, 2131689729, 0).show();
    startActivity(new Intent((Context)this, StartUpScreen.class));
    finish();
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() == 2131296571 || paramView.getId() == 2131296572 || paramView.getId() == 2131296569 || paramView.getId() == 2131296570) {
      this.inputMethodManager = (InputMethodManager)getSystemService("input_method");
      this.inputMethodManager.hideSoftInputFromWindow(this.nameEditText.getWindowToken(), 0);
    } 
  }
  
  public void onContinueButtonClicked(View paramView) {
    if (!this.birthdayTextView.getText().toString().equals("") && this.birthdayTextView != null) {
      String str = checkFormatting();
      try {
        int i = Integer.parseInt(this.age);
        if (i >= 18) {
          try {
            if (!str.equals("") || this.nameEditText != null || !this.nameEditText.getText().toString().equals("")) {
              this.activityCompleted = true;
              this.sharedPreferences.edit().putString("name", this.name).putString("age", this.age).apply();
              Intent intent = new Intent();
              this((Context)this, SignUpSecurityKey.class);
              startActivity(intent);
              finish();
            } 
          } catch (Exception exception) {
            exception.printStackTrace();
          } 
        } else {
          Toast.makeText((Context)this, 2131689594, 1).show();
        } 
      } catch (NumberFormatException numberFormatException) {
        numberFormatException.printStackTrace();
      } 
    } else {
      Toast.makeText((Context)this, 2131689586, 1).show();
    } 
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2131492899);
    if (getSupportActionBar() != null)
      getSupportActionBar().setElevation(0.0F); 
    this.sharedPreferences = getSharedPreferences("com.jamar.sharedpreferences", 0);
    this.backButton = (Button)findViewById(2131296569);
    this.continueButton = (Button)findViewById(2131296570);
    this.nameEditText = (EditText)findViewById(2131296568);
    this.birthdayTextView = (TextView)findViewById(2131296329);
    this.nameSignUpLayout = (ConstraintLayout)findViewById(2131296571);
    this.activityCompleted = false;
    this.nameEditText.setOnKeyListener(this);
    this.nameSignUpLayout.setOnClickListener(this);
    startService(new Intent((Context)this, signUpProcessService.class));
    this.birthdayTextView.setOnClickListener(new View.OnClickListener() {
          public void onClick(View param1View) {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(1);
            int j = calendar.get(2);
            int k = calendar.get(5);
            NameSignUp nameSignUp = NameSignUp.this;
            DatePickerDialog datePickerDialog = new DatePickerDialog((Context)nameSignUp, 16973832, nameSignUp.dateSetListener, i, j, k);
            datePickerDialog.getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
            datePickerDialog.show();
          }
        });
    this.dateSetListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker param1DatePicker, int param1Int1, int param1Int2, int param1Int3) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(param1Int2 + 1);
          stringBuilder.append("/");
          stringBuilder.append(param1Int3);
          stringBuilder.append("/");
          stringBuilder.append(param1Int1);
          String str = stringBuilder.toString();
          NameSignUp.this.birthdayTextView.setText(str);
        }
      };
  }
  
  protected void onDestroy() {
    super.onDestroy();
    if (!this.activityCompleted) {
      this.db.collection("Users").document(this.sharedPreferences.getString("currentUser", "")).delete();
      FirebaseAuth.getInstance().getCurrentUser().delete().addOnCompleteListener(new OnCompleteListener<Void>() {
            public void onComplete(Task<Void> param1Task) {
              param1Task.isSuccessful();
            }
          });
    } 
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent) {
    if (paramKeyEvent.getAction() == 66) {
      this.inputMethodManager = (InputMethodManager)getSystemService("input_method");
      this.inputMethodManager.hideSoftInputFromWindow(this.nameEditText.getWindowToken(), 0);
      return true;
    } 
    if (paramInt == 4) {
      super.onKeyDown(paramInt, paramKeyEvent);
      return true;
    } 
    return false;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4 || paramInt == 284 || paramInt == 187) {
      super.onKeyDown(paramInt, paramKeyEvent);
      return true;
    } 
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
    return false;
  }
}
