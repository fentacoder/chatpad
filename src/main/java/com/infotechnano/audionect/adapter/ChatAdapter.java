package com.infotechnano.audionect.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;
import com.infotechnano.audionect.Chat;
import com.infotechnano.audionect.GetImageFromUrl;
import com.infotechnano.audionect.MessageThread;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {
  public static int newMessageNum;
  
  private CollectionReference artworkArtistCollection = this.db.collection("artwork");
  
  private CollectionReference canoeingCollection = this.db.collection("canoeing");
  
  private CollectionReference chatCollection = this.db.collection("Chat");
  
  private List<String> chatList;
  
  private Context context;
  
  private FirebaseFirestore db = FirebaseFirestore.getInstance();
  
  private CollectionReference engineeringProjectsCollection = this.db.collection("engineeringProjects");
  
  private CollectionReference filmProductionCollection = this.db.collection("filmProduction");
  
  private CollectionReference goingOutForGoodTimeCollection = this.db.collection("goingOutForGoodTime");
  
  private CollectionReference hikingCollection = this.db.collection("hiking");
  
  private CollectionReference musicProductionCollection = this.db.collection("musicProduction");
  
  private CollectionReference programmingProjectsCollection = this.db.collection("programmingProjects");
  
  private SharedPreferences sharedPreferences;
  
  private CollectionReference shoppingCollection = this.db.collection("shopping");
  
  private CollectionReference sportsCollection = this.db.collection("sports");
  
  private CollectionReference studyingCollection = this.db.collection("studying");
  
  private CollectionReference travelingCollection = this.db.collection("traveling");
  
  private CollectionReference user_auth_collection = this.db.collection("Users");
  
  private CollectionReference vehicleCollection = this.db.collection("vehicles");
  
  private CollectionReference ventingCollection = this.db.collection("ventingFrustration");
  
  private CollectionReference videogamesCollection = this.db.collection("videogames");
  
  public ChatAdapter(Context paramContext, List<String> paramList) {
    this.context = paramContext;
    this.chatList = paramList;
    this.sharedPreferences = paramContext.getSharedPreferences("com.infotechnano.sharedpreferences", 0);
  }
  
  private boolean checkForNewMessage(String paramString) {
    final String[] message = new String[1];
    this.chatCollection.whereEqualTo("conversation", paramString).addSnapshotListener(new EventListener<QuerySnapshot>() {
          public void onEvent(QuerySnapshot param1QuerySnapshot, FirebaseFirestoreException param1FirebaseFirestoreException) {
            if (param1FirebaseFirestoreException != null)
              param1FirebaseFirestoreException.printStackTrace(); 
            if (!param1QuerySnapshot.isEmpty())
              for (QueryDocumentSnapshot queryDocumentSnapshot : param1QuerySnapshot)
                message[0] = queryDocumentSnapshot.getString("message");  
          }
        });
    return (arrayOfString[0] != null && !arrayOfString[0].equals(""));
  }
  
  private String combineConvKey(String paramString1, String paramString2) {
    String str = setLesserConvKey(paramString1, paramString2);
    paramString2 = setGreaterConvKey(paramString1, paramString2);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append(">");
    stringBuilder.append(paramString2);
    return stringBuilder.toString();
  }
  
  private void deleteThread(final ArrayList<String> cList, final int rowPos) {
    (new AlertDialog.Builder(this.context)).setTitle(this.context.getString(2131689524)).setMessage(this.context.getString(2131689591)).setPositiveButton(this.context.getString(2131689742), new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            cList.remove(rowPos);
            Collections.reverse(cList);
            Iterator<String> iterator = cList.iterator();
            String str;
            for (str = ""; iterator.hasNext(); str = stringBuilder.toString()) {
              String str1 = iterator.next();
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(str);
              stringBuilder.append(str1);
              stringBuilder.append(",");
            } 
            ChatAdapter.this.sharedPreferences.edit().putString("chatList", str).apply();
            ChatAdapter chatAdapter = ChatAdapter.this;
            chatAdapter.updateChatList(chatAdapter.sharedPreferences.getString("chatList", ""));
            Intent intent = new Intent(ChatAdapter.this.context, Chat.class);
            ChatAdapter.this.context.startActivity(intent);
          }
        }).setNegativeButton(this.context.getString(2131689647), new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {}
        }).create().show();
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
  
  private String downloadStrangerCategory(String paramString) {
    final String[] category = new String[1];
    this.user_auth_collection.whereEqualTo("userId", paramString).addSnapshotListener(new EventListener<QuerySnapshot>() {
          public void onEvent(QuerySnapshot param1QuerySnapshot, FirebaseFirestoreException param1FirebaseFirestoreException) {
            if (param1FirebaseFirestoreException != null)
              param1FirebaseFirestoreException.printStackTrace(); 
            if (!param1QuerySnapshot.isEmpty())
              for (QueryDocumentSnapshot queryDocumentSnapshot : param1QuerySnapshot)
                category[0] = queryDocumentSnapshot.getString("category");  
          }
        });
    return arrayOfString[0];
  }
  
  private String downloadStrangerCollectionDocument(String paramString1, String paramString2) {
    byte b;
    switch (paramString2.hashCode()) {
      default:
        b = -1;
        break;
      case 1960295156:
        if (paramString2.equals("goingOut")) {
          b = 1;
          break;
        } 
      case 1876609401:
        if (paramString2.equals("studying")) {
          b = 9;
          break;
        } 
      case 1438428509:
        if (paramString2.equals("filmProduction")) {
          b = 5;
          break;
        } 
      case 1289849005:
        if (paramString2.equals("engineeringProjects")) {
          b = 12;
          break;
        } 
      case 1027739838:
        if (paramString2.equals("musicProduction")) {
          b = 3;
          break;
        } 
      case 763555736:
        if (paramString2.equals("ventFrustration")) {
          b = 6;
          break;
        } 
      case 624751731:
        if (paramString2.equals("programmingProjects")) {
          b = 13;
          break;
        } 
      case -112094084:
        if (paramString2.equals("canoeing")) {
          b = 11;
          break;
        } 
      case -344460952:
        if (paramString2.equals("shopping")) {
          b = 0;
          break;
        } 
      case -731949068:
        if (paramString2.equals("artwork")) {
          b = 4;
          break;
        } 
      case -865698022:
        if (paramString2.equals("travel")) {
          b = 7;
          break;
        } 
      case -895760513:
        if (paramString2.equals("sports")) {
          b = 2;
          break;
        } 
      case -1217273832:
        if (paramString2.equals("hiking")) {
          b = 8;
          break;
        } 
      case -1611025626:
        if (paramString2.equals("videogames")) {
          b = 10;
          break;
        } 
    } 
    switch (b) {
      default:
        return "";
      case 13:
        return downloadDataFromServer(paramString1, this.programmingProjectsCollection);
      case 12:
        return downloadDataFromServer(paramString1, this.engineeringProjectsCollection);
      case 11:
        return downloadDataFromServer(paramString1, this.canoeingCollection);
      case 10:
        return downloadDataFromServer(paramString1, this.videogamesCollection);
      case 9:
        return downloadDataFromServer(paramString1, this.studyingCollection);
      case 8:
        return downloadDataFromServer(paramString1, this.hikingCollection);
      case 7:
        return downloadDataFromServer(paramString1, this.travelingCollection);
      case 6:
        return downloadDataFromServer(paramString1, this.ventingCollection);
      case 5:
        return downloadDataFromServer(paramString1, this.filmProductionCollection);
      case 4:
        return downloadDataFromServer(paramString1, this.artworkArtistCollection);
      case 3:
        return downloadDataFromServer(paramString1, this.musicProductionCollection);
      case 2:
        return downloadDataFromServer(paramString1, this.sportsCollection);
      case 1:
        return downloadDataFromServer(paramString1, this.goingOutForGoodTimeCollection);
      case 0:
        break;
    } 
    return downloadDataFromServer(paramString1, this.shoppingCollection);
  }
  
  private String downloadStrangerData(CollectionReference paramCollectionReference, String paramString) {
    final String[] imageListToGet = new String[1];
    paramCollectionReference.whereEqualTo("userId", paramString).addSnapshotListener(new EventListener<QuerySnapshot>() {
          public void onEvent(QuerySnapshot param1QuerySnapshot, FirebaseFirestoreException param1FirebaseFirestoreException) {
            if (param1FirebaseFirestoreException != null)
              param1FirebaseFirestoreException.printStackTrace(); 
            if (!param1QuerySnapshot.isEmpty())
              for (QueryDocumentSnapshot queryDocumentSnapshot : param1QuerySnapshot)
                imageListToGet[0] = queryDocumentSnapshot.getString("urlList");  
          }
        });
    return arrayOfString[0];
  }
  
  private String getMessagePreview(String paramString) {
    final String[] messagePreviewArray = new String[1];
    paramString = combineConvKey(this.sharedPreferences.getString("currentUser", ""), paramString);
    this.chatCollection.whereEqualTo("conversation", paramString).addSnapshotListener(new EventListener<QuerySnapshot>() {
          public void onEvent(QuerySnapshot param1QuerySnapshot, FirebaseFirestoreException param1FirebaseFirestoreException) {
            if (param1FirebaseFirestoreException != null)
              param1FirebaseFirestoreException.printStackTrace(); 
            if (!param1QuerySnapshot.isEmpty())
              for (QueryDocumentSnapshot queryDocumentSnapshot : param1QuerySnapshot) {
                if (queryDocumentSnapshot.getString("message") != null && !queryDocumentSnapshot.getString("message").equals("")) {
                  messagePreviewArray[0] = queryDocumentSnapshot.getString("message");
                  continue;
                } 
                messagePreviewArray[0] = "";
              }  
          }
        });
    paramString = arrayOfString[0];
    if (paramString.length() > 17) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString.substring(0, 14));
      stringBuilder.append("...");
      return stringBuilder.toString();
    } 
    return paramString;
  }
  
  private String getStrangerName(String paramString) {
    final String[] strangerCategory = new String[1];
    this.user_auth_collection.whereEqualTo("userId", paramString).addSnapshotListener(new EventListener<QuerySnapshot>() {
          public void onEvent(QuerySnapshot param1QuerySnapshot, FirebaseFirestoreException param1FirebaseFirestoreException) {
            if (param1FirebaseFirestoreException != null)
              param1FirebaseFirestoreException.printStackTrace(); 
            if (!param1QuerySnapshot.isEmpty())
              for (QueryDocumentSnapshot queryDocumentSnapshot : param1QuerySnapshot)
                strangerCategory[0] = queryDocumentSnapshot.getString("category");  
          }
        });
    return downloadStrangerCollectionDocument(paramString, arrayOfString[0]);
  }
  
  private String getStrangerPic(String paramString1, String paramString2) {
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
        return downloadStrangerData(this.programmingProjectsCollection, paramString1);
      case 13:
        return downloadStrangerData(this.engineeringProjectsCollection, paramString1);
      case 12:
        return downloadStrangerData(this.canoeingCollection, paramString1);
      case 11:
        return downloadStrangerData(this.videogamesCollection, paramString1);
      case 10:
        return downloadStrangerData(this.studyingCollection, paramString1);
      case 9:
        return downloadStrangerData(this.hikingCollection, paramString1);
      case 8:
        return downloadStrangerData(this.travelingCollection, paramString1);
      case 7:
        return downloadStrangerData(this.ventingCollection, paramString1);
      case 6:
        return downloadStrangerData(this.filmProductionCollection, paramString1);
      case 5:
        return downloadStrangerData(this.artworkArtistCollection, paramString1);
      case 4:
        return downloadStrangerData(this.musicProductionCollection, paramString1);
      case 3:
        return downloadStrangerData(this.sportsCollection, paramString1);
      case 2:
        return downloadStrangerData(this.goingOutForGoodTimeCollection, paramString1);
      case 1:
        return downloadStrangerData(this.vehicleCollection, paramString1);
      case 0:
        break;
    } 
    return downloadStrangerData(this.shoppingCollection, paramString1);
  }
  
  private String setGreaterConvKey(String paramString1, String paramString2) {
    int i = paramString1.compareTo(paramString2);
    return (i > 0) ? paramString1 : ((i < 0) ? paramString2 : null);
  }
  
  private String setLesserConvKey(String paramString1, String paramString2) {
    int i = paramString1.compareTo(paramString2);
    return (i > 0) ? paramString2 : ((i < 0) ? paramString1 : null);
  }
  
  private void updateChatList(String paramString) {
    final String[] username = new String[1];
    final String[] password = new String[1];
    final String[] category = new String[1];
    final String[] email = new String[1];
    final String[] phoneNumber = new String[1];
    final String[] genderPref = new String[1];
    final String[] notificationFlag = new String[1];
    final String[] chatterPlan = new String[1];
    final String[] extrovertPlan = new String[1];
    final String[] platinumPlan = new String[1];
    final String[] newMessages = new String[1];
    final String[] newMatches = new String[1];
    final String[] paymentOption = new String[1];
    final String[] paymentToken = new String[1];
    final String[] blockList = new String[1];
    this.user_auth_collection.whereEqualTo("userId", this.sharedPreferences.getString("currentUser", "")).addSnapshotListener(new EventListener<QuerySnapshot>() {
          public void onEvent(QuerySnapshot param1QuerySnapshot, FirebaseFirestoreException param1FirebaseFirestoreException) {
            if (param1FirebaseFirestoreException != null)
              param1FirebaseFirestoreException.printStackTrace(); 
            if (!param1QuerySnapshot.isEmpty())
              for (QueryDocumentSnapshot queryDocumentSnapshot : param1QuerySnapshot) {
                username[0] = queryDocumentSnapshot.getString("username");
                password[0] = queryDocumentSnapshot.getString("password");
                category[0] = queryDocumentSnapshot.getString("category");
                email[0] = queryDocumentSnapshot.getString("email");
                phoneNumber[0] = queryDocumentSnapshot.getString("phoneNumber");
                genderPref[0] = queryDocumentSnapshot.getString("genderPref");
                notificationFlag[0] = queryDocumentSnapshot.getString("notificationFlag");
                chatterPlan[0] = queryDocumentSnapshot.getString("chatterPlan");
                extrovertPlan[0] = queryDocumentSnapshot.getString("extrovertPlan");
                platinumPlan[0] = queryDocumentSnapshot.getString("platinumPlan");
                newMessages[0] = queryDocumentSnapshot.getString("newMessages");
                newMatches[0] = queryDocumentSnapshot.getString("newMatches");
                paymentOption[0] = queryDocumentSnapshot.getString("paymentOption");
                paymentToken[0] = queryDocumentSnapshot.getString("paymentToken");
                if (queryDocumentSnapshot.getString("blockList") != null && !queryDocumentSnapshot.getString("blockList").equals("")) {
                  blockList[0] = queryDocumentSnapshot.getString("blockList");
                  continue;
                } 
                blockList[0] = "";
              }  
          }
        });
    HashMap<Object, Object> hashMap = new HashMap<>();
    hashMap.put("userId", this.sharedPreferences.getString("currentUser", ""));
    hashMap.put("username", arrayOfString1[0]);
    hashMap.put("password", arrayOfString2[0]);
    hashMap.put("category", arrayOfString3[0]);
    hashMap.put("email", arrayOfString4[0]);
    hashMap.put("phoneNumber", arrayOfString5[0]);
    hashMap.put("genderPref", arrayOfString6[0]);
    hashMap.put("notificationFlag", arrayOfString7[0]);
    hashMap.put("chatterPlan", arrayOfString8[0]);
    hashMap.put("extrovertPlan", arrayOfString9[0]);
    hashMap.put("platinumPlan", arrayOfString10[0]);
    hashMap.put("newMessages", arrayOfString11[0]);
    hashMap.put("newMatches", arrayOfString12[0]);
    hashMap.put("chatUsers", paramString);
    hashMap.put("paymentOption", arrayOfString13[0]);
    hashMap.put("paymentToken", arrayOfString14[0]);
    hashMap.put("blockList", arrayOfString15[0]);
    hashMap.put("bolt", this.sharedPreferences.getString("bolt", "false"));
    hashMap.put("boltPeriod", this.sharedPreferences.getString("boltPeriod", ""));
    hashMap.put("securityKey", this.sharedPreferences.getString("securityKey", ""));
    this.user_auth_collection.document(this.sharedPreferences.getString("currentUser", "")).set(hashMap, SetOptions.merge()).addOnSuccessListener(new OnSuccessListener<Void>() {
          public void onSuccess(Void param1Void) {
            Log.d("userChatList", "succcess");
          }
        }).addOnFailureListener(new OnFailureListener() {
          public void onFailure(Exception param1Exception) {}
        });
  }
  
  public int getItemCount() {
    return this.chatList.size();
  }
  
  public void onBindViewHolder(ChatViewHolder paramChatViewHolder, int paramInt) {
    paramChatViewHolder.chatNameTextView.setText(getStrangerName(this.chatList.get(paramInt)));
    paramChatViewHolder.chatPreviewTextView.setText(getMessagePreview(this.chatList.get(paramInt)));
    if (checkForNewMessage(combineConvKey(this.sharedPreferences.getString("currentUser", ""), this.chatList.get(paramInt)))) {
      paramChatViewHolder.chatRowBlueDot.setVisibility(0);
      newMessageNum++;
    } else {
      paramChatViewHolder.chatRowBlueDot.setVisibility(4);
    } 
    String str = downloadStrangerCategory(this.chatList.get(paramInt));
    String[] arrayOfString = getStrangerPic(this.chatList.get(paramInt), str).split(",");
    if (arrayOfString[0] != null && !arrayOfString[0].equals("")) {
      (new GetImageFromUrl(paramChatViewHolder.chatNameImage)).execute((Object[])new String[] { arrayOfString[0] });
    } else if (arrayOfString[1] != null && !arrayOfString[1].equals("")) {
      (new GetImageFromUrl(paramChatViewHolder.chatNameImage)).execute((Object[])new String[] { arrayOfString[1] });
    } else if (arrayOfString[2] != null && !arrayOfString[2].equals("")) {
      (new GetImageFromUrl(paramChatViewHolder.chatNameImage)).execute((Object[])new String[] { arrayOfString[2] });
    } 
  }
  
  public ChatViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt) {
    return new ChatViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131492906, paramViewGroup, false));
  }
  
  public class ChatViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public ImageView chatNameImage;
    
    public TextView chatNameTextView;
    
    public TextView chatPreviewTextView;
    
    public ImageView chatRowBlueDot;
    
    public ImageButton chatRowDelete;
    
    public RelativeLayout chatRowLayout;
    
    public ChatViewHolder(View param1View) {
      super(param1View);
      this.chatNameImage = (ImageView)param1View.findViewById(2131296382);
      this.chatNameTextView = (TextView)param1View.findViewById(2131296384);
      this.chatPreviewTextView = (TextView)param1View.findViewById(2131296385);
      this.chatRowDelete = (ImageButton)param1View.findViewById(2131296381);
      this.chatRowBlueDot = (ImageView)param1View.findViewById(2131296380);
      this.chatRowLayout = (RelativeLayout)param1View.findViewById(2131296383);
      this.chatRowDelete.setOnClickListener(this);
      this.chatRowLayout.setOnClickListener(this);
      this.chatRowBlueDot.setOnClickListener(this);
      this.chatNameImage.setOnClickListener(this);
      this.chatNameTextView.setOnClickListener(this);
      this.chatPreviewTextView.setOnClickListener(this);
    }
    
    public void onClick(View param1View) {
      int i = getAdapterPosition();
      if (param1View.getId() == 2131296381) {
        ChatAdapter chatAdapter = ChatAdapter.this;
        chatAdapter.deleteThread((ArrayList)chatAdapter.chatList, i);
      } else {
        Intent intent = new Intent(ChatAdapter.this.context, MessageThread.class);
        intent.putExtra("strangerId", ChatAdapter.this.chatList.get(i));
        ChatAdapter.this.context.startActivity(intent);
      } 
    }
  }
}
