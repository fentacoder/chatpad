package com.infotechnano.audionect.classesNotBeingUsed;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.infotechnano.audionect.MainActivity;
import java.util.ArrayList;
import java.util.HashSet;

public class SignUpShowMeScreen extends AppCompatActivity {
  private String allItems;
  
  private String allItemsSelected;
  
  private String artist;
  
  private String artwork;
  
  private String brass;
  
  private ArrayList<String> categoryArrayList = new ArrayList<>();
  
  private Button continueButton;
  
  private ArrayList<String> copyList = new ArrayList<>();
  
  private String guitar;
  
  private String isSelected;
  
  private String itemsSelected;
  
  private ArrayList<String> itemsSelectedList = new ArrayList<>();
  
  private String itemsShow;
  
  private String listItem;
  
  private String orchestral;
  
  private String percussion;
  
  private String piano;
  
  private String producer;
  
  private String selectAll;
  
  private ListView signUpShowMeListView;
  
  private SQLiteDatabase sqLiteDatabase;
  
  private SQLiteStatement sqLiteStatement;
  
  private String sqlLine = "INSERT INTO profilesToShow (categoryList) VALUES (?)";
  
  private TextView userTypeSelectedTextView;
  
  private String woodwind;
  
  private ArrayList<String> checkIfContains(ArrayList<String> paramArrayList, String paramString) {
    byte b = 0;
    int i;
    for (i = 0; b < paramArrayList.size(); i = j) {
      int j = i;
      if (((String)paramArrayList.get(b)).equals(this.listItem))
        j = i + 1; 
      b++;
    } 
    if (i != 1) {
      HashSet<String> hashSet = new HashSet<>(paramArrayList);
      paramArrayList.clear();
      paramArrayList.addAll(hashSet);
      paramArrayList.remove(paramArrayList.indexOf(this.listItem));
    } 
    return paramArrayList;
  }
  
  private String showItemsSelected(ArrayList<String> paramArrayList) {
    byte b = 0;
    String str = "";
    while (b < paramArrayList.size()) {
      if (str.equals("")) {
        str = paramArrayList.get(b);
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(", ");
        stringBuilder.append(paramArrayList.get(b));
        str = stringBuilder.toString();
      } 
      b++;
    } 
    return str;
  }
  
  private String showOriginalList(ArrayList<String> paramArrayList) {
    byte b = 0;
    paramArrayList.remove(0);
    String str = "";
    while (b < paramArrayList.size()) {
      if (str.equals("")) {
        str = paramArrayList.get(b);
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(", ");
        stringBuilder.append(paramArrayList.get(b));
        str = stringBuilder.toString();
      } 
      b++;
    } 
    return str;
  }
  
  private String turnListToString(ArrayList<String> paramArrayList) {
    String str = "";
    for (byte b = 0; b < paramArrayList.size(); b++) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      stringBuilder.append(paramArrayList.get(b));
      stringBuilder.append(", ");
      str = stringBuilder.toString();
    } 
    return str.substring(0, str.length() - 2);
  }
  
  public void onBackPressed() {
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.categoryArrayList.add(this.selectAll);
    this.categoryArrayList.add(this.producer);
    this.categoryArrayList.add(this.artist);
    this.categoryArrayList.add(this.artwork);
    this.categoryArrayList.add(this.guitar);
    this.categoryArrayList.add(this.piano);
    this.categoryArrayList.add(this.woodwind);
    this.categoryArrayList.add(this.brass);
    this.categoryArrayList.add(this.orchestral);
    this.categoryArrayList.add(this.percussion);
    ArrayAdapter arrayAdapter = new ArrayAdapter((Context)this, 17367043, this.categoryArrayList);
    this.signUpShowMeListView.setAdapter((ListAdapter)arrayAdapter);
    this.signUpShowMeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
            SignUpShowMeScreen signUpShowMeScreen = SignUpShowMeScreen.this;
            SignUpShowMeScreen.access$002(signUpShowMeScreen, signUpShowMeScreen.categoryArrayList.get(param1Int));
            try {
              if (SignUpShowMeScreen.this.listItem.equals(SignUpShowMeScreen.this.selectAll)) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder();
                this();
                AlertDialog.Builder builder2 = builder1.setIcon(17301543).setTitle(SignUpShowMeScreen.this.getResources().getString(2131689524)).setMessage(SignUpShowMeScreen.this.getResources().getString(2131689542));
                DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                      String str = SignUpShowMeScreen.this.turnListToString(SignUpShowMeScreen.this.copyList);
                      SignUpShowMeScreen.access$502(SignUpShowMeScreen.this, SignUpShowMeScreen.this.sqLiteDatabase.compileStatement(SignUpShowMeScreen.this.sqlLine));
                      SignUpShowMeScreen.this.sqLiteStatement.bindString(1, str);
                      SignUpShowMeScreen.this.sqLiteStatement.execute();
                      SignUpShowMeScreen.this.startActivity(new Intent((Context)SignUpShowMeScreen.this, MainActivity.class));
                    }
                  };
                super(this);
                builder2.setPositiveButton("Yes", onClickListener).setNegativeButton("No", null).show();
              } else {
                SignUpShowMeScreen.this.itemsSelectedList.add(SignUpShowMeScreen.this.listItem);
                SignUpShowMeScreen.access$802(SignUpShowMeScreen.this, SignUpShowMeScreen.this.checkIfContains(SignUpShowMeScreen.this.itemsSelectedList, SignUpShowMeScreen.this.listItem));
                SignUpShowMeScreen.access$1002(SignUpShowMeScreen.this, SignUpShowMeScreen.this.showItemsSelected(SignUpShowMeScreen.this.itemsSelectedList));
                signUpShowMeScreen = SignUpShowMeScreen.this;
                StringBuilder stringBuilder = new StringBuilder();
                this();
                stringBuilder.append(SignUpShowMeScreen.this.itemsSelected);
                stringBuilder.append(" ");
                stringBuilder.append(SignUpShowMeScreen.this.isSelected);
                SignUpShowMeScreen.access$1202(signUpShowMeScreen, stringBuilder.toString());
                SignUpShowMeScreen.this.userTypeSelectedTextView.setText(SignUpShowMeScreen.this.itemsShow);
              } 
            } catch (Exception exception) {
              exception.printStackTrace();
            } 
          }
        });
    this.sqLiteDatabase = openOrCreateDatabase("user", 0, null);
    this.sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS profilesToShow (categoryList VARCHAR)");
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4) {
      super.onKeyDown(paramInt, paramKeyEvent);
      return true;
    } 
    return false;
  }
  
  public void onSignUpShowMeContinueButtonClicked(View paramView) {
    if (!this.itemsSelected.equals("")) {
      String str = this.itemsSelected;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(" ");
      stringBuilder.append(this.isSelected);
      if (!str.equals(stringBuilder.toString())) {
        this.sqLiteStatement = this.sqLiteDatabase.compileStatement(this.sqlLine);
        this.sqLiteStatement.bindString(1, this.itemsSelected);
        this.sqLiteStatement.execute();
        startActivity(new Intent((Context)this, MainActivity.class));
        return;
      } 
    } 
    Toast.makeText((Context)this, 2131689692, 1);
  }
}
