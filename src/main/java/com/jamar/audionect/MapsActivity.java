package com.jamar.audionect;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
  private String lat;
  
  private String latLng;
  
  private String lng;
  
  private GoogleMap mMap;
  
  private ArrayList<String> recLocList;
  
  private EditText searchBar;
  
  private Button searchButton;
  
  private SharedPreferences sharedPreferences;
  
  private void confirmSelection(final String loc) {
    (new AlertDialog.Builder((Context)this)).setTitle(getString(2131689524)).setMessage(getString(2131689516)).setPositiveButton(getString(2131689742), new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            SharedPreferences sharedPreferences = MapsActivity.this.sharedPreferences;
            String str2 = "";
            String str1 = sharedPreferences.getString("recentLocations", "");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str1);
            stringBuilder.append("!#!");
            stringBuilder.append(loc);
            ArrayList<String> arrayList = new ArrayList(Arrays.asList((Object[])stringBuilder.toString().split("!#!")));
            int i = arrayList.size();
            boolean bool = false;
            param1Int = bool;
            str1 = str2;
            if (i > 10) {
              arrayList.remove(0);
              str1 = str2;
              param1Int = bool;
            } 
            while (param1Int < arrayList.size()) {
              if (param1Int == 0) {
                str1 = arrayList.get(param1Int);
              } else {
                StringBuilder stringBuilder1 = new StringBuilder();
                stringBuilder1.append(str1);
                stringBuilder1.append("!#!");
                stringBuilder1.append(arrayList.get(param1Int));
                str1 = stringBuilder1.toString();
              } 
              param1Int++;
            } 
            MapsActivity.this.sharedPreferences.edit().putString("recentLocations", str1).apply();
            Intent intent = new Intent((Context)MapsActivity.this, LocationChooser.class);
            intent.putExtra("location", loc);
            MapsActivity.this.startActivity(intent);
            MapsActivity.this.finish();
          }
        }).setNegativeButton(getString(2131689647), new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {}
        }).create().show();
  }
  
  private void findLocation() {
    String str = this.searchBar.getText().toString().trim();
    Geocoder geocoder = new Geocoder((Context)this);
    List<Address> list = new ArrayList();
    try {
      List<Address> list1 = geocoder.getFromLocationName(str, 1);
      list = list1;
    } catch (IOException iOException) {
      Log.e("findLocation: ioException", Objects.<String>requireNonNull(iOException.getMessage()));
    } 
    if (list.size() > 0) {
      Address address = list.get(0);
      LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
      this.mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
      this.mMap.addMarker((new MarkerOptions()).position(latLng).title(address.getAddressLine(0)));
      this.lat = String.valueOf(address.getLatitude());
      this.lng = String.valueOf(address.getLongitude());
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.lat);
      stringBuilder.append(",");
      stringBuilder.append(this.lng);
      this.latLng = stringBuilder.toString();
      stringBuilder = new StringBuilder();
      stringBuilder.append(address.getAddressLine(0));
      stringBuilder.append(">");
      stringBuilder.append(this.latLng);
      String str1 = stringBuilder.toString();
      getWindow().setSoftInputMode(2);
      confirmSelection(str1);
    } 
  }
  
  private void init() {
    this.searchBar.setOnEditorActionListener(new TextView.OnEditorActionListener() {
          public boolean onEditorAction(TextView param1TextView, int param1Int, KeyEvent param1KeyEvent) {
            if (param1Int == 3 || param1Int == 6 || param1KeyEvent.getAction() == 0 || param1KeyEvent.getAction() == 66)
              MapsActivity.this.findLocation(); 
            return false;
          }
        });
  }
  
  private ArrayList<String> setRecentLocationMarkers() {
    ArrayList<?> arrayList = new ArrayList(Arrays.asList((Object[])this.sharedPreferences.getString("recentLocations", "").split("!#!")));
    Collections.reverse(arrayList);
    return (ArrayList)arrayList;
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2131492898);
    this.sharedPreferences = getSharedPreferences("com.jamar.sharedpreferences", 0);
    this.searchBar = (EditText)findViewById(2131296527);
    this.searchButton = (Button)findViewById(2131296528);
    ((SupportMapFragment)getSupportFragmentManager().findFragmentById(2131296525)).getMapAsync(this);
    this.searchButton.setOnClickListener(new View.OnClickListener() {
          public void onClick(View param1View) {
            MapsActivity.this.findLocation();
          }
        });
  }
  
  public void onMapReady(GoogleMap paramGoogleMap) {
    this.mMap = paramGoogleMap;
    if (!this.sharedPreferences.getString("recentLocations", "").equals("")) {
      this.recLocList = setRecentLocationMarkers();
      String[] arrayOfString1 = ((String)this.recLocList.get(0)).split("!#!");
      String str1 = arrayOfString1[0];
      String[] arrayOfString2 = arrayOfString1[1].split(",");
      String str2 = arrayOfString2[0];
      String str3 = arrayOfString2[1];
      double d1 = Double.parseDouble(str2);
      double d2 = Double.parseDouble(str3);
      LatLng latLng = new LatLng(Double.valueOf(d1).doubleValue(), Double.valueOf(d2).doubleValue());
      this.mMap.addMarker((new MarkerOptions()).position(latLng).title(str1));
      this.mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
      for (byte b = 1; b < this.recLocList.size(); b++) {
        String[] arrayOfString3 = ((String)this.recLocList.get(b)).split(">");
        str1 = arrayOfString3[0];
        String[] arrayOfString4 = arrayOfString3[1].split(",");
        String str4 = arrayOfString4[0];
        String str5 = arrayOfString4[1];
        d1 = Double.parseDouble(str4);
        d2 = Double.parseDouble(str5);
        LatLng latLng1 = new LatLng(Double.valueOf(d1).doubleValue(), Double.valueOf(d2).doubleValue());
        this.mMap.addMarker((new MarkerOptions()).position(latLng1).title(str1));
      } 
    } 
    init();
  }
}
