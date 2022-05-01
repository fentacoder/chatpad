package com.jamar.audionect.signUpProcess;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.safetynet.SafetyNet;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.jamar.audionect.TermsPrivacyPolicyPage;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

public class CreateAccountScreen extends AppCompatActivity implements View.OnTouchListener, View.OnClickListener {
  public static final String SECRET_KEY = "6LcEkcwUAAAAAHF899tbvHX3xpDUesyAckL_Lcy0";
  
  public static final String SITE_KEY = "6LcEkcwUAAAAALtnmOXYuAMX9jAJfcluvyojB5BU";
  
  public static final String VERI_SITE = "https://www.google.com/recaptcha/api/siteverify";
  
  private boolean alreadyClicked;
  
  private FirebaseAuth.AuthStateListener authStateListener;
  
  private boolean checkedOrNot;
  
  private ConstraintLayout constraintLayout;
  
  private FirebaseUser currentUser;
  
  private FirebaseFirestore db = FirebaseFirestore.getInstance();
  
  private EditText emailEditText;
  
  private FirebaseAuth firebaseAuth;
  
  private InputMethodManager inputMethodManager;
  
  private String[] letters = new String[] { 
      "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", 
      "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", 
      "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", 
      "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", 
      "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", 
      "Y", "Z" };
  
  private EditText passwordEditText;
  
  private EditText phoneEditText;
  
  private String phoneNumber = "";
  
  private ProgressBar progressBar;
  
  private String[] punctuation = new String[] { 
      ".", ",", "'", "/", "\\", "!", "@", "#", "$", "%", 
      "^", "&", "*", "(", ")", "_", "=", "+", "<", ">", 
      "`", "~", "?", "-", "|", "[", "]", "{", "}", ":", 
      ";" };
  
  private ImageButton recaptchaClick;
  
  private boolean recaptchaSuccess;
  
  private SharedPreferences sharedPreferences;
  
  private String[] userDataStringArray;
  
  private EditText userNameEditText;
  
  private String userResponseTok;
  
  private CollectionReference user_auth_collection = this.db.collection("Users");
  
