package com.jamar.audionect.signUpProcess;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.jamar.audionect.MainActivity;
import java.util.ArrayList;
import java.util.HashMap;
import util.Person;

public class PictureSignUpScreen extends AppCompatActivity {
  private static final int GALLERY_CODE = 1;
  
  private boolean activityCompleted;
  
  private CollectionReference artworkArtistCollection = this.db.collection("artwork");
  
  private FirebaseAuth.AuthStateListener authStateListener;
  
  private CollectionReference canoeingCollection = this.db.collection("canoeing");
  
  private Button continueButton;
  
  private FirebaseFirestore db = FirebaseFirestore.getInstance();
  
  private CollectionReference engineeringProjectsCollection = this.db.collection("engineeringProjects");
  
  private CollectionReference filmProductionCollection = this.db.collection("filmProduction");
  
  private FirebaseAuth firebaseAuth;
  
  private FirebaseUser firebaseUser;
  
  private CollectionReference goingOutForGoodTimeCollection = this.db.collection("goingOutForGoodTime");
  
  private CollectionReference hikingCollection = this.db.collection("hiking");
  
  private ArrayList<String> imageUrlList = new ArrayList<>();
  
  private String leftPicTitle;
  
  private ImageButton leftPicture;
  
  private boolean leftPicturedAdded;
  
  private String middlePicTitle;
  
  private ImageButton middlePicture;
  
  private boolean middlePicturedAdded;
  
  private CollectionReference musicProductionCollection = this.db.collection("musicProduction");
  
  private String picTitle;
  
  private CollectionReference programmingProjectsCollection = this.db.collection("programmingProjects");
  
  private String rightPicTitle;
  
  private ImageButton rightPicture;
  
  private boolean rightPicturedAdded;
  
  private Uri selectedImage;
  
  private SharedPreferences sharedPreferences;
  
  private CollectionReference shoppingCollection = this.db.collection("shopping");
  
  private CollectionReference sportsCollection = this.db.collection("sports");
  
  private StorageReference storageReference;
  
  private CollectionReference studyingCollection = this.db.collection("studying");
  
  private TextView textView;
  
  private CollectionReference travelingCollection = this.db.collection("traveling");
  
  private String userPicId;
  
  private CollectionReference vehicleCollection = this.db.collection("vehicles");
  
  private CollectionReference ventingCollection = this.db.collection("ventingFrustration");
  
  private CollectionReference videogamesCollection = this.db.collection("videogames");
  
  private String whichPicture;
  
