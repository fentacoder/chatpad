package com.infotechnano.audionect;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.infotechnano.audionect.adapter.MessageThreadAdapter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

public class MessageThread extends AppCompatActivity {
  public static boolean messageThreadActive;
  
  public static MessageThreadAdapter messageThreadAdapter;
  
  public static String messageThreadConvKey;
  
  public static String messageThreadExtra;
  
  public static RecyclerView messageThreadRecyclerView;
  
  private CollectionReference artworkArtistCollection = this.db.collection("artwork");
  
  private Button back;
  
  private TextView blockTextView;
  
  private CollectionReference canoeingCollection = this.db.collection("canoeing");
  
  private CardView cardView;
  
  private CollectionReference chatCollection = this.db.collection("Chat");
  
  private FirebaseFirestore db = FirebaseFirestore.getInstance();
  
  private CollectionReference engineeringProjectsCollection = this.db.collection("engineeringProjects");
  
  private CollectionReference filmProductionCollection = this.db.collection("filmProduction");
  
  private ArrayList<String> finalMessageList;
  
  private CollectionReference goingOutForGoodTimeCollection = this.db.collection("goingOutForGoodTime");
  
  private CollectionReference hikingCollection = this.db.collection("hiking");
  
  private RelativeLayout linearLayout;
  
  private EditText messageEditText;
  
  private CollectionReference musicProductionCollection = this.db.collection("musicProduction");
  
  private CollectionReference programmingProjectsCollection = this.db.collection("programmingProjects");
  
  private ProgressBar progressBar;
  
  private ImageButton sendButton;
  
  private SharedPreferences sharedPreferences;
  
  private CollectionReference shoppingCollection = this.db.collection("shopping");
  
  private CollectionReference sportsCollection = this.db.collection("sports");
  
  private TextView strangerBlockTextView;
  
  private CollectionReference studyingCollection = this.db.collection("studying");
  
  private CollectionReference travelingCollection = this.db.collection("traveling");
  
  private boolean userBlockedStranger;
  
  private boolean userIsBlocked;
  
  private CollectionReference user_auth_collection = this.db.collection("Users");
  
  private CollectionReference vehicleCollection = this.db.collection("vehicles");
  
  private CollectionReference ventingCollection = this.db.collection("ventingFrustration");
  
  private CollectionReference videogamesCollection = this.db.collection("videogames");
  
