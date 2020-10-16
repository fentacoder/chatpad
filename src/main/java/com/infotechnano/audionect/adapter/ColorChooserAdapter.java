package com.infotechnano.audionect.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.infotechnano.audionect.Settings;
import java.util.List;

public class ColorChooserAdapter extends RecyclerView.Adapter<ColorChooserAdapter.ColorViewHolder> {
  private List<String> colorList;
  
  private Context context;
  
  private SharedPreferences sharedPreferences;
  
  public ColorChooserAdapter(Context paramContext, List<String> paramList) {
    this.context = paramContext;
    this.colorList = paramList;
    this.sharedPreferences = paramContext.getSharedPreferences("com.infotechnano.sharedpreferences", 0);
  }
  
  public int getItemCount() {
    return this.colorList.size();
  }
  
  public void onBindViewHolder(ColorViewHolder paramColorViewHolder, int paramInt) {
    String str = this.colorList.get(paramInt);
    paramColorViewHolder.colorName.setText(str);
    switch (str.hashCode()) {
      default:
        paramInt = -1;
        break;
      case 98619139:
        if (str.equals("green")) {
          paramInt = 0;
          break;
        } 
      case 94011702:
        if (str.equals("brown")) {
          paramInt = 6;
          break;
        } 
      case 93819586:
        if (str.equals("blaze")) {
          paramInt = 10;
          break;
        } 
      case 93618148:
        if (str.equals("beige")) {
          paramInt = 14;
          break;
        } 
      case 3441014:
        if (str.equals("pink")) {
          paramInt = 13;
          break;
        } 
      case 3181155:
        if (str.equals("gray")) {
          paramInt = 5;
          break;
        } 
      case 3178592:
        if (str.equals("gold")) {
          paramInt = 2;
          break;
        } 
      case 3027034:
        if (str.equals("blue")) {
          paramInt = 4;
          break;
        } 
      case 112785:
        if (str.equals("red")) {
          paramInt = 9;
          break;
        } 
      case -267278044:
        if (str.equals("light blue")) {
          paramInt = 3;
          break;
        } 
      case -734239628:
        if (str.equals("yellow")) {
          paramInt = 1;
          break;
        } 
      case -816343937:
        if (str.equals("violet")) {
          paramInt = 12;
          break;
        } 
      case -909707666:
        if (str.equals("salmon")) {
          paramInt = 8;
          break;
        } 
      case -976943172:
        if (str.equals("purple")) {
          paramInt = 11;
          break;
        } 
      case -1008851410:
        if (str.equals("orange")) {
          paramInt = 7;
          break;
        } 
    } 
    switch (paramInt) {
      default:
        return;
      case 14:
        paramColorViewHolder.colorImage.setBackgroundResource(2131230815);
      case 13:
        paramColorViewHolder.colorImage.setBackgroundResource(2131230897);
      case 12:
        paramColorViewHolder.colorImage.setBackgroundResource(2131230910);
      case 11:
        paramColorViewHolder.colorImage.setBackgroundResource(2131230902);
      case 10:
        paramColorViewHolder.colorImage.setBackgroundResource(2131230816);
      case 9:
        paramColorViewHolder.colorImage.setBackgroundResource(2131230903);
      case 8:
        paramColorViewHolder.colorImage.setBackgroundResource(2131230904);
      case 7:
        paramColorViewHolder.colorImage.setBackgroundResource(2131230895);
      case 6:
        paramColorViewHolder.colorImage.setBackgroundResource(2131230823);
      case 5:
        paramColorViewHolder.colorImage.setBackgroundResource(2131230867);
      case 4:
        paramColorViewHolder.colorImage.setBackgroundResource(2131230818);
      case 3:
        paramColorViewHolder.colorImage.setBackgroundResource(2131230877);
      case 2:
        paramColorViewHolder.colorImage.setBackgroundResource(2131230864);
      case 1:
        paramColorViewHolder.colorImage.setBackgroundResource(2131230879);
      case 0:
        break;
    } 
    paramColorViewHolder.colorImage.setBackgroundResource(2131230878);
  }
  
  public ColorViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt) {
    return new ColorViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131492908, paramViewGroup, false));
  }
  
  public class ColorViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    ImageView colorImage;
    
    TextView colorName;
    
    ColorViewHolder(View param1View) {
      super(param1View);
      param1View.setOnClickListener(this);
      this.colorImage = (ImageView)param1View.findViewById(2131296398);
      this.colorName = (TextView)param1View.findViewById(2131296399);
    }
    
    public void onClick(View param1View) {
      int i = getAdapterPosition();
      String str = ColorChooserAdapter.this.colorList.get(i);
      ColorChooserAdapter.this.sharedPreferences.edit().putString("colorSelect", str).apply();
      ColorChooserAdapter.this.context.startActivity(new Intent(ColorChooserAdapter.this.context, Settings.class));
    }
  }
}
