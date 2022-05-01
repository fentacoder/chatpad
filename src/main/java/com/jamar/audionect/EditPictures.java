package com.jamar.audionect;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class EditPictures extends AppCompatActivity {
  private static final int GALLERY_CODE = 1;
  
  private boolean atLeastOnePic;
  
  private Button backButton;
  
  private CardView cardView;
  
  private FirebaseFirestore db = FirebaseFirestore.getInstance();
  
  private Button deleteButton;
  
  private boolean deletePic;
  
  private Button doneButton;
  
  private Button doneDeletingButton;
  
  private String leftImage;
  
  private ImageView leftPic;
  
  private String leftPicTitle;
  
  private boolean leftPicturedAdded;
  
  private String middleImage;
  
  private ImageView middlePic;
  
  private String middlePicTitle;
  
  private boolean middlePicturedAdded;
  
  private boolean picChanged;
  
  private String picTitle;
  
  private String rightImage;
  
  private ImageView rightPic;
  
  private String rightPicTitle;
  
  private boolean rightPicturedAdded;
  
  private ScrollView scrollView;
  
  private boolean secondCheckConfirmed;
  
  private Uri selectedImage;
  
  private SharedPreferences sharedPreferences;
  
  private StorageReference storageReference;
  
  private TextView textView;
  
  private String userPicId;
  
  private String whichPicture;
  
  private void checkDoneButton(boolean paramBoolean1, boolean paramBoolean2) {
    if (paramBoolean1 && paramBoolean2) {
      this.doneButton.setAlpha(1.0F);
      this.doneButton.setEnabled(true);
    } 
  }
  
  private void clearLeftUri(String paramString) {
    FirebaseStorage.getInstance().getReference("UserPics").child("LeftPics").child(this.userPicId).child(paramString).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
          public void onSuccess(Void param1Void) {
            Log.i("replacePicture", "picture was deleted successfully");
          }
        }).addOnFailureListener(new OnFailureListener() {
          public void onFailure(Exception param1Exception) {
            Log.i("replacePicture", "picture was not deleted successfully");
          }
        });
  }
  
  private void clearMiddleUri(String paramString) {
    FirebaseStorage.getInstance().getReference("UserPics").child("MiddlePics").child(this.userPicId).child(paramString).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
          public void onSuccess(Void param1Void) {
            Log.i("replacePicture", "picture was deleted successfully");
          }
        }).addOnFailureListener(new OnFailureListener() {
          public void onFailure(Exception param1Exception) {
            Log.i("replacePicture", "picture was not deleted successfully");
          }
        });
  }
  
  private void clearRightUri(String paramString) {
    FirebaseStorage.getInstance().getReference("UserPics").child("RightPics").child(this.userPicId).child(paramString).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
          public void onSuccess(Void param1Void) {
            Log.i("replacePicture", "picture was deleted successfully");
          }
        }).addOnFailureListener(new OnFailureListener() {
          public void onFailure(Exception param1Exception) {
            Log.i("replacePicture", "picture was not deleted successfully");
          }
        });
  }
  
  private void deleteAPicture(String paramString) {
    this.secondCheckConfirmed = false;
    byte b = -1;
    try {
      boolean bool;
      switch (paramString.hashCode()) {
        case 50:
          if (paramString.equals("2"))
            b = 2; 
          break;
        case 49:
          if (paramString.equals("1"))
            b = 1; 
          break;
        case 48:
          bool = paramString.equals("0");
          if (bool)
            b = 0; 
          break;
      } 
      if (b != 0) {
        if (b != 1) {
          if (b == 2 && !this.sharedPreferences.getString("rightPicTitle", "").equals("")) {
            secondCheck();
            if (this.secondCheckConfirmed) {
              clearRightUri(this.sharedPreferences.getString("rightPicTitle", ""));
              this.rightPicturedAdded = false;
              this.rightPic.setImageURI(null);
              this.sharedPreferences.edit().putString("rightPicTitle", "").apply();
              this.sharedPreferences.edit().putString("rightPicture", "").apply();
              if (!this.leftPicturedAdded && !this.middlePicturedAdded && !this.rightPicturedAdded)
                this.atLeastOnePic = false; 
            } 
          } 
        } else if (!this.sharedPreferences.getString("middlePicTitle", "").equals("")) {
          secondCheck();
          if (this.secondCheckConfirmed) {
            clearMiddleUri(this.sharedPreferences.getString("middlePicTitle", ""));
            this.middlePicturedAdded = false;
            this.middlePic.setImageURI(null);
            this.sharedPreferences.edit().putString("middlePicTitle", "").apply();
            this.sharedPreferences.edit().putString("middlePicture", "").apply();
            if (!this.leftPicturedAdded && !this.middlePicturedAdded && !this.rightPicturedAdded)
              this.atLeastOnePic = false; 
          } 
        } 
      } else if (!this.sharedPreferences.getString("leftPicTitle", "").equals("")) {
        secondCheck();
        if (this.secondCheckConfirmed) {
          clearLeftUri(this.sharedPreferences.getString("leftPicTitle", ""));
          this.leftPicturedAdded = false;
          this.leftPic.setImageURI(null);
          this.sharedPreferences.edit().putString("leftPicTitle", "").apply();
          this.sharedPreferences.edit().putString("leftPicture", "").apply();
          if (!this.leftPicturedAdded && !this.middlePicturedAdded && !this.rightPicturedAdded)
            this.atLeastOnePic = false; 
        } 
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  private void finishPictureChange() {
    if (this.leftPicturedAdded || this.middlePicturedAdded || this.rightPicturedAdded) {
      if (!this.leftPicturedAdded)
        this.sharedPreferences.edit().putString("leftPicTitle", "").putString("leftPicture", "").apply(); 
      if (!this.middlePicturedAdded)
        this.sharedPreferences.edit().putString("middlePicTitle", "").putString("middlePicture", "").apply(); 
      if (!this.rightPicturedAdded)
        this.sharedPreferences.edit().putString("rightPicTitle", "").putString("rightPicture", "").apply(); 
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
      startActivity(new Intent((Context)this, Settings.class));
      finish();
      return;
    } 
    this.atLeastOnePic = false;
    Toast.makeText((Context)this, 2131689528, 1).show();
  }
  
  private void secondCheck() {
    (new AlertDialog.Builder((Context)this)).setTitle(2131689525).setMessage(2131689526).setPositiveButton(2131689742, new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            EditPictures.access$002(EditPictures.this, true);
          }
        }).setNegativeButton(2131689647, new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            EditPictures.access$002(EditPictures.this, false);
          }
        }).create().show();
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
    this.textView.setTextColor(-1);
    this.doneButton.setBackgroundResource(2131230854);
    this.doneButton.setTextColor(-1);
    this.backButton.setBackgroundResource(2131230854);
    this.backButton.setTextColor(-1);
    this.deleteButton.setBackgroundResource(2131230854);
    this.deleteButton.setTextColor(-1);
  }
  
  private void showActualPic() {
    String[] arrayOfString = this.sharedPreferences.getString("urlList", "").split(",");
    if (arrayOfString.length == 3) {
      this.leftImage = arrayOfString[0];
      this.leftPicturedAdded = true;
      this.middleImage = arrayOfString[1];
      this.middlePicturedAdded = true;
      this.rightImage = arrayOfString[2];
      this.rightPicturedAdded = true;
      this.atLeastOnePic = true;
    } else if (arrayOfString.length == 2) {
      this.leftImage = arrayOfString[0];
      this.leftPicturedAdded = true;
      this.middleImage = arrayOfString[1];
      this.middlePicturedAdded = true;
      this.rightImage = "";
      this.rightPicturedAdded = false;
      this.atLeastOnePic = true;
    } else {
      this.leftImage = arrayOfString[0];
      this.leftPicturedAdded = true;
      this.middleImage = "";
      this.middlePicturedAdded = false;
      this.rightImage = "";
      this.rightPicturedAdded = false;
      this.atLeastOnePic = true;
    } 
    if (this.middleImage.equals("") && this.rightImage.equals("")) {
      (new GetImageFromUrl(this.leftPic)).execute((Object[])new String[] { this.leftImage });
    } else if (this.rightImage.equals("")) {
      (new GetImageFromUrl(this.leftPic)).execute((Object[])new String[] { this.leftImage });
      (new GetImageFromUrl(this.middlePic)).execute((Object[])new String[] { this.middleImage });
    } else {
      (new GetImageFromUrl(this.leftPic)).execute((Object[])new String[] { this.leftImage });
      (new GetImageFromUrl(this.middlePic)).execute((Object[])new String[] { this.middleImage });
      (new GetImageFromUrl(this.rightPic)).execute((Object[])new String[] { this.rightImage });
    } 
  }
  
  private void uploadLeftPicture() {
    final StorageReference filepath = this.storageReference.child("UserPics").child("LeftPics").child(this.userPicId).child(this.picTitle);
    storageReference.putFile(this.selectedImage).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
          public void onSuccess(UploadTask.TaskSnapshot param1TaskSnapshot) {
            filepath.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                  public void onSuccess(Uri param2Uri) {
                    String str = param2Uri.toString();
                    EditPictures.this.sharedPreferences.edit().putString("leftPicture", str).apply();
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
                    EditPictures.this.sharedPreferences.edit().putString("middlePicture", str).apply();
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
                    EditPictures.this.sharedPreferences.edit().putString("rightPicture", str).apply();
                  }
                });
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
                  this.rightPic.setImageURI(this.selectedImage);
                  uploadRightPicture();
                  clearRightUri(this.rightPicTitle);
                  this.rightPicTitle = this.picTitle;
                  this.sharedPreferences.edit().putString("rightPicTitle", this.rightPicTitle).apply();
                  this.rightPicturedAdded = true;
                  this.atLeastOnePic = true;
                  this.picChanged = true;
                  checkDoneButton(this.atLeastOnePic, this.picChanged);
                } else {
                  this.rightPic.setImageURI(this.selectedImage);
                  this.rightPicturedAdded = true;
                  this.rightPicTitle = this.picTitle;
                  this.sharedPreferences.edit().putString("rightPicTitle", this.rightPicTitle).apply();
                  uploadRightPicture();
                  this.atLeastOnePic = true;
                  this.picChanged = true;
                  checkDoneButton(this.atLeastOnePic, this.picChanged);
                } 
              } 
            } else {
              boolean bool = this.middlePicturedAdded;
              if (bool) {
                this.middlePic.setImageURI(this.selectedImage);
                uploadMiddlePicture();
                clearMiddleUri(this.middlePicTitle);
                this.middlePicTitle = this.picTitle;
                this.sharedPreferences.edit().putString("middlePicTitle", this.middlePicTitle).apply();
                this.middlePicturedAdded = true;
                this.atLeastOnePic = true;
                this.picChanged = true;
                checkDoneButton(this.atLeastOnePic, this.picChanged);
              } else {
                this.middlePic.setImageURI(this.selectedImage);
                this.middlePicturedAdded = true;
                this.middlePicTitle = this.picTitle;
                this.sharedPreferences.edit().putString("middlePicTitle", this.middlePicTitle).apply();
                uploadMiddlePicture();
                this.atLeastOnePic = true;
                this.picChanged = true;
                checkDoneButton(this.atLeastOnePic, this.picChanged);
              } 
            } 
          } else {
            boolean bool = this.leftPicturedAdded;
            if (bool) {
              this.leftPic.setImageURI(this.selectedImage);
              uploadLeftPicture();
              clearLeftUri(this.leftPicTitle);
              this.leftPicTitle = this.picTitle;
              this.sharedPreferences.edit().putString("leftPicTitle", this.leftPicTitle).apply();
              this.leftPicturedAdded = true;
              this.atLeastOnePic = true;
              this.picChanged = true;
              checkDoneButton(this.atLeastOnePic, this.picChanged);
            } else {
              this.leftPic.setImageURI(this.selectedImage);
              this.leftPicturedAdded = true;
              this.leftPicTitle = this.picTitle;
              this.sharedPreferences.edit().putString("leftPicTitle", this.leftPicTitle).apply();
              uploadLeftPicture();
              this.atLeastOnePic = true;
              this.picChanged = true;
              checkDoneButton(this.atLeastOnePic, this.picChanged);
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
    if (!this.leftPicturedAdded && !this.middlePicturedAdded && !this.rightPicturedAdded) {
      Toast.makeText((Context)this, 2131689528, 1).show();
    } else {
      finishPictureChange();
      this.sharedPreferences.edit().putString("editPicture", "false").apply();
    } 
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2131492924);
    if (getSupportActionBar() != null)
      getSupportActionBar().setElevation(0.0F); 
    this.sharedPreferences = getSharedPreferences("com.jamar.sharedpreferences", 0);
    this.sharedPreferences.edit().putString("editPicture", "true").apply();
    this.leftPic = (ImageView)findViewById(2131296431);
    this.middlePic = (ImageView)findViewById(2131296432);
    this.rightPic = (ImageView)findViewById(2131296433);
    this.doneButton = (Button)findViewById(2131296429);
    this.backButton = (Button)findViewById(2131296426);
    this.deleteButton = (Button)findViewById(2131296428);
    this.doneDeletingButton = (Button)findViewById(2131296430);
    this.cardView = (CardView)findViewById(2131296427);
    this.textView = (TextView)findViewById(2131296435);
    this.scrollView = (ScrollView)findViewById(2131296434);
    this.doneButton.setAlpha(0.6F);
    this.doneButton.setEnabled(false);
    this.doneDeletingButton.setVisibility(4);
    this.doneDeletingButton.setEnabled(false);
    setColor();
    this.userPicId = this.sharedPreferences.getString("currentUser", "");
    showActualPic();
  }
  
  protected void onDestroy() {
    super.onDestroy();
    finishPictureChange();
    this.sharedPreferences.edit().putString("editPicture", "false").apply();
  }
  
  public void onEditPictureBackClicked(View paramView) {
    if (!this.leftPicturedAdded && !this.middlePicturedAdded && !this.rightPicturedAdded) {
      Toast.makeText((Context)this, 2131689528, 1).show();
    } else {
      finishPictureChange();
    } 
  }
  
  public void onEditPictureClicked(View paramView) {
    Intent intent;
    if (!this.deletePic) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.sharedPreferences.getString("email", ""));
      stringBuilder.append("_");
      stringBuilder.append(Timestamp.now().getSeconds());
      this.picTitle = stringBuilder.toString();
      this.whichPicture = paramView.getTag().toString();
      intent = new Intent("android.intent.action.GET_CONTENT");
      intent.setType("image/*");
      startActivityForResult(intent, 1);
    } else {
      this.whichPicture = intent.getTag().toString();
      deleteAPicture(this.whichPicture);
    } 
  }
  
  public void onEditPictureDeleteClicked(View paramView) {
    this.deletePic = true;
    this.doneDeletingButton.setVisibility(0);
    this.doneDeletingButton.setEnabled(true);
    this.doneButton.setEnabled(false);
    this.doneButton.setVisibility(4);
    this.deleteButton.setEnabled(false);
    this.deleteButton.setVisibility(4);
    this.cardView.setCardBackgroundColor(-16776961);
    this.textView.setText(2131689711);
  }
  
  public void onEditPictureDoneClicked(View paramView) {
    finishPictureChange();
    this.sharedPreferences.edit().putString("editPicture", "false").apply();
  }
  
  public void onEditPictureDoneDeletingClicked(View paramView) {
    this.deletePic = false;
    this.doneDeletingButton.setVisibility(4);
    this.doneDeletingButton.setEnabled(false);
    this.doneButton.setEnabled(true);
    this.doneButton.setVisibility(0);
    this.deleteButton.setEnabled(true);
    this.deleteButton.setVisibility(0);
    this.cardView.setCardBackgroundColor(0);
    this.textView.setText(2131689515);
    if (!this.atLeastOnePic) {
      this.doneButton.setAlpha(0.6F);
      this.doneButton.setEnabled(false);
    } else {
      this.doneButton.setAlpha(1.0F);
    } 
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 284 || paramInt == 187) {
      super.onKeyDown(paramInt, paramKeyEvent);
      finishPictureChange();
      this.sharedPreferences.edit().putString("editPicture", "false").apply();
      return true;
    } 
    if (paramInt == 4)
      if (!this.leftPicturedAdded && !this.middlePicturedAdded && !this.rightPicturedAdded) {
        Toast.makeText((Context)this, 2131689528, 1).show();
      } else {
        finishPictureChange();
        this.sharedPreferences.edit().putString("editPicture", "false").apply();
      }  
    return false;
  }
}

