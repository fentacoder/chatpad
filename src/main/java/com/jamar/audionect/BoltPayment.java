package com.jamar.audionect;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.android.billingclient.api.AcknowledgePurchaseResponseListener;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.SkuDetails;
import com.android.billingclient.api.SkuDetailsParams;
import com.android.billingclient.api.SkuDetailsResponseListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class BoltPayment extends AppCompatActivity implements PurchasesUpdatedListener {
  private AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener;
  
  private Button back;
  
  private BillingClient billingClient;
  
  private FirebaseFirestore db = FirebaseFirestore.getInstance();
  
  private TextView description;
  
  private TextView oneDay;
  
  private TextView oneHour;
  
  private String oneHourLine = "";
  
  private List<SkuDetails> priceList = new ArrayList<>();
  
  private BillingResult responseCode;
  
  private ScrollView scrollView;
  
  private SharedPreferences sharedPreferences;
  
  private TextView title;
  
  private TextView twelveHour;
  
  private String twelveHourLine = "";
  
  private String twentyFourHourLine = "";
  
  private CollectionReference user_auth_collection = this.db.collection("Users");
  
  private void handlePurchase(Purchase paramPurchase) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual getPurchaseState : ()I
    //   4: iconst_1
    //   5: if_icmpne -> 239
    //   8: aload_1
    //   9: invokevirtual getSku : ()Ljava/lang/String;
    //   12: astore_2
    //   13: aload_2
    //   14: invokevirtual hashCode : ()I
    //   17: istore_3
    //   18: iload_3
    //   19: ldc -1565778297
    //   21: if_icmpeq -> 67
    //   24: iload_3
    //   25: ldc -209836768
    //   27: if_icmpeq -> 53
    //   30: iload_3
    //   31: ldc 831494393
    //   33: if_icmpeq -> 39
    //   36: goto -> 81
    //   39: aload_2
    //   40: ldc 'bolt_twenty_four_hour'
    //   42: invokevirtual equals : (Ljava/lang/Object;)Z
    //   45: ifeq -> 81
    //   48: iconst_2
    //   49: istore_3
    //   50: goto -> 83
    //   53: aload_2
    //   54: ldc 'bolt_twelve_hour'
    //   56: invokevirtual equals : (Ljava/lang/Object;)Z
    //   59: ifeq -> 81
    //   62: iconst_1
    //   63: istore_3
    //   64: goto -> 83
    //   67: aload_2
    //   68: ldc 'bolt_one_hour'
    //   70: invokevirtual equals : (Ljava/lang/Object;)Z
    //   73: ifeq -> 81
    //   76: iconst_0
    //   77: istore_3
    //   78: goto -> 83
    //   81: iconst_m1
    //   82: istore_3
    //   83: iload_3
    //   84: ifeq -> 170
    //   87: iload_3
    //   88: iconst_1
    //   89: if_icmpeq -> 135
    //   92: iload_3
    //   93: iconst_2
    //   94: if_icmpeq -> 100
    //   97: goto -> 202
    //   100: aload_0
    //   101: getfield sharedPreferences : Landroid/content/SharedPreferences;
    //   104: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   109: ldc 'bolt'
    //   111: ldc 'true'
    //   113: invokeinterface putString : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   118: ldc 'boltPeriod'
    //   120: ldc '24h'
    //   122: invokeinterface putString : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   127: invokeinterface apply : ()V
    //   132: goto -> 202
    //   135: aload_0
    //   136: getfield sharedPreferences : Landroid/content/SharedPreferences;
    //   139: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   144: ldc 'bolt'
    //   146: ldc 'true'
    //   148: invokeinterface putString : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   153: ldc 'boltPeriod'
    //   155: ldc '12h'
    //   157: invokeinterface putString : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   162: invokeinterface apply : ()V
    //   167: goto -> 202
    //   170: aload_0
    //   171: getfield sharedPreferences : Landroid/content/SharedPreferences;
    //   174: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   179: ldc 'bolt'
    //   181: ldc 'true'
    //   183: invokeinterface putString : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   188: ldc 'boltPeriod'
    //   190: ldc '1h'
    //   192: invokeinterface putString : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   197: invokeinterface apply : ()V
    //   202: aload_0
    //   203: invokespecial updateUserCollection : ()V
    //   206: aload_1
    //   207: invokevirtual isAcknowledged : ()Z
    //   210: ifne -> 239
    //   213: invokestatic newBuilder : ()Lcom/android/billingclient/api/AcknowledgePurchaseParams$Builder;
    //   216: aload_1
    //   217: invokevirtual getPurchaseToken : ()Ljava/lang/String;
    //   220: invokevirtual setPurchaseToken : (Ljava/lang/String;)Lcom/android/billingclient/api/AcknowledgePurchaseParams$Builder;
    //   223: invokevirtual build : ()Lcom/android/billingclient/api/AcknowledgePurchaseParams;
    //   226: astore_1
    //   227: aload_0
    //   228: getfield billingClient : Lcom/android/billingclient/api/BillingClient;
    //   231: aload_1
    //   232: aload_0
    //   233: getfield acknowledgePurchaseResponseListener : Lcom/android/billingclient/api/AcknowledgePurchaseResponseListener;
    //   236: invokevirtual acknowledgePurchase : (Lcom/android/billingclient/api/AcknowledgePurchaseParams;Lcom/android/billingclient/api/AcknowledgePurchaseResponseListener;)V
    //   239: return
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
    this.back.setTextColor(-1);
    this.back.setBackgroundResource(2131230854);
    this.title.setTextColor(-1);
    this.description.setTextColor(-1);
    this.oneHour.setTextColor(-1);
    this.twelveHour.setTextColor(-1);
    this.oneDay.setTextColor(-1);
  }
  
  private void setupBillingClient() {
    this.billingClient = BillingClient.newBuilder((Context)this).enablePendingPurchases().setListener(this).build();
    this.billingClient.startConnection(new BillingClientStateListener() {
          public void onBillingServiceDisconnected() {}
          
          public void onBillingSetupFinished(BillingResult param1BillingResult) {
            ArrayList<String> arrayList = new ArrayList();
            arrayList.add("bolt_one_hour");
            arrayList.add("bolt_twelve_hour");
            arrayList.add("bolt_twenty_four_hour");
            SkuDetailsParams.Builder builder = SkuDetailsParams.newBuilder();
            builder.setSkusList(arrayList).setType("inapp");
            BoltPayment.this.billingClient.querySkuDetailsAsync(builder.build(), new SkuDetailsResponseListener() {
                  public void onSkuDetailsResponse(BillingResult param2BillingResult, List<SkuDetails> param2List) {
                    Log.d("paymentBilling", "finished");
                    if (param2BillingResult.getResponseCode() == 0 && param2List != null) {
                      for (SkuDetails skuDetails : param2List) {
                        String str5 = skuDetails.getSku();
                        String str4 = skuDetails.getPrice();
                        if ("bolt_one_hour".equals(str5)) {
                          BoltPayment.access$002(BoltPayment.this, str4);
                        } else if ("bolt_twelve_hour".equals(str5)) {
                          BoltPayment.access$102(BoltPayment.this, str4);
                        } else if ("bolt_twenty_four_hour".equals(str5)) {
                          BoltPayment.access$202(BoltPayment.this, str4);
                        } 
                        BoltPayment.this.priceList.add(skuDetails);
                      } 
                      StringBuilder stringBuilder1 = new StringBuilder();
                      stringBuilder1.append(BoltPayment.this.getString(2131689656));
                      stringBuilder1.append(" ");
                      stringBuilder1.append(BoltPayment.this.oneHourLine);
                      stringBuilder1.append(" ");
                      stringBuilder1.append(BoltPayment.this.getString(2131689669));
                      String str1 = stringBuilder1.toString();
                      StringBuilder stringBuilder2 = new StringBuilder();
                      stringBuilder2.append(BoltPayment.this.getString(2131689728));
                      stringBuilder2.append(" ");
                      stringBuilder2.append(BoltPayment.this.twelveHourLine);
                      stringBuilder2.append(" ");
                      stringBuilder2.append(BoltPayment.this.getString(2131689669));
                      String str2 = stringBuilder2.toString();
                      StringBuilder stringBuilder3 = new StringBuilder();
                      stringBuilder3.append(BoltPayment.this.getString(2131689655));
                      stringBuilder3.append(" ");
                      stringBuilder3.append(BoltPayment.this.twentyFourHourLine);
                      stringBuilder3.append(" ");
                      stringBuilder3.append(BoltPayment.this.getString(2131689669));
                      String str3 = stringBuilder3.toString();
                      BoltPayment.this.oneHour.setText(str1);
                      BoltPayment.this.twelveHour.setText(str2);
                      BoltPayment.this.oneDay.setText(str3);
                    } 
                  }
                });
          }
        });
  }
  
  private void updateUserCollection() {
    HashMap<Object, Object> hashMap = new HashMap<>();
    hashMap.put("userId", this.sharedPreferences.getString("currentUser", ""));
    hashMap.put("username", this.sharedPreferences.getString("username", ""));
    hashMap.put("category", this.sharedPreferences.getString("userCategory", ""));
    hashMap.put("password", this.sharedPreferences.getString("password", ""));
    hashMap.put("email", this.sharedPreferences.getString("email", ""));
    hashMap.put("phoneNumber", this.sharedPreferences.getString("phoneNumber", ""));
    hashMap.put("genderPref", this.sharedPreferences.getString("gender", "both"));
    hashMap.put("genderId", this.sharedPreferences.getString("genderId", ""));
    hashMap.put("notificationFlag", this.sharedPreferences.getString("notificationsActive", "false"));
    hashMap.put("chatterPlan", this.sharedPreferences.getString("chatter", ""));
    hashMap.put("extrovertPlan", this.sharedPreferences.getString("extrovert", ""));
    hashMap.put("platinumPlan", this.sharedPreferences.getString("platinum", ""));
    hashMap.put("newMessages", this.sharedPreferences.getString("newMessages", "false"));
    hashMap.put("newMatches", this.sharedPreferences.getString("newMatches", "false"));
    hashMap.put("chatList", this.sharedPreferences.getString("chatList", ""));
    hashMap.put("blockList", this.sharedPreferences.getString("blockList", ""));
    hashMap.put("bolt", this.sharedPreferences.getString("bolt", "false"));
    hashMap.put("boltPeriod", this.sharedPreferences.getString("boltPeriod", ""));
    hashMap.put("securityKey", this.sharedPreferences.getString("securityKey", ""));
    if (!this.sharedPreferences.getString("paymentActive", "").equals("") && !this.sharedPreferences.getString("paymentActive", "").equals("false")) {
      hashMap.put("paymentOption", this.sharedPreferences.getString("paymentActive", ""));
      hashMap.put("paymentToken", this.sharedPreferences.getString("paymentToken", ""));
    } else {
      hashMap.put("paymentOption", "");
      hashMap.put("paymentToken", "");
    } 
    this.user_auth_collection.document(this.sharedPreferences.getString("currentUser", "")).set(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
          public void onSuccess(Void param1Void) {
            Log.d("userCollectionChanged", "success");
          }
        }).addOnFailureListener(new OnFailureListener() {
          public void onFailure(Exception param1Exception) {}
        });
  }
  
  public void onBackPressed() {
    super.onBackPressed();
    startActivity(new Intent((Context)this, MainActivity.class));
    finish();
  }
  
  public void onBoltBackClicked(View paramView) {
    startActivity(new Intent((Context)this, MainActivity.class));
    finish();
  }
  
  public void onBoltPayClicked(View paramView) {
    SkuDetails skuDetails;
    byte b;
    String str = paramView.getTag().toString();
    switch (str.hashCode()) {
      default:
        b = -1;
        break;
      case 50:
        if (str.equals("2")) {
          b = 2;
          break;
        } 
      case 49:
        if (str.equals("1")) {
          b = 1;
          break;
        } 
      case 48:
        if (str.equals("0")) {
          b = 0;
          break;
        } 
    } 
    if (b != 0) {
      if (b != 1) {
        if (b != 2) {
          str = null;
        } else {
          skuDetails = this.priceList.get(2);
        } 
      } else {
        skuDetails = this.priceList.get(1);
      } 
    } else {
      skuDetails = this.priceList.get(0);
    } 
    BillingFlowParams billingFlowParams = BillingFlowParams.newBuilder().setSkuDetails(skuDetails).build();
    if (skuDetails != null)
      if (this.billingClient.isFeatureSupported("subscriptions").getResponseCode() == 0) {
        this.responseCode = this.billingClient.launchBillingFlow((Activity)this, billingFlowParams);
      } else {
        Toast.makeText((Context)this, "Subscriptions are not supported on this device", 0).show();
      }  
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2131492903);
    if (getSupportActionBar() != null)
      getSupportActionBar().setElevation(0.0F); 
    this.sharedPreferences = getSharedPreferences("com.jamar.sharedpreferences", 0);
    this.scrollView = (ScrollView)findViewById(2131296336);
    this.back = (Button)findViewById(2131296334);
    this.title = (TextView)findViewById(2131296337);
    this.description = (TextView)findViewById(2131296335);
    this.oneHour = (TextView)findViewById(2131296332);
    this.twelveHour = (TextView)findViewById(2131296331);
    this.oneDay = (TextView)findViewById(2131296333);
    setColor();
    setupBillingClient();
    this.acknowledgePurchaseResponseListener = new AcknowledgePurchaseResponseListener() {
        public void onAcknowledgePurchaseResponse(BillingResult param1BillingResult) {
          BoltPayment boltPayment = BoltPayment.this;
          boltPayment.startActivity(new Intent((Context)boltPayment, MainActivity.class));
          BoltPayment.this.finish();
        }
      };
  }
  
  public void onPurchasesUpdated(BillingResult paramBillingResult, List<Purchase> paramList) {
    Iterator<Purchase> iterator;
    if (paramBillingResult.getResponseCode() == 0 && this.responseCode.getResponseCode() == 0 && paramList != null) {
      iterator = paramList.iterator();
      while (iterator.hasNext())
        handlePurchase(iterator.next()); 
    } else if (iterator.getResponseCode() == 1) {
      Toast.makeText((Context)this, 2131689666, 0).show();
    } else {
      Toast.makeText((Context)this, 2131689667, 0).show();
    } 
  }
}


