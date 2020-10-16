package com.infotechnano.audionect;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import com.infotechnano.audionect.signUpProcess.StartUpScreen;

public class TermsPage extends AppCompatActivity {
  private Bundle b;
  
  private String prevClass;
  
  private WebView webView;
  
  public void onBackPressed() {
    super.onBackPressed();
    if (this.webView.canGoBack()) {
      this.webView.goBack();
    } else if (this.prevClass.equals("startScreen")) {
      startActivity(new Intent((Context)this, StartUpScreen.class));
      finish();
    } else {
      startActivity(new Intent((Context)this, Settings.class));
      finish();
    } 
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2131492977);
    if (getSupportActionBar() != null)
      getSupportActionBar().setElevation(0.0F); 
    this.b = getIntent().getExtras();
    this.prevClass = this.b.getString("prevClass");
    this.webView = (WebView)findViewById(2131296731);
    this.webView.setWebViewClient(new WebViewClient());
    this.webView.loadUrl("https://www.websitepolicies.com/policies/view/9PFjKOov");
  }
}