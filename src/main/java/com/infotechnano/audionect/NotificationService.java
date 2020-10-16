package com.infotechnano.audionect;

import android.app.IntentService;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

public class NotificationService extends IntentService {
  private CollectionReference artworkArtistCollection = this.db.collection("artwork");
  
  private CollectionReference canoeingCollection = this.db.collection("canoeing");
  
  private CollectionReference chatCollection = this.db.collection("Chat");
  
  private FirebaseFirestore db = FirebaseFirestore.getInstance();
  
  private CollectionReference engineeringProjectsCollection = this.db.collection("engineeringProjects");
  
  private CollectionReference filmProductionCollection = this.db.collection("filmProduction");
  
  private CollectionReference goingOutForGoodTimeCollection = this.db.collection("goingOutForGoodTime");
  
  private CollectionReference hikingCollection = this.db.collection("hiking");
  
  private CollectionReference musicProductionCollection = this.db.collection("musicProduction");
  
  private CollectionReference programmingProjectsCollection = this.db.collection("programmingProjects");
  
  private SharedPreferences sharedPreferences = MainActivity.context.getSharedPreferences("com.infotechnano.sharedpreferences", 0);
  
  private CollectionReference shoppingCollection = this.db.collection("shopping");
  
  private CollectionReference sportsCollection = this.db.collection("sports");
  
  private CollectionReference studyingCollection = this.db.collection("studying");
  
  private CollectionReference travelingCollection = this.db.collection("traveling");
  
  private CollectionReference user_auth_collection = this.db.collection("Users");
  
  private CollectionReference vehicleCollection = this.db.collection("vehicles");
  
  private CollectionReference ventingCollection = this.db.collection("ventingFrustration");
  
  private CollectionReference videogamesCollection = this.db.collection("videogames");
  
  public NotificationService() {
    super("NotificationService");
  }
  
  public NotificationService(String paramString) {
    super(paramString);
  }
  
  private void calculateTimeChange(int paramInt, String paramString) {
    long l1 = Long.parseLong(paramString);
    long l2 = (new Timestamp(new Date())).getSeconds();
    if (paramInt != 1) {
      if (paramInt != 12) {
        if (paramInt == 24 && l2 - l1 > 1440L) {
          this.sharedPreferences.edit().putString("bolt", "false").putString("boltPeriod", "").apply();
          updateUserCollection();
        } 
      } else if (l2 - l1 > 720L) {
        this.sharedPreferences.edit().putString("bolt", "false").putString("boltPeriod", "").apply();
        updateUserCollection();
      } 
    } else if (l2 - l1 > 60L) {
      this.sharedPreferences.edit().putString("bolt", "false").putString("boltPeriod", "").apply();
      updateUserCollection();
    } 
  }
  
  private String checkForNotifications() {
    final String[] nF = new String[3];
    this.user_auth_collection.whereEqualTo("userId", this.sharedPreferences.getString("currentUser", "")).addSnapshotListener(new EventListener<QuerySnapshot>() {
          public void onEvent(QuerySnapshot param1QuerySnapshot, FirebaseFirestoreException param1FirebaseFirestoreException) {
            if (param1FirebaseFirestoreException != null) {
              param1FirebaseFirestoreException.printStackTrace();
            } else if (!param1QuerySnapshot.isEmpty()) {
              for (QueryDocumentSnapshot queryDocumentSnapshot : param1QuerySnapshot) {
                nF[0] = queryDocumentSnapshot.getString("notificationFlag");
                nF[1] = queryDocumentSnapshot.getString("newMessages");
                nF[2] = queryDocumentSnapshot.getString("newMatches");
              } 
            } 
          }
        });
    this.sharedPreferences.edit().putString("newMessages", arrayOfString[1]).putString("newMatches", arrayOfString[2]).apply();
    return (arrayOfString[0] != null) ? arrayOfString[0] : "false";
  }
  
  private void checkTimer(int paramInt) {
    if (paramInt != 1) {
      if (paramInt != 12) {
        if (paramInt == 24)
          calculateTimeChange(24, downloadUserData()); 
      } else {
        calculateTimeChange(12, downloadUserData());
      } 
    } else {
      calculateTimeChange(1, downloadUserData());
    } 
  }
  
  private void doEditPictureService() {
    if (this.sharedPreferences.getString("leftPicTitle", "").equals("") && this.sharedPreferences.getString("middlePicTitle", "").equals("") && this.sharedPreferences.getString("rightPicTitle", "").equals("")) {
      if (!this.sharedPreferences.getString("leftPicTitle", "").equals("")) {
        updateUserData();
      } else if (!this.sharedPreferences.getString("middlePicTitle", "").equals("")) {
        updateUserData();
      } else if (!this.sharedPreferences.getString("rightPicTitle", "").equals("")) {
        updateUserData();
      } 
    } else {
      finishPictureChange();
    } 
  }
  