  private void createUserEmailAccount(final String email, final String password, final String usernameCopy) {
    this.phoneNumber = removePunctuation(this.phoneEditText.getText().toString().trim());
    if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(usernameCopy)) {
      String str = this.phoneNumber;
      if (str != null && !str.equals("")) {
        this.progressBar.setVisibility(0);
        this.firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
              public void onComplete(Task<AuthResult> param1Task) {
                if (param1Task.isSuccessful()) {
                  CreateAccountScreen createAccountScreen = CreateAccountScreen.this;
                  CreateAccountScreen.access$002(createAccountScreen, createAccountScreen.firebaseAuth.getCurrentUser());
                  String str = CreateAccountScreen.this.currentUser.getUid();
                  HashMap<Object, Object> hashMap = new HashMap<>();
                  hashMap.put("userId", str);
                  hashMap.put("username", usernameCopy);
                  hashMap.put("password", password);
                  hashMap.put("email", email);
                  hashMap.put("phoneNumber", CreateAccountScreen.this.phoneNumber);
                  CreateAccountScreen.this.sharedPreferences.edit().putString("currentUser", str).putString("email", email).putString("password", password).putString("phoneNumber", CreateAccountScreen.this.phoneNumber).apply();
                  CreateAccountScreen.this.user_auth_collection.document(str).set(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                        public void onSuccess(Void param2Void) {
                          CreateAccountScreen.this.progressBar.setVisibility(4);
                          CreateAccountScreen.this.startActivity(new Intent((Context)CreateAccountScreen.this, NameSignUp.class));
                          CreateAccountScreen.this.finish();
                        }
                      }).addOnFailureListener(new OnFailureListener() {
                        public void onFailure(Exception param2Exception) {}
                      });
                } 
              }
            }).addOnFailureListener(new OnFailureListener() {
              public void onFailure(Exception param1Exception) {
                Toast.makeText((Context)CreateAccountScreen.this, param1Exception.getMessage(), 1).show();
                CreateAccountScreen.this.progressBar.setVisibility(4);
              }
            });
        return;
      } 
    } 
    Toast.makeText((Context)this, 2131689673, 1).show();
  }
  
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
  
  public void onBackPressed() {
    super.onBackPressed();
    Toast.makeText((Context)this, 2131689729, 0).show();
    startActivity(new Intent((Context)this, StartUpScreen.class));
    finish();
  }
  
  public void onCATermsClicked(View paramView) {
    Intent intent = new Intent((Context)this, TermsPrivacyPolicyPage.class);
    intent.putExtra("prevClass", "startScreen");
    startActivity(intent);
    finish();
  }
  
  public void onCBClicked(View paramView) {
    if (this.recaptchaSuccess) {
      if (!TextUtils.isEmpty(this.emailEditText.getText().toString()) && !TextUtils.isEmpty(this.passwordEditText.getText().toString()) && !TextUtils.isEmpty(this.userNameEditText.getText().toString()) && !TextUtils.isEmpty(this.phoneEditText.getText().toString())) {
        this.progressBar.setVisibility(0);
        String str2 = this.emailEditText.getText().toString();
        String str1 = this.passwordEditText.getText().toString();
        String str3 = this.userNameEditText.getText().toString();
        this.sharedPreferences.edit().putString("username", str3).apply();
        createUserEmailAccount(str2, str1, str3);
      } else {
        Toast.makeText((Context)this, 2131689716, 1).show();
      } 
    } else {
      Toast.makeText((Context)this, getString(2131689714), 0).show();
    } 
  }
  
  public void onClick(View paramView) {
    if (!this.alreadyClicked) {
      this.progressBar.setVisibility(0);
      SafetyNet.getClient((Activity)this).verifyWithRecaptcha("6LcEkcwUAAAAALtnmOXYuAMX9jAJfcluvyojB5BU").addOnSuccessListener(new OnSuccessListener<SafetyNetApi.RecaptchaTokenResponse>() {
            public void onSuccess(SafetyNetApi.RecaptchaTokenResponse param1RecaptchaTokenResponse) {
              CreateAccountScreen.access$602(CreateAccountScreen.this, param1RecaptchaTokenResponse.getTokenResult());
              if (!CreateAccountScreen.this.userResponseTok.isEmpty()) {
                CreateAccountScreen.this.sendRequest();
              } else {
                CreateAccountScreen.this.progressBar.setVisibility(4);
                Log.d("recaptchaError", "there was a null token error");
              } 
            }
          }).addOnFailureListener(new OnFailureListener() {
            public void onFailure(Exception param1Exception) {
              if (param1Exception instanceof ApiException) {
                Log.d("recaptchaError", String.valueOf(((ApiException)param1Exception).getStatusCode()));
                CreateAccountScreen.this.progressBar.setVisibility(4);
              } else {
                Log.d("recaptchaError", "recaptcha error is not common and may be new");
                CreateAccountScreen.this.progressBar.setVisibility(4);
              } 
            }
          });
    } else if (this.recaptchaSuccess) {
      if (this.checkedOrNot) {
        this.recaptchaClick.setBackgroundResource(2131230909);
        this.checkedOrNot = false;
      } else {
        this.recaptchaClick.setBackgroundResource(2131230834);
        this.checkedOrNot = true;
      } 
    } 
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2131492893);
    if (getSupportActionBar() != null)
      getSupportActionBar().setElevation(0.0F); 
    this.sharedPreferences = getSharedPreferences("com.jamar.sharedpreferences", 0);
    this.progressBar = (ProgressBar)findViewById(2131296410);
    this.emailEditText = (EditText)findViewById(2131296438);
    this.passwordEditText = (EditText)findViewById(2131296593);
    this.userNameEditText = (EditText)findViewById(2131296765);
    this.phoneEditText = (EditText)findViewById(2131296406);
    this.constraintLayout = (ConstraintLayout)findViewById(2131296407);
    this.recaptchaClick = (ImageButton)findViewById(2131296405);
    this.recaptchaSuccess = false;
    this.alreadyClicked = false;
    this.checkedOrNot = false;
    this.constraintLayout.setOnTouchListener(this);
    this.firebaseAuth = FirebaseAuth.getInstance();
    this.authStateListener = new FirebaseAuth.AuthStateListener() {
        public void onAuthStateChanged(FirebaseAuth param1FirebaseAuth) {
          CreateAccountScreen.access$002(CreateAccountScreen.this, param1FirebaseAuth.getCurrentUser());
        }
      };
    this.recaptchaClick.setOnClickListener(this);
  }
  
  public void onCreateAccountBackButtonClicked(View paramView) {
    startActivity(new Intent((Context)this, StartUpScreen.class));
  }
  
  protected void onDestroy() {
    super.onDestroy();
    FirebaseAuth firebaseAuth = this.firebaseAuth;
    if (firebaseAuth != null)
      firebaseAuth.removeAuthStateListener(this.authStateListener); 
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4) {
      super.onKeyDown(paramInt, paramKeyEvent);
      return true;
    } 
    return false;
  }
  
  protected void onStart() {
    super.onStart();
    if (this.firebaseAuth.getCurrentUser() != null)
      this.currentUser = this.firebaseAuth.getCurrentUser(); 
    this.firebaseAuth.addAuthStateListener(this.authStateListener);
  }
  
  protected void onStop() {
    super.onStop();
    FirebaseAuth firebaseAuth = this.firebaseAuth;
    if (firebaseAuth != null)
      firebaseAuth.removeAuthStateListener(this.authStateListener); 
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
    if (paramView.getId() == 2131296407) {
      this.inputMethodManager = (InputMethodManager)getSystemService("input_method");
      this.inputMethodManager.hideSoftInputFromWindow(this.passwordEditText.getWindowToken(), 0);
    } 
    return true;
  }
  
  public void sendRequest() {
    Volley.newRequestQueue((Context)this).add((Request)new StringRequest(1, "https://www.google.com/recaptcha/api/siteverify", new Response.Listener<String>() {
            public void onResponse(String param1String) {
              try {
                JSONObject jSONObject = new JSONObject();
                this(param1String);
                if (jSONObject.getString("success").equals("true")) {
                  CreateAccountScreen.this.progressBar.setVisibility(4);
                  CreateAccountScreen.this.recaptchaClick.setBackgroundResource(2131230834);
                  CreateAccountScreen.access$802(CreateAccountScreen.this, true);
                  CreateAccountScreen.access$902(CreateAccountScreen.this, true);
                  CreateAccountScreen.access$1002(CreateAccountScreen.this, true);
                } else {
                  Intent intent = new Intent();
                  this(StartUpScreen.class);
                  intent.putExtra("security", "robot");
                  CreateAccountScreen.this.startActivity(intent);
                  CreateAccountScreen.this.finish();
                } 
              } catch (JSONException jSONException) {
                jSONException.printStackTrace();
                Log.d("recaptchaError", Objects.<String>requireNonNull(jSONException.getMessage()));
              } 
            }
          }new Response.ErrorListener() {
            public void onErrorResponse(VolleyError param1VolleyError) {
              Log.d("recaptchaError", Objects.<String>requireNonNull(param1VolleyError.getMessage()));
              Toast.makeText((Context)CreateAccountScreen.this, param1VolleyError.getMessage(), 0).show();
            }
          }) {
          protected Map<String, String> getParams() throws AuthFailureError {
            HashMap<Object, Object> hashMap = new HashMap<>();
            hashMap.put("secret", "6LcEkcwUAAAAAHF899tbvHX3xpDUesyAckL_Lcy0");
            hashMap.put("response", CreateAccountScreen.this.userResponseTok);
            return (Map)hashMap;
          }
        });
  }
}