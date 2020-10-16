package com.infotechnano.audionect.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;
import com.infotechnano.audionect.Settings;
import java.util.HashMap;
import java.util.List;

public class LocationChooserAdapter extends RecyclerView.Adapter<LocationChooserAdapter.LocationViewHolder> {
  private CollectionReference artworkArtistCollection = this.db.collection("artwork");
  
  private CollectionReference canoeingCollection = this.db.collection("canoeing");
  
  private Context context;
  
  private FirebaseFirestore db = FirebaseFirestore.getInstance();
  
  private CollectionReference engineeringProjectsCollection = this.db.collection("engineeringProjects");
  
  private CollectionReference filmProductionCollection = this.db.collection("filmProduction");
  
  private CollectionReference goingOutForGoodTimeCollection = this.db.collection("goingOutForGoodTime");
  
  private CollectionReference hikingCollection = this.db.collection("hiking");
  
  private List<String> locationList;
  
  private CollectionReference musicProductionCollection = this.db.collection("musicProduction");
  
  private CollectionReference programmingProjectsCollection = this.db.collection("programmingProjects");
  
  private SharedPreferences sharedPreferences;
  
  private CollectionReference shoppingCollection = this.db.collection("shopping");
  
  private CollectionReference sportsCollection = this.db.collection("sports");
  
  private CollectionReference studyingCollection = this.db.collection("studying");
  
  private CollectionReference travelingCollection = this.db.collection("traveling");
  
  private CollectionReference vehicleCollection = this.db.collection("vehicles");
  
  private CollectionReference ventingCollection = this.db.collection("ventingFrustration");
  
  private CollectionReference videogamesCollection = this.db.collection("videogames");
  
  public LocationChooserAdapter(Context paramContext, List<String> paramList) {
    this.context = paramContext;
    this.locationList = paramList;
    this.sharedPreferences = paramContext.getSharedPreferences("com.infotechnano.sharedpreferences", 0);
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
  
  public int getItemCount() {
    return this.locationList.size();
  }
  
  public void onBindViewHolder(LocationViewHolder paramLocationViewHolder, int paramInt) {
    List<String> list = this.locationList;
    if (list != null && list.size() > 0)
      try {
        String[] arrayOfString = ((String)this.locationList.get(paramInt)).split(">");
        String str1 = arrayOfString[0];
        String str2 = arrayOfString[1];
        paramLocationViewHolder.locationRowItem.setText(str1);
        paramLocationViewHolder.locationRowCoordin.setText(str2);
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
  
  public LocationViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt) {
    return new LocationViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131492931, paramViewGroup, false));
  }
  
  public class LocationViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView locationRowCoordin;
    
    TextView locationRowItem;
    
    LocationViewHolder(View param1View) {
      super(param1View);
      param1View.setOnClickListener(this);
      this.locationRowItem = (TextView)param1View.findViewById(2131296510);
      this.locationRowCoordin = (TextView)param1View.findViewById(2131296509);
    }
    
    public void onClick(View param1View) {
      int i = getAdapterPosition();
      String[] arrayOfString1 = ((String)LocationChooserAdapter.this.locationList.get(i)).split(">");
      String str1 = arrayOfString1[0];
      String[] arrayOfString2 = arrayOfString1[1].split(",");
      String str2 = arrayOfString2[0];
      String str3 = arrayOfString2[1];
      LocationChooserAdapter.this.sharedPreferences.edit().putString("lat", str2).putString("lng", str3).putString("currentLocation", "false").putString("userLocation", str1).apply();
      LocationChooserAdapter.this.updateUserData();
      LocationChooserAdapter.this.context.startActivity(new Intent(LocationChooserAdapter.this.context, Settings.class));
    }
  }
}