  private void addMessagesToSharedPref(ArrayList<String> paramArrayList) {
    SharedPreferences sharedPreferences = this.sharedPreferences;
    String str3 = messageThreadConvKey;
    String str4 = "";
    String str2 = sharedPreferences.getString(str3, "");
    Iterator<String> iterator = paramArrayList.iterator();
    String str1;
    for (str1 = str4; iterator.hasNext(); str1 = stringBuilder1.toString()) {
      String str = iterator.next();
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str1);
      stringBuilder1.append(">");
      stringBuilder1.append(str);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str2);
    stringBuilder.append(str1);
    str1 = stringBuilder.toString();
    this.sharedPreferences.edit().putString(messageThreadConvKey, str1).apply();
  }
  
  private void blockStranger(String paramString) {
    SharedPreferences sharedPreferences = this.sharedPreferences;
    String str = "";
    ArrayList<String> arrayList = new ArrayList(Arrays.asList((Object[])sharedPreferences.getString("blockList", "").split(",")));
    arrayList.add(paramString);
    Iterator<String> iterator = arrayList.iterator();
    for (paramString = str; iterator.hasNext(); paramString = stringBuilder.toString()) {
      String str1 = iterator.next();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append(",");
      stringBuilder.append(str1);
    } 
    this.sharedPreferences.edit().putString("blockList", paramString).apply();
    updateUserCollection();
  }
  
  private boolean checkDate(String paramString) {
    String[] arrayOfString1 = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")).format(new Date()).split("\\s+")[0].trim().split("/");
    String str2 = checkNumFormat(arrayOfString1[0]);
    String str3 = checkNumFormat(arrayOfString1[1]);
    String str1 = arrayOfString1[2];
    String[] arrayOfString2 = paramString.split(",");
    String[] arrayOfString3 = arrayOfString2[0].split("\\s+");
    paramString = arrayOfString3[1].trim();
    String str5 = getMonth(arrayOfString3[0].trim());
    String str4 = arrayOfString2[1].trim();
    return (paramString.equals(str2) && str5.equals(str3) && str4.equals(str1));
  }
  
  private boolean checkIfUserBlockedStranger(String paramString) {
    String[] arrayOfString = this.sharedPreferences.getString("blockList", "").split(",");
    int i = arrayOfString.length;
    for (byte b = 0; b < i; b++) {
      if (arrayOfString[b].equals(paramString))
        return true; 
    } 
    return false;
  }
  
  private String checkMessageFormat(String paramString) {
    char[] arrayOfChar = paramString.toCharArray();
    StringBuilder stringBuilder = new StringBuilder();
    for (byte b = 0; b < arrayOfChar.length; b++) {
      if (arrayOfChar[b] != '>')
        stringBuilder.append(arrayOfChar[b]); 
    } 
    return stringBuilder.toString();
  }
  
  private String checkNumFormat(String paramString) {
    int i = paramString.length();
    byte b = 2;
    String str = paramString;
    if (i == 2) {
      str = paramString;
      if (paramString.substring(0, 1).equals("0")) {
        switch (paramString.hashCode()) {
          default:
            b = -1;
            break;
          case 1545:
            if (paramString.equals("09")) {
              b = 8;
              break;
            } 
          case 1544:
            if (paramString.equals("08")) {
              b = 7;
              break;
            } 
          case 1543:
            if (paramString.equals("07")) {
              b = 6;
              break;
            } 
          case 1542:
            if (paramString.equals("06")) {
              b = 5;
              break;
            } 
          case 1541:
            if (paramString.equals("05")) {
              b = 4;
              break;
            } 
          case 1540:
            if (paramString.equals("04")) {
              b = 3;
              break;
            } 
          case 1539:
            if (paramString.equals("03"))
              break; 
          case 1538:
            if (paramString.equals("02")) {
              b = 1;
              break;
            } 
          case 1537:
            if (paramString.equals("01")) {
              b = 0;
              break;
            } 
        } 
        switch (b) {
          default:
            return "";
          case 8:
            return "9";
          case 7:
            return "8";
          case 6:
            return "7";
          case 5:
            return "6";
          case 4:
            return "5";
          case 3:
            return "4";
          case 2:
            return "3";
          case 1:
            return "2";
          case 0:
            break;
        } 
        str = "1";
      } 
    } 
    return str;
  }
  
  private String combineConvKey(String paramString1, String paramString2) {
    String str = setLesserConvKey(paramString1, paramString2);
    paramString1 = setGreaterConvKey(paramString1, paramString2);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append(">");
    stringBuilder.append(paramString1);
    return stringBuilder.toString();
  }
  
  private void deleteNewMessagesFromFirebase(String paramString) {
    paramString = combineConvKey(this.sharedPreferences.getString("currentUser", ""), paramString);
    this.db.collection("Chat").document(paramString).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
          public void onSuccess(Void param1Void) {
            Log.d("deleteMessage", "successful");
          }
        }).addOnFailureListener(new OnFailureListener() {
          public void onFailure(Exception param1Exception) {}
        });
  }
  
  private String downloadDataFromServer(String paramString, CollectionReference paramCollectionReference) {
    final String[] strangerName = new String[1];
    arrayOfString[0] = "";
    paramCollectionReference.whereEqualTo("userId", paramString).addSnapshotListener(new EventListener<QuerySnapshot>() {
          public void onEvent(QuerySnapshot param1QuerySnapshot, FirebaseFirestoreException param1FirebaseFirestoreException) {
            if (param1FirebaseFirestoreException != null)
              param1FirebaseFirestoreException.printStackTrace(); 
            if (!param1QuerySnapshot.isEmpty())
              for (QueryDocumentSnapshot queryDocumentSnapshot : param1QuerySnapshot)
                strangerName[0] = queryDocumentSnapshot.getString("name");  
          }
        });
    return arrayOfString[0].split(" ")[0];
  }
  
  private String downloadStrangerCollectionDocument(String paramString1, String paramString2) {
    byte b;
    switch (paramString2.hashCode()) {
      default:
        b = -1;
        break;
      case 2014205639:
        if (paramString2.equals("vehicles")) {
          b = 1;
          break;
        } 
      case 1960295156:
        if (paramString2.equals("goingOut")) {
          b = 2;
          break;
        } 
      case 1876609401:
        if (paramString2.equals("studying")) {
          b = 10;
          break;
        } 
      case 1438428509:
        if (paramString2.equals("filmProduction")) {
          b = 6;
          break;
        } 
      case 1289849005:
        if (paramString2.equals("engineeringProjects")) {
          b = 13;
          break;
        } 
      case 1027739838:
        if (paramString2.equals("musicProduction")) {
          b = 4;
          break;
        } 
      case 763555736:
        if (paramString2.equals("ventFrustration")) {
          b = 7;
          break;
        } 
      case 624751731:
        if (paramString2.equals("programmingProjects")) {
          b = 14;
          break;
        } 
      case -112094084:
        if (paramString2.equals("canoeing")) {
          b = 12;
          break;
        } 
      case -344460952:
        if (paramString2.equals("shopping")) {
          b = 0;
          break;
        } 
      case -731949068:
        if (paramString2.equals("artwork")) {
          b = 5;
          break;
        } 
      case -865698022:
        if (paramString2.equals("travel")) {
          b = 8;
          break;
        } 
      case -895760513:
        if (paramString2.equals("sports")) {
          b = 3;
          break;
        } 
      case -1217273832:
        if (paramString2.equals("hiking")) {
          b = 9;
          break;
        } 
      case -1611025626:
        if (paramString2.equals("videogames")) {
          b = 11;
          break;
        } 
    } 
    switch (b) {
      default:
        return "";
      case 14:
        return downloadDataFromServer(paramString1, this.programmingProjectsCollection);
      case 13:
        return downloadDataFromServer(paramString1, this.engineeringProjectsCollection);
      case 12:
        return downloadDataFromServer(paramString1, this.canoeingCollection);
      case 11:
        return downloadDataFromServer(paramString1, this.videogamesCollection);
      case 10:
        return downloadDataFromServer(paramString1, this.studyingCollection);
      case 9:
        return downloadDataFromServer(paramString1, this.hikingCollection);
      case 8:
        return downloadDataFromServer(paramString1, this.travelingCollection);
      case 7:
        return downloadDataFromServer(paramString1, this.ventingCollection);
      case 6:
        return downloadDataFromServer(paramString1, this.filmProductionCollection);
      case 5:
        return downloadDataFromServer(paramString1, this.artworkArtistCollection);
      case 4:
        return downloadDataFromServer(paramString1, this.musicProductionCollection);
      case 3:
        return downloadDataFromServer(paramString1, this.sportsCollection);
      case 2:
        return downloadDataFromServer(paramString1, this.goingOutForGoodTimeCollection);
      case 1:
        return downloadDataFromServer(paramString1, this.vehicleCollection);
      case 0:
        break;
    } 
    return downloadDataFromServer(paramString1, this.shoppingCollection);
  }
  
  private String downloadStrangerData(String paramString) {
    final String[] strangerCategory = new String[1];
    final String[] blockLine = new String[1];
    this.user_auth_collection.whereEqualTo("userId", paramString).addSnapshotListener(new EventListener<QuerySnapshot>() {
          public void onEvent(QuerySnapshot param1QuerySnapshot, FirebaseFirestoreException param1FirebaseFirestoreException) {
            if (param1FirebaseFirestoreException != null) {
              param1FirebaseFirestoreException.printStackTrace();
            } else if (!param1QuerySnapshot.isEmpty()) {
              for (QueryDocumentSnapshot queryDocumentSnapshot : param1QuerySnapshot) {
                strangerCategory[0] = queryDocumentSnapshot.getString("category");
                blockLine[0] = queryDocumentSnapshot.getString("blockList");
              } 
            } 
          }
        });
    for (String str : arrayOfString2[0].split(",")) {
      if (this.sharedPreferences.getString("currentUser", "").equals(str)) {
        this.userIsBlocked = true;
        break;
      } 
    } 
    return downloadStrangerCollectionDocument(paramString, arrayOfString1[0]);
  }
  
  private String getMonth(String paramString) {
    byte b;
    paramString = paramString.toLowerCase();
    switch (paramString.hashCode()) {
      default:
        b = -1;
        break;
      case 1639129394:
        if (paramString.equals("november")) {
          b = 10;
          break;
        } 
      case 561839141:
        if (paramString.equals("december")) {
          b = 11;
          break;
        } 
      case 103666243:
        if (paramString.equals("march")) {
          b = 2;
          break;
        } 
      case 93031046:
        if (paramString.equals("april")) {
          b = 3;
          break;
        } 
      case 3273794:
        if (paramString.equals("june")) {
          b = 5;
          break;
        } 
      case 3273752:
        if (paramString.equals("july")) {
          b = 6;
          break;
        } 
      case 107877:
        if (paramString.equals("may")) {
          b = 4;
          break;
        } 
      case -263893086:
        if (paramString.equals("february")) {
          b = 1;
          break;
        } 
      case -1406703101:
        if (paramString.equals("august")) {
          b = 7;
          break;
        } 
      case -1621487904:
        if (paramString.equals("october")) {
          b = 9;
          break;
        } 
      case -1826660246:
        if (paramString.equals("january")) {
          b = 0;
          break;
        } 
      case -2029849391:
        if (paramString.equals("september")) {
          b = 8;
          break;
        } 
    } 
    switch (b) {
      default:
        return "";
      case 11:
        return "12";
      case 10:
        return "11";
      case 9:
        return "10";
      case 8:
        return "9";
      case 7:
        return "8";
      case 6:
        return "7";
      case 5:
        return "6";
      case 4:
        return "5";
      case 3:
        return "4";
      case 2:
        return "3";
      case 1:
        return "2";
      case 0:
        break;
    } 
    return "1";
  }
  
  private String getTime(String paramString) {
    String[] arrayOfString1 = paramString.split("at");
    String str2 = arrayOfString1[0].trim();
    arrayOfString1 = arrayOfString1[1].trim().substring(0, 12).split("\\s+");
    String[] arrayOfString2 = arrayOfString1[0].split(":");
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append(arrayOfString2[0]);
    stringBuilder3.append(":");
    stringBuilder3.append(arrayOfString2[1]);
    String str4 = stringBuilder3.toString();
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(str4);
    stringBuilder1.append(" ");
    stringBuilder1.append(arrayOfString1[1]);
    String str1 = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(str2);
    stringBuilder2.append(" ");
    stringBuilder2.append(str1);
    String str3 = stringBuilder2.toString();
    if (!checkDate(str2))
      str1 = str3; 
    return str1;
  }
  
  private void removeStrangerFromBlockList(String paramString) {
    SharedPreferences sharedPreferences = this.sharedPreferences;
    String str = "";
    ArrayList arrayList = new ArrayList(Arrays.asList((Object[])sharedPreferences.getString("blockList", "").split(",")));
    arrayList.remove(paramString);
    Iterator<String> iterator = arrayList.iterator();
    for (paramString = str; iterator.hasNext(); paramString = stringBuilder.toString()) {
      str = iterator.next();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append(",");
      stringBuilder.append(str);
    } 
    this.sharedPreferences.edit().putString("blockList", paramString).apply();
    updateUserCollection();
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
          this.linearLayout.setBackgroundResource(2131230815);
        case 13:
          this.linearLayout.setBackgroundResource(2131230897);
        case 12:
          this.linearLayout.setBackgroundResource(2131230910);
        case 11:
          this.linearLayout.setBackgroundResource(2131230902);
        case 10:
          this.linearLayout.setBackgroundResource(2131230816);
        case 9:
          this.linearLayout.setBackgroundResource(2131230903);
        case 8:
          this.linearLayout.setBackgroundResource(2131230904);
        case 7:
          this.linearLayout.setBackgroundResource(2131230895);
        case 6:
          this.linearLayout.setBackgroundResource(2131230823);
        case 5:
          this.linearLayout.setBackgroundResource(2131230867);
        case 4:
          this.linearLayout.setBackgroundResource(2131230818);
        case 3:
          this.linearLayout.setBackgroundResource(2131230877);
        case 2:
          this.linearLayout.setBackgroundResource(2131230864);
        case 1:
          this.linearLayout.setBackgroundResource(2131230879);
        case 0:
          break;
      } 
      this.linearLayout.setBackgroundResource(2131230878);
    } 
    this.linearLayout.setBackgroundResource(2131230855);
    this.back.setBackgroundResource(2131230854);
    this.back.setTextColor(-1);
    this.blockTextView.setTextColor(-1);
    this.strangerBlockTextView.setTextColor(-1);
  }
  
  private String setGreaterConvKey(String paramString1, String paramString2) {
    int i = paramString1.compareTo(paramString2);
    return (i > 0) ? paramString1 : ((i < 0) ? paramString2 : null);
  }
  
  private String setLesserConvKey(String paramString1, String paramString2) {
    int i = paramString1.compareTo(paramString2);
    return (i > 0) ? paramString2 : ((i < 0) ? paramString1 : null);
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
            Log.d("updateUserData", "success");
          }
        }).addOnFailureListener(new OnFailureListener() {
          public void onFailure(Exception param1Exception) {}
        });
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2131492932);
    if (getSupportActionBar() != null)
      getSupportActionBar().setElevation(0.0F); 
    boolean bool = false;
    this.sharedPreferences = getSharedPreferences("com.infotechnano.sharedpreferences", 0);
    this.linearLayout = (RelativeLayout)findViewById(2131296552);
    this.messageEditText = (EditText)findViewById(2131296551);
    this.blockTextView = (TextView)findViewById(2131296548);
    this.strangerBlockTextView = (TextView)findViewById(2131296560);
    this.sendButton = (ImageButton)findViewById(2131296559);
    this.back = (Button)findViewById(2131296547);
    this.cardView = (CardView)findViewById(2131296550);
    messageThreadRecyclerView = (RecyclerView)findViewById(2131296554);
    messageThreadRecyclerView.setHasFixedSize(true);
    messageThreadRecyclerView.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager((Context)this));
    setColor();
    messageThreadExtra = ((Bundle)Objects.<Bundle>requireNonNull(getIntent().getExtras())).getString("strangerId");
    messageThreadConvKey = combineConvKey(this.sharedPreferences.getString("currentUser", ""), messageThreadExtra);
    this.userIsBlocked = false;
    setTitle(downloadStrangerData(messageThreadExtra));
    this.progressBar.setVisibility(0);
    retrieveNewMessages(messageThreadExtra);
    deleteNewMessagesFromFirebase(messageThreadExtra);
    this.progressBar.setVisibility(4);
    this.userBlockedStranger = false;
    this.userBlockedStranger = checkIfUserBlockedStranger(messageThreadExtra);
    if (!this.userIsBlocked) {
      this.blockTextView.setVisibility(0);
      this.messageEditText.setVisibility(4);
      this.messageEditText.setEnabled(false);
      this.sendButton.setVisibility(4);
      this.sendButton.setEnabled(false);
      this.cardView.setVisibility(4);
      messageThreadRecyclerView.setVisibility(4);
      messageThreadRecyclerView.setEnabled(false);
    } 
    String[] arrayOfString1 = this.sharedPreferences.getString("timeStampList", "").split(">");
    String[] arrayOfString2 = new String[this.finalMessageList.size()];
    byte b;
    for (b = 0; b < this.finalMessageList.size(); b++)
      arrayOfString2[b] = this.finalMessageList.get(b); 
    ArrayList<String> arrayList = new ArrayList();
    for (b = bool; b < arrayOfString2.length; b++) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(arrayOfString2[b]);
      stringBuilder.append("~!~!#!");
      stringBuilder.append(arrayOfString1[b]);
      arrayList.add(stringBuilder.toString());
    } 
    this.finalMessageList = arrayList;
    arrayList = this.finalMessageList;
    if (arrayList != null && arrayList.size() > 0) {
      messageThreadAdapter = new MessageThreadAdapter((Context)this, this.finalMessageList);
      messageThreadRecyclerView.setAdapter((RecyclerView.Adapter)messageThreadAdapter);
      this.sharedPreferences.edit().putString("newMatches", "false").apply();
    } 
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu) {
    getMenuInflater().inflate(2131558403, paramMenu);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public void onMessageThreadBackClicked(View paramView) {
    startActivity(new Intent((Context)this, Chat.class));
    finish();
  }
  
  public void onMessageThreadSendClicked(View paramView) {
    if (this.messageEditText.getText().toString().trim() != null && !this.messageEditText.getText().toString().trim().equals("")) {
      String str3 = checkMessageFormat(this.messageEditText.getText().toString().trim());
      final String[] previousMessage = new String[1];
      arrayOfString[0] = "";
      this.chatCollection.whereEqualTo("conversation", messageThreadConvKey).addSnapshotListener(new EventListener<QuerySnapshot>() {
            public void onEvent(QuerySnapshot param1QuerySnapshot, FirebaseFirestoreException param1FirebaseFirestoreException) {
              if (param1FirebaseFirestoreException != null)
                param1FirebaseFirestoreException.printStackTrace(); 
              if (!param1QuerySnapshot.isEmpty())
                for (QueryDocumentSnapshot queryDocumentSnapshot : param1QuerySnapshot) {
                  if (queryDocumentSnapshot.getString("message") != null && !queryDocumentSnapshot.getString("message").equals(""))
                    previousMessage[0] = queryDocumentSnapshot.getString("message"); 
                }  
            }
          });
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(this.sharedPreferences.getString(messageThreadConvKey, ""));
      stringBuilder1.append(">");
      stringBuilder1.append(str3);
      String str1 = stringBuilder1.toString();
      this.sharedPreferences.edit().putString(messageThreadConvKey, str1).apply();
      byte b = 0;
      str1 = str3;
      if (!arrayOfString[0].equals("")) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(arrayOfString[0]);
        stringBuilder.append(">");
        stringBuilder.append(str3);
        str1 = stringBuilder.toString();
      } 
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(str1);
      stringBuilder2.append("!#!");
      stringBuilder2.append(this.sharedPreferences.getString("currentUser", ""));
      String str2 = stringBuilder2.toString();
      str1 = (new Timestamp(new Date())).toString();
      String str4 = this.sharedPreferences.getString("timeStampList", "");
      StringBuilder stringBuilder3 = new StringBuilder();
      stringBuilder3.append(str4);
      stringBuilder3.append(">");
      stringBuilder3.append(str1);
      str4 = stringBuilder3.toString();
      this.sharedPreferences.edit().putString("timeStampList", str4).apply();
      HashMap<Object, Object> hashMap = new HashMap<>();
      hashMap.put("conversation", messageThreadConvKey);
      hashMap.put("message", str2);
      hashMap.put("time", str1);
      this.chatCollection.document(messageThreadConvKey).set(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
            public void onSuccess(Void param1Void) {
              Log.d("uploadData", "success");
            }
          }).addOnFailureListener(new OnFailureListener() {
            public void onFailure(Exception param1Exception) {}
          });
      this.messageEditText.setText("");
      ArrayList arrayList = new ArrayList(Arrays.asList((Object[])str2.split(">")));
      this.sharedPreferences.getString("timeStampList", "").split(">");
      ArrayList<String> arrayList1 = new ArrayList(Arrays.asList((Object[])this.sharedPreferences.getString(messageThreadConvKey, "").split(">")));
      arrayList1.addAll(arrayList);
      ArrayList<String> arrayList2 = new ArrayList();
      while (b < arrayList.size()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(arrayList1.get(b));
        stringBuilder.append("~!~!#!");
        stringBuilder.append(str1);
        arrayList2.add(stringBuilder.toString());
        b++;
      } 
      this.finalMessageList.addAll(arrayList2);
      messageThreadAdapter.notifyDataSetChanged();
    } 
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
    if (paramMenuItem.getItemId() == 2131296561)
      if (this.userBlockedStranger) {
        removeStrangerFromBlockList(messageThreadExtra);
        startActivity(new Intent((Context)this, MessageThread.class));
      } else {
        blockStranger(messageThreadExtra);
        startActivity(new Intent((Context)this, MessageThread.class));
      }  
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  protected void onStart() {
    super.onStart();
    messageThreadActive = true;
  }
  
  protected void onStop() {
    super.onStop();
    messageThreadActive = false;
  }
  
  public void retrieveNewMessages(String paramString) {
    final String[] conversation = new String[1];
    final String[] timeStamp = new String[1];
    String str3 = combineConvKey(this.sharedPreferences.getString("currentUser", ""), paramString);
    this.chatCollection.whereEqualTo("conversation", str3).addSnapshotListener(new EventListener<QuerySnapshot>() {
          public void onEvent(QuerySnapshot param1QuerySnapshot, FirebaseFirestoreException param1FirebaseFirestoreException) {
            if (param1FirebaseFirestoreException != null)
              param1FirebaseFirestoreException.printStackTrace(); 
            if (!param1QuerySnapshot.isEmpty())
              for (QueryDocumentSnapshot queryDocumentSnapshot : param1QuerySnapshot) {
                conversation[0] = queryDocumentSnapshot.getString("message");
                timeStamp[0] = queryDocumentSnapshot.getString("timeStampList");
              }  
          }
        });
    boolean bool = false;
    arrayOfString3 = arrayOfString3[0].split("!#!")[0].split(">");
    String[] arrayOfString2 = this.sharedPreferences.getString(str3, "").split(">");
    ArrayList arrayList1 = new ArrayList(Arrays.asList((Object[])arrayOfString3));
    ArrayList<? extends String> arrayList = new ArrayList(Arrays.asList((Object[])arrayOfString2));
    arrayList.addAll(arrayList1);
    this.finalMessageList.addAll(arrayList);
    byte b = 0;
    String str2 = "";
    while (b < arrayList.size()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str2);
      stringBuilder.append(">");
      stringBuilder.append(arrayList.get(b));
      str2 = stringBuilder.toString();
      b++;
    } 
    this.sharedPreferences.edit().putString(str3, str2).apply();
    String[] arrayOfString1 = arrayOfString4[0].split(">");
    arrayOfString4 = new String[arrayOfString1.length];
    for (b = 0; b < arrayOfString1.length; b++) {
      if (arrayOfString1[b].contains("at")) {
        arrayOfString4[b] = getTime(arrayOfString1[b]);
      } else {
        arrayOfString4[b] = arrayOfString1[b];
      } 
    } 
    String str1 = this.sharedPreferences.getString("timeStampList", "");
    int i = arrayOfString4.length;
    for (b = bool; b < i; b++) {
      String str = arrayOfString4[b];
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str1);
      stringBuilder.append(">");
      stringBuilder.append(str);
      str1 = stringBuilder.toString();
    } 
    this.sharedPreferences.edit().putString("timeStampList", str1).apply();
  }
}