  private String downloadUserData() {
    final String[] boltPeriod = new String[1];
    this.user_auth_collection.whereEqualTo("userId", this.sharedPreferences.getString("currentUser", "")).addSnapshotListener(new EventListener<QuerySnapshot>() {
          public void onEvent(QuerySnapshot param1QuerySnapshot, FirebaseFirestoreException param1FirebaseFirestoreException) {
            if (param1FirebaseFirestoreException != null)
              param1FirebaseFirestoreException.printStackTrace(); 
            if (!param1QuerySnapshot.isEmpty())
              for (QueryDocumentSnapshot queryDocumentSnapshot : param1QuerySnapshot)
                boltPeriod[0] = queryDocumentSnapshot.getString("boltPeriod");  
          }
        });
    return arrayOfString[0].split(">")[1];
  }
  
  private void finishPictureChange() {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(this.sharedPreferences.getString("leftPicTitle", ""));
    stringBuilder1.append(",");
    stringBuilder1.append(this.sharedPreferences.getString("middlePicTitle", ""));
    stringBuilder1.append(",");
    stringBuilder1.append(this.sharedPreferences.getString("rightPicTitle", ""));
    String str1 = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(this.sharedPreferences.getString("leftPicture", ""));
    stringBuilder2.append(",");
    stringBuilder2.append(this.sharedPreferences.getString("middlePicture", ""));
    stringBuilder2.append(",");
    stringBuilder2.append(this.sharedPreferences.getString("rightPicture", ""));
    String str2 = stringBuilder2.toString();
    this.sharedPreferences.edit().putString("picturesList", str1).putString("urlList", str2).apply();
    updateUserData();
  }
  
