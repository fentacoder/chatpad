package com.jamar.audionect.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.jamar.audionect.MessageThread;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MessageThreadAdapter extends RecyclerView.Adapter<MessageThreadAdapter.MessageThreadViewHolder> {
  private CollectionReference chatCollection = this.db.collection("Chat");
  
  private Context context;
  
  private String convKey = MessageThread.messageThreadConvKey;
  
  private FirebaseFirestore db = FirebaseFirestore.getInstance();
  
  private int messageNumber;
  
  private List<String> messageThreadList;
  
  private ArrayList<String> pureMessageList = new ArrayList<>();
  
  private SharedPreferences sharedPreferences;
  
  private ArrayList<String> timeList = new ArrayList<>();
  
  public MessageThreadAdapter(Context paramContext, List<String> paramList) {
    this.context = paramContext;
    this.messageThreadList = paramList;
    this.sharedPreferences = paramContext.getSharedPreferences("com.jamar.sharedpreferences", 0);
    ArrayList<String> arrayList = (ArrayList)paramList;
    this.pureMessageList = createMessageList(arrayList);
    this.timeList = createTimeList(arrayList);
  }
  
  private void addCorrectTimeStamp(String paramString) {
    byte b = 0;
    while (true) {
      int i = this.messageNumber;
      boolean bool = true;
      if (b < i - 1) {
        this.timeList.add(paramString);
        b++;
        continue;
      } 
      paramString = this.timeList.get(0);
      for (b = bool; b < this.timeList.size(); b++) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramString);
        stringBuilder.append(">");
        stringBuilder.append(this.timeList.get(b));
        paramString = stringBuilder.toString();
      } 
      this.sharedPreferences.edit().putString("timeStampList", paramString).apply();
      return;
    } 
  }
  
  private int countMessages(String paramString) {
    return (paramString.split(">")).length;
  }
  
  private ArrayList<String> createMessageList(ArrayList<String> paramArrayList) {
    ArrayList<String> arrayList = new ArrayList();
    for (byte b = 0; b < paramArrayList.size(); b++)
      arrayList.addAll(Arrays.asList(((String)paramArrayList.get(b)).split("~!~!#!")[0].split(">"))); 
    return arrayList;
  }
  
  private ArrayList<String> createTimeList(ArrayList<String> paramArrayList) {
    ArrayList<String> arrayList = new ArrayList();
    for (byte b = 0; b < paramArrayList.size(); b++)
      arrayList.add(((String)paramArrayList.get(b)).split("~!~!#!")[1]); 
    return arrayList;
  }
  
  private void deleteMessageFromThread(int paramInt) {
    SharedPreferences sharedPreferences = this.sharedPreferences;
    String str1 = this.convKey;
    String str2 = "";
    ArrayList<String> arrayList = new ArrayList(Arrays.asList((Object[])sharedPreferences.getString(str1, "").split(">")));
    arrayList.remove(paramInt);
    for (paramInt = 0; paramInt < arrayList.size(); paramInt++) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str2);
      stringBuilder.append(">");
      stringBuilder.append(arrayList.get(paramInt));
      str2 = stringBuilder.toString();
    } 
    this.sharedPreferences.edit().putString(this.convKey, str2).apply();
    Context context = this.context;
    context.startActivity(new Intent(context, MessageThread.class));
  }
  
  private String getMessage() {
    final String[] message = new String[1];
    arrayOfString1[0] = "";
    final String[] time = new String[1];
    arrayOfString2[0] = "";
    this.chatCollection.whereEqualTo("conversation", this.convKey).addSnapshotListener(new EventListener<QuerySnapshot>() {
          public void onEvent(QuerySnapshot param1QuerySnapshot, FirebaseFirestoreException param1FirebaseFirestoreException) {
            if (param1FirebaseFirestoreException != null) {
              param1FirebaseFirestoreException.printStackTrace();
            } else if (!param1QuerySnapshot.isEmpty()) {
              for (QueryDocumentSnapshot queryDocumentSnapshot : param1QuerySnapshot) {
                if (queryDocumentSnapshot.getString("time") != null && !queryDocumentSnapshot.getString("time").equals("")) {
                  message[0] = queryDocumentSnapshot.getString("message");
                  time[0] = queryDocumentSnapshot.getString("time");
                } 
              } 
            } 
          }
        });
    this.messageNumber = countMessages(arrayOfString1[0]);
    if (this.messageNumber > 1)
      addCorrectTimeStamp(arrayOfString2[0]); 
    return arrayOfString1[0];
  }
  
  public int getItemCount() {
    return this.messageThreadList.size();
  }
  
  public void onBindViewHolder(MessageThreadViewHolder paramMessageThreadViewHolder, int paramInt) {
    paramMessageThreadViewHolder.leftText.setVisibility(0);
    paramMessageThreadViewHolder.rightText.setVisibility(0);
    paramMessageThreadViewHolder.leftText.setEnabled(true);
    paramMessageThreadViewHolder.rightText.setEnabled(true);
    paramMessageThreadViewHolder.leftTime.setVisibility(0);
    paramMessageThreadViewHolder.rightTime.setVisibility(0);
    paramMessageThreadViewHolder.leftText.setText("");
    paramMessageThreadViewHolder.rightText.setText("");
    if (getMessage().split("!#!")[1].equals(this.sharedPreferences.getString("currentUser", ""))) {
      paramMessageThreadViewHolder.leftText.setText(this.pureMessageList.get(paramInt));
      paramMessageThreadViewHolder.leftTime.setText(this.timeList.get(paramInt));
      paramMessageThreadViewHolder.rightText.setVisibility(4);
      paramMessageThreadViewHolder.rightText.setEnabled(false);
      paramMessageThreadViewHolder.rightTime.setVisibility(4);
    } else {
      paramMessageThreadViewHolder.rightText.setText(this.pureMessageList.get(paramInt));
      paramMessageThreadViewHolder.rightTime.setText(this.timeList.get(paramInt));
      paramMessageThreadViewHolder.leftText.setVisibility(4);
      paramMessageThreadViewHolder.leftText.setEnabled(false);
      paramMessageThreadViewHolder.leftTime.setVisibility(4);
    } 
  }
  
  public MessageThreadViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt) {
    return new MessageThreadViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131492933, paramViewGroup, false));
  }
  
  public class MessageThreadViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener {
    TextView leftText;
    
    TextView leftTime;
    
    TextView rightText;
    
    TextView rightTime;
    
    MessageThreadViewHolder(View param1View) {
      super(param1View);
      this.leftText = (TextView)param1View.findViewById(2131296556);
      this.rightText = (TextView)param1View.findViewById(2131296558);
      this.leftTime = (TextView)param1View.findViewById(2131296553);
      this.rightTime = (TextView)param1View.findViewById(2131296555);
      this.leftText.setOnLongClickListener(this);
      this.rightText.setOnLongClickListener(this);
    }
    
    public boolean onLongClick(View param1View) {
      final int position = getAdapterPosition();
      (new AlertDialog.Builder(param1View.getRootView().getContext())).setTitle(MessageThreadAdapter.this.context.getString(2131689524)).setMessage(MessageThreadAdapter.this.context.getString(2131689589)).setPositiveButton(MessageThreadAdapter.this.context.getString(2131689742), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface param2DialogInterface, int param2Int) {
              MessageThreadAdapter.this.deleteMessageFromThread(position);
            }
          }).setNegativeButton(MessageThreadAdapter.this.context.getString(2131689647), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface param2DialogInterface, int param2Int) {}
          }).create().show();
      return true;
    }
  }
  
  class null implements DialogInterface.OnClickListener {
    public void onClick(DialogInterface param1DialogInterface, int param1Int) {}
  }
  
  class null implements DialogInterface.OnClickListener {
    public void onClick(DialogInterface param1DialogInterface, int param1Int) {
      MessageThreadAdapter.this.deleteMessageFromThread(position);
    }
  }
}