  private void clearLeftUri(String paramString) {
    FirebaseStorage.getInstance().getReference("UserPics").child("LeftPics").child(this.userPicId).child(paramString).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
          public void onSuccess(Void param1Void) {
            Log.i("replacePicture", "picture was deleted successfully");
            Toast.makeText((Context)PictureSignUpScreen.this, "picture was deleted successfully", 1).show();
          }
        }).addOnFailureListener(new OnFailureListener() {
          public void onFailure(Exception param1Exception) {
            Log.i("replacePicture", "picture was not deleted successfully");
            Toast.makeText((Context)PictureSignUpScreen.this, param1Exception.getMessage(), 1).show();
          }
        });
  }
  
  private void clearMiddleUri(String paramString) {
    FirebaseStorage.getInstance().getReference("UserPics").child("MiddlePics").child(this.userPicId).child(paramString).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
          public void onSuccess(Void param1Void) {
            Log.i("replacePicture", "picture was deleted successfully");
            Toast.makeText((Context)PictureSignUpScreen.this, "picture was deleted successfully", 1).show();
          }
        }).addOnFailureListener(new OnFailureListener() {
          public void onFailure(Exception param1Exception) {
            Log.i("replacePicture", "picture was not deleted successfully");
            Toast.makeText((Context)PictureSignUpScreen.this, param1Exception.getMessage(), 1).show();
          }
        });
  }
  
  private void clearRightUri(String paramString) {
    FirebaseStorage.getInstance().getReference("UserPics").child("RightPics").child(this.userPicId).child(paramString).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
          public void onSuccess(Void param1Void) {
            Log.i("replacePicture", "picture was deleted successfully");
            Toast.makeText((Context)PictureSignUpScreen.this, "picture was deleted successfully", 1).show();
          }
        }).addOnFailureListener(new OnFailureListener() {
          public void onFailure(Exception param1Exception) {
            Log.i("replacePicture", "picture was not deleted successfully");
            Toast.makeText((Context)PictureSignUpScreen.this, param1Exception.getMessage(), 1).show();
          }
        });
  }
  
  private void updateUserData() {
    byte b;
    Person.getInstance().setPerson_category(this.sharedPreferences.getString("userCategory", ""));
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
  
  private void uploadLeftPicture() {
    final StorageReference filepath = this.storageReference.child("UserPics").child("LeftPics").child(this.userPicId).child(this.picTitle);
    storageReference.putFile(this.selectedImage).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
          public void onSuccess(UploadTask.TaskSnapshot param1TaskSnapshot) {
            filepath.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                  public void onSuccess(Uri param2Uri) {
                    String str = param2Uri.toString();
                    PictureSignUpScreen.this.sharedPreferences.edit().putString("leftPicture", str).apply();
                  }
                });
          }
        }).addOnFailureListener(new OnFailureListener() {
          public void onFailure(Exception param1Exception) {}
        });
  }
  
  private void uploadMiddlePicture() {
    final StorageReference filepath = this.storageReference.child("UserPics").child("MiddlePics").child(this.userPicId).child(this.picTitle);
    storageReference.putFile(this.selectedImage).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
          public void onSuccess(UploadTask.TaskSnapshot param1TaskSnapshot) {
            filepath.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                  public void onSuccess(Uri param2Uri) {
                    String str = param2Uri.toString();
                    PictureSignUpScreen.this.sharedPreferences.edit().putString("middlePicture", str).apply();
                  }
                });
          }
        }).addOnFailureListener(new OnFailureListener() {
          public void onFailure(Exception param1Exception) {}
        });
  }
  
  private void uploadRightPicture() {
    final StorageReference filepath = this.storageReference.child("UserPics").child("RightPics").child(this.userPicId).child(this.picTitle);
    storageReference.putFile(this.selectedImage).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
          public void onSuccess(UploadTask.TaskSnapshot param1TaskSnapshot) {
            filepath.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                  public void onSuccess(Uri param2Uri) {
                    String str = param2Uri.toString();
                    PictureSignUpScreen.this.sharedPreferences.edit().putString("rightPicture", str).apply();
                  }
                });
          }
        }).addOnFailureListener(new OnFailureListener() {
          public void onFailure(Exception param1Exception) {}
        });
  }
  
  private void uploadUserData(CollectionReference paramCollectionReference) {
    HashMap<Object, Object> hashMap = new HashMap<>();
    hashMap.put("userId", this.sharedPreferences.getString("currentUser", ""));
    hashMap.put("showMe", "true");
    hashMap.put("name", this.sharedPreferences.getString("name", ""));
    hashMap.put("picturesList", this.sharedPreferences.getString("picturesList", ""));
    hashMap.put("bio", this.sharedPreferences.getString("bio", ""));
    hashMap.put("category", this.sharedPreferences.getString("userCategory", ""));
    hashMap.put("urlList", this.sharedPreferences.getString("urlList", ""));
    paramCollectionReference.document(this.sharedPreferences.getString("currentUser", "")).set(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
          public void onSuccess(Void param1Void) {
            PictureSignUpScreen pictureSignUpScreen = PictureSignUpScreen.this;
            pictureSignUpScreen.startActivity(new Intent((Context)pictureSignUpScreen, MainActivity.class));
            PictureSignUpScreen.this.finish();
          }
        }).addOnFailureListener(new OnFailureListener() {
          public void onFailure(Exception param1Exception) {
            PictureSignUpScreen pictureSignUpScreen = PictureSignUpScreen.this;
            Toast.makeText((Context)pictureSignUpScreen, pictureSignUpScreen.getString(2131689719), 1).show();
          }
        });
    hashMap = new HashMap<>();
    hashMap.put("age", Double.valueOf(Double.parseDouble(this.sharedPreferences.getString("age", ""))));
    paramCollectionReference.document(this.sharedPreferences.getString("currentUser", "")).set(hashMap, SetOptions.merge()).addOnSuccessListener(new OnSuccessListener<Void>() {
          public void onSuccess(Void param1Void) {
            Log.d("updateUserData", "success");
          }
        }).addOnFailureListener(new OnFailureListener() {
          public void onFailure(Exception param1Exception) {}
        });
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1) {
      paramInt1 = -1;
      if (paramInt2 == -1 && paramIntent != null) {
        this.selectedImage = paramIntent.getData();
        try {
          String str = this.whichPicture;
          switch (str.hashCode()) {
            case 50:
              if (str.equals("2"))
                paramInt1 = 2; 
              break;
            case 49:
              if (str.equals("1"))
                paramInt1 = 1; 
              break;
            case 48:
              if (str.equals("0"))
                paramInt1 = 0; 
              break;
          } 
          if (paramInt1 != 0) {
            if (paramInt1 != 1) {
              if (paramInt1 == 2) {
                boolean bool = this.rightPicturedAdded;
                if (bool) {
                  this.rightPicture.setImageURI(this.selectedImage);
                  uploadRightPicture();
                  clearRightUri(this.rightPicTitle);
                  this.rightPicTitle = this.picTitle;
                  this.sharedPreferences.edit().putString("rightPicTitle", this.rightPicTitle).apply();
                  this.rightPicturedAdded = true;
                } else {
                  this.rightPicture.setImageURI(this.selectedImage);
                  this.rightPicturedAdded = true;
                  this.rightPicTitle = this.picTitle;
                  this.sharedPreferences.edit().putString("rightPicTitle", this.rightPicTitle).apply();
                  uploadRightPicture();
                } 
              } 
            } else {
              boolean bool = this.middlePicturedAdded;
              if (bool) {
                this.middlePicture.setImageURI(this.selectedImage);
                uploadMiddlePicture();
                clearMiddleUri(this.middlePicTitle);
                this.middlePicTitle = this.picTitle;
                this.sharedPreferences.edit().putString("middlePicTitle", this.middlePicTitle).apply();
                this.middlePicturedAdded = true;
              } else {
                this.middlePicture.setImageURI(this.selectedImage);
                this.middlePicturedAdded = true;
                this.middlePicTitle = this.picTitle;
                this.sharedPreferences.edit().putString("middlePicTitle", this.middlePicTitle).apply();
                uploadMiddlePicture();
              } 
            } 
          } else {
            boolean bool = this.leftPicturedAdded;
            if (bool) {
              this.leftPicture.setImageURI(this.selectedImage);
              uploadLeftPicture();
              clearLeftUri(this.leftPicTitle);
              this.leftPicTitle = this.picTitle;
              this.sharedPreferences.edit().putString("leftPicTitle", this.leftPicTitle).apply();
              this.leftPicturedAdded = true;
            } else {
              this.leftPicture.setImageURI(this.selectedImage);
              this.leftPicturedAdded = true;
              this.leftPicTitle = this.picTitle;
              this.sharedPreferences.edit().putString("leftPicTitle", this.leftPicTitle).apply();
              uploadLeftPicture();
            } 
          } 
        } catch (Exception exception) {
          exception.printStackTrace();
        } 
      } 
    } 
  }
  
  public void onBackPressed() {
    super.onBackPressed();
    Toast.makeText((Context)this, 2131689729, 0).show();
    startActivity(new Intent((Context)this, StartUpScreen.class));
    finish();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2131492900);
    if (getSupportActionBar() != null)
      getSupportActionBar().setElevation(0.0F); 
    this.sharedPreferences = getSharedPreferences("com.jamar.sharedpreferences", 0);
    try {
      this.textView = (TextView)findViewById(2131296319);
      this.leftPicture = (ImageButton)findViewById(2131296601);
      this.middlePicture = (ImageButton)findViewById(2131296602);
      this.rightPicture = (ImageButton)findViewById(2131296603);
      this.continueButton = (Button)findViewById(2131296605);
      this.storageReference = FirebaseStorage.getInstance().getReference();
      this.activityCompleted = false;
      this.userPicId = this.sharedPreferences.getString("currentUser", "");
      this.imageUrlList.clear();
      this.leftPicturedAdded = false;
      this.middlePicturedAdded = false;
      this.rightPicturedAdded = false;
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  protected void onDestroy() {
    super.onDestroy();
    if (!this.activityCompleted) {
      clearLeftUri(this.sharedPreferences.getString("leftPicTitle", ""));
      clearMiddleUri(this.sharedPreferences.getString("middlePicTitle", ""));
      clearRightUri(this.sharedPreferences.getString("rightPicTitle", ""));
      this.db.collection("Users").document(this.sharedPreferences.getString("currentUser", "")).delete();
      FirebaseAuth.getInstance().getCurrentUser().delete().addOnCompleteListener(new OnCompleteListener<Void>() {
            public void onComplete(Task<Void> param1Task) {
              param1Task.isSuccessful();
            }
          });
    } 
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4 || paramInt == 284 || paramInt == 187) {
      super.onKeyDown(paramInt, paramKeyEvent);
      Toast.makeText((Context)this, 2131689729, 0).show();
      startActivity(new Intent((Context)this, StartUpScreen.class));
      finish();
      return true;
    } 
    return false;
  }
  
  public void onPictureContinueButtonClicked(View paramView) {
    if (this.leftPicturedAdded || this.middlePicturedAdded || this.rightPicturedAdded) {
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
      this.activityCompleted = true;
      this.sharedPreferences.edit().putString("currentLocation", "true").apply();
      updateUserData();
      return;
    } 
    Toast.makeText((Context)this, 2131689528, 1).show();
  }
  
  public void onSignUpPictureClicked(View paramView) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.sharedPreferences.getString("email", ""));
    stringBuilder.append("_");
    stringBuilder.append(Timestamp.now().getSeconds());
    this.picTitle = stringBuilder.toString();
    this.whichPicture = paramView.getTag().toString();
    Intent intent = new Intent("android.intent.action.GET_CONTENT");
    intent.setType("image/*");
    startActivityForResult(intent, 1);
  }
}