  private void sendUserNotification(String paramString1, String paramString2, String paramString3) {
    NotificationManager notificationManager = (NotificationManager)getSystemService("notification");
    if (Build.VERSION.SDK_INT >= 26) {
      NotificationChannel notificationChannel = new NotificationChannel("newMatch", "newMatch", 3);
      notificationChannel.setDescription("You have a new match");
      notificationManager.createNotificationChannel(notificationChannel);
    } 
    NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), "newMatch");
    builder.setContentTitle(paramString1).setSmallIcon(2131230832).setContentText(paramString2).setTicker(paramString3).setWhen(System.currentTimeMillis()).setAutoCancel(true);
    int i = (int)(new Random(1000000000L)).nextLong();
    builder.setContentIntent(PendingIntent.getActivity((Context)this, 0, new Intent(getApplicationContext(), Chat.class), 134217728));
    notificationManager.notify(i, builder.build());
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
            NotificationService notificationService = NotificationService.this;
            notificationService.sendUserNotification(notificationService.getString(2131689536), NotificationService.this.getString(2131689749), NotificationService.this.getString(2131689537));
            notificationService = NotificationService.this;
            Toast.makeText((Context)notificationService, notificationService.getString(2131689749), 0).show();
          }
        }).addOnFailureListener(new OnFailureListener() {
          public void onFailure(Exception param1Exception) {}
        });
  }
  
  private void updateUserData() {
    byte b;
    String str = this.sharedPreferences.getString("userCategory", "");
    switch (str.hashCode()) {
      default:
        b = -1;
        break;
      case 2014205639:
        if (str.equals("vehicles")) {
          b = 1;
          break;
        } 
      case 1960295156:
        if (str.equals("goingOut")) {
          b = 2;
          break;
        } 
      case 1876609401:
        if (str.equals("studying")) {
          b = 10;
          break;
        } 
      case 1438428509:
        if (str.equals("filmProduction")) {
          b = 6;
          break;
        } 
      case 1289849005:
        if (str.equals("engineeringProjects")) {
          b = 13;
          break;
        } 
      case 1027739838:
        if (str.equals("musicProduction")) {
          b = 4;
          break;
        } 
      case 763555736:
        if (str.equals("ventFrustration")) {
          b = 7;
          break;
        } 
      case 624751731:
        if (str.equals("programmingProjects")) {
          b = 14;
          break;
        } 
      case -112094084:
        if (str.equals("canoeing")) {
          b = 12;
          break;
        } 
      case -344460952:
        if (str.equals("shopping")) {
          b = 0;
          break;
        } 
      case -731949068:
        if (str.equals("artwork")) {
          b = 5;
          break;
        } 
      case -865698022:
        if (str.equals("travel")) {
          b = 8;
          break;
        } 
      case -895760513:
        if (str.equals("sports")) {
          b = 3;
          break;
        } 
      case -1217273832:
        if (str.equals("hiking")) {
          b = 9;
          break;
        } 
      case -1611025626:
        if (str.equals("videogames")) {
          b = 11;
          break;
        } 
    } 
    switch (b) {
      default:
        return;
      case 14:
        uploadUserData(this.programmingProjectsCollection);
      case 13:
        uploadUserData(this.engineeringProjectsCollection);
      case 12:
        uploadUserData(this.canoeingCollection);
      case 11:
        uploadUserData(this.videogamesCollection);
      case 10:
        uploadUserData(this.studyingCollection);
      case 9:
        uploadUserData(this.hikingCollection);
      case 8:
        uploadUserData(this.travelingCollection);
      case 7:
        uploadUserData(this.ventingCollection);
      case 6:
        uploadUserData(this.filmProductionCollection);
      case 5:
        uploadUserData(this.artworkArtistCollection);
      case 4:
        uploadUserData(this.musicProductionCollection);
      case 3:
        uploadUserData(this.sportsCollection);
      case 2:
        uploadUserData(this.goingOutForGoodTimeCollection);
      case 1:
        uploadUserData(this.vehicleCollection);
      case 0:
        break;
    } 
    uploadUserData(this.shoppingCollection);
  }
  
  private void uploadUserData(CollectionReference paramCollectionReference) {
    HashMap<Object, Object> hashMap = new HashMap<>();
    hashMap.put("userId", this.sharedPreferences.getString("currentUser", ""));
    hashMap.put("showMe", this.sharedPreferences.getString("settingsShowMe", ""));
    hashMap.put("name", this.sharedPreferences.getString("name", ""));
    hashMap.put("city", this.sharedPreferences.getString("userLocation", ""));
    hashMap.put("picturesList", this.sharedPreferences.getString("picturesList", ""));
    hashMap.put("bio", this.sharedPreferences.getString("bio", ""));
    hashMap.put("category", this.sharedPreferences.getString("userCategory", ""));
    hashMap.put("urlList", this.sharedPreferences.getString("urlList", ""));
    hashMap.put("swipeRightList", this.sharedPreferences.getString("swipeRightList", ""));
    hashMap.put("swipeLeftList", this.sharedPreferences.getString("swipeLeftList", ""));
    paramCollectionReference.document(this.sharedPreferences.getString("currentUser", "")).set(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
          public void onSuccess(Void param1Void) {
            Log.d("updateUserData", "success");
          }
        }).addOnFailureListener(new OnFailureListener() {
          public void onFailure(Exception param1Exception) {}
        });
    hashMap = new HashMap<>();
    hashMap.put("age", Double.valueOf(Double.parseDouble(this.sharedPreferences.getString("age", ""))));
    hashMap.put("lat", Double.valueOf(Double.parseDouble(this.sharedPreferences.getString("lat", ""))));
    hashMap.put("lng", Double.valueOf(Double.parseDouble(this.sharedPreferences.getString("lng", ""))));
    paramCollectionReference.document(this.sharedPreferences.getString("currentUser", "")).set(hashMap, SetOptions.merge()).addOnSuccessListener(new OnSuccessListener<Void>() {
          public void onSuccess(Void param1Void) {
            Log.d("updateUserData", "success");
          }
        }).addOnFailureListener(new OnFailureListener() {
          public void onFailure(Exception param1Exception) {}
        });
  }
  
  public void onDestroy() {
    super.onDestroy();
  }
  
  protected void onHandleIntent(Intent paramIntent) {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: iload_2
    //   3: ifeq -> 475
    //   6: aload_0
    //   7: getfield sharedPreferences : Landroid/content/SharedPreferences;
    //   10: ldc_w 'login'
    //   13: ldc ''
    //   15: invokeinterface getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   20: ldc_w 'true'
    //   23: invokevirtual equals : (Ljava/lang/Object;)Z
    //   26: ifeq -> 314
    //   29: aload_0
    //   30: getfield sharedPreferences : Landroid/content/SharedPreferences;
    //   33: ldc_w 'notificationsActive'
    //   36: ldc_w 'true'
    //   39: invokeinterface getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   44: ldc_w 'true'
    //   47: invokevirtual equals : (Ljava/lang/Object;)Z
    //   50: ifeq -> 314
    //   53: aload_0
    //   54: invokespecial checkForNotifications : ()Ljava/lang/String;
    //   57: ldc_w 'true'
    //   60: invokevirtual equals : (Ljava/lang/Object;)Z
    //   63: ifeq -> 314
    //   66: aload_0
    //   67: getfield sharedPreferences : Landroid/content/SharedPreferences;
    //   70: ldc_w 'login'
    //   73: ldc ''
    //   75: invokeinterface getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   80: ldc_w 'true'
    //   83: invokevirtual equals : (Ljava/lang/Object;)Z
    //   86: ifeq -> 314
    //   89: aload_0
    //   90: getfield sharedPreferences : Landroid/content/SharedPreferences;
    //   93: ldc 'newMessages'
    //   95: ldc ''
    //   97: invokeinterface getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   102: ldc_w 'true'
    //   105: invokevirtual equals : (Ljava/lang/Object;)Z
    //   108: ifeq -> 176
    //   111: aload_0
    //   112: getfield sharedPreferences : Landroid/content/SharedPreferences;
    //   115: ldc_w 'newMessagesAN'
    //   118: ldc 'false'
    //   120: invokeinterface getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   125: ldc 'false'
    //   127: invokevirtual equals : (Ljava/lang/Object;)Z
    //   130: ifeq -> 176
    //   133: aload_0
    //   134: ldc_w 'Chatpad'
    //   137: aload_0
    //   138: ldc_w 2131689747
    //   141: invokevirtual getString : (I)Ljava/lang/String;
    //   144: aload_0
    //   145: ldc_w 2131689645
    //   148: invokevirtual getString : (I)Ljava/lang/String;
    //   151: invokespecial sendUserNotification : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   154: getstatic com/infotechnano/audionect/MessageThread.messageThreadActive : Z
    //   157: ifeq -> 222
    //   160: aload_0
    //   161: getstatic com/infotechnano/audionect/MessageThread.messageThreadExtra : Ljava/lang/String;
    //   164: invokevirtual retrieveNewMessages : (Ljava/lang/String;)V
    //   167: getstatic com/infotechnano/audionect/MessageThread.messageThreadAdapter : Lcom/infotechnano/audionect/adapter/MessageThreadAdapter;
    //   170: invokevirtual notifyDataSetChanged : ()V
    //   173: goto -> 222
    //   176: aload_0
    //   177: getfield sharedPreferences : Landroid/content/SharedPreferences;
    //   180: ldc 'newMessages'
    //   182: ldc ''
    //   184: invokeinterface getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   189: ldc_w 'true'
    //   192: invokevirtual equals : (Ljava/lang/Object;)Z
    //   195: ifne -> 222
    //   198: aload_0
    //   199: getfield sharedPreferences : Landroid/content/SharedPreferences;
    //   202: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   207: ldc_w 'newMessagesAN'
    //   210: ldc 'false'
    //   212: invokeinterface putString : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   217: invokeinterface apply : ()V
    //   222: aload_0
    //   223: getfield sharedPreferences : Landroid/content/SharedPreferences;
    //   226: ldc 'newMatches'
    //   228: ldc ''
    //   230: invokeinterface getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   235: ldc_w 'true'
    //   238: invokevirtual equals : (Ljava/lang/Object;)Z
    //   241: ifeq -> 268
    //   244: aload_0
    //   245: ldc_w 'Chatpad'
    //   248: aload_0
    //   249: ldc_w 2131689746
    //   252: invokevirtual getString : (I)Ljava/lang/String;
    //   255: aload_0
    //   256: ldc_w 2131689644
    //   259: invokevirtual getString : (I)Ljava/lang/String;
    //   262: invokespecial sendUserNotification : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   265: goto -> 314
    //   268: aload_0
    //   269: getfield sharedPreferences : Landroid/content/SharedPreferences;
    //   272: ldc 'newMatches'
    //   274: ldc ''
    //   276: invokeinterface getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   281: ldc_w 'true'
    //   284: invokevirtual equals : (Ljava/lang/Object;)Z
    //   287: ifne -> 314
    //   290: aload_0
    //   291: getfield sharedPreferences : Landroid/content/SharedPreferences;
    //   294: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   299: ldc_w 'newMatchesAN'
    //   302: ldc 'false'
    //   304: invokeinterface putString : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   309: invokeinterface apply : ()V
    //   314: aload_0
    //   315: getfield sharedPreferences : Landroid/content/SharedPreferences;
    //   318: ldc 'bolt'
    //   320: ldc 'false'
    //   322: invokeinterface getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   327: ldc_w 'true'
    //   330: invokevirtual equals : (Ljava/lang/Object;)Z
    //   333: ifeq -> 425
    //   336: aload_0
    //   337: getfield sharedPreferences : Landroid/content/SharedPreferences;
    //   340: ldc 'boltPeriod'
    //   342: ldc ''
    //   344: invokeinterface getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   349: ldc_w '1h'
    //   352: invokevirtual equals : (Ljava/lang/Object;)Z
    //   355: ifeq -> 366
    //   358: aload_0
    //   359: iconst_1
    //   360: invokespecial checkTimer : (I)V
    //   363: goto -> 425
    //   366: aload_0
    //   367: getfield sharedPreferences : Landroid/content/SharedPreferences;
    //   370: ldc 'boltPeriod'
    //   372: ldc ''
    //   374: invokeinterface getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   379: ldc_w '12h'
    //   382: invokevirtual equals : (Ljava/lang/Object;)Z
    //   385: ifeq -> 397
    //   388: aload_0
    //   389: bipush #12
    //   391: invokespecial checkTimer : (I)V
    //   394: goto -> 425
    //   397: aload_0
    //   398: getfield sharedPreferences : Landroid/content/SharedPreferences;
    //   401: ldc 'boltPeriod'
    //   403: ldc ''
    //   405: invokeinterface getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   410: ldc_w '24h'
    //   413: invokevirtual equals : (Ljava/lang/Object;)Z
    //   416: ifeq -> 425
    //   419: aload_0
    //   420: bipush #24
    //   422: invokespecial checkTimer : (I)V
    //   425: aload_0
    //   426: getfield sharedPreferences : Landroid/content/SharedPreferences;
    //   429: ldc 'currentUser'
    //   431: ldc ''
    //   433: invokeinterface getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   438: ldc ''
    //   440: invokevirtual equals : (Ljava/lang/Object;)Z
    //   443: ifeq -> 448
    //   446: iconst_0
    //   447: istore_2
    //   448: aload_0
    //   449: monitorenter
    //   450: aload_0
    //   451: ldc2_w 60000
    //   454: invokevirtual wait : (J)V
    //   457: aload_0
    //   458: monitorexit
    //   459: goto -> 2
    //   462: astore_1
    //   463: aload_0
    //   464: monitorexit
    //   465: aload_1
    //   466: athrow
    //   467: astore_1
    //   468: aload_1
    //   469: invokevirtual printStackTrace : ()V
    //   472: goto -> 2
    //   475: return
    // Exception table:
    //   from	to	target	type
    //   448	450	467	java/lang/InterruptedException
    //   450	459	462	finally
    //   463	465	462	finally
    //   465	467	467	java/lang/InterruptedException
  }
  
  public void onTaskRemoved(Intent paramIntent) {
    super.onTaskRemoved(paramIntent);
    sendBroadcast(new Intent("com.android.ServiceStopped"));
    if (this.sharedPreferences.getString("editPicture", "").equals("true"))
      doEditPictureService(); 
  }
  
  public void retrieveNewMessages(String paramString) {
    final String[] conversation = new String[1];
    String str2 = MessageThread.messageThreadConvKey;
    this.chatCollection.whereEqualTo("conversation", str2).addSnapshotListener(new EventListener<QuerySnapshot>() {
          public void onEvent(QuerySnapshot param1QuerySnapshot, FirebaseFirestoreException param1FirebaseFirestoreException) {
            if (param1FirebaseFirestoreException != null)
              param1FirebaseFirestoreException.printStackTrace(); 
            if (!param1QuerySnapshot.isEmpty())
              for (QueryDocumentSnapshot queryDocumentSnapshot : param1QuerySnapshot)
                conversation[0] = queryDocumentSnapshot.getString("message");  
          }
        });
    byte b = 0;
    String[] arrayOfString2 = arrayOfString1[0].split("!#!")[0].split(">");
    SharedPreferences sharedPreferences = this.sharedPreferences;
    String str1 = "";
    String[] arrayOfString3 = sharedPreferences.getString(str2, "").split(">");
    ArrayList arrayList = new ArrayList(Arrays.asList((Object[])arrayOfString2));
    ArrayList<String> arrayList1 = new ArrayList(Arrays.asList((Object[])arrayOfString3));
    arrayList1.addAll(arrayList);
    while (b < arrayList1.size()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str1);
      stringBuilder.append(">");
      stringBuilder.append(arrayList1.get(b));
      str1 = stringBuilder.toString();
      b++;
    } 
    this.sharedPreferences.edit().putString(str2, str1).apply();
  }
}
