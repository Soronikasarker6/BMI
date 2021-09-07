package com.ex1.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BMICalculate extends AppCompatActivity {
    android.widget.Button mResCalculateBMI;
    TextView mBMICatagory, mBMIDisplay, mgender;
    Intent intent;
    ImageView mImageView;
    String mBMI, height, weight;
    Float intBMI, intHeight, intWeight;
    LinearLayout mBackground;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmicalculate);

        //Change ActionBar and font color
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"></font>"));
        getSupportActionBar().setTitle("Result");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#1E1D1D"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        intent = getIntent();
        mBMIDisplay = findViewById(R.id.bmiDisplay);
        mBMICatagory = findViewById(R.id.bmiCategoryDisplay);
        mgender = findViewById(R.id.bmiGenderDisplay);
        mImageView= findViewById(R.id.bmiImageView);
        mResCalculateBMI = findViewById(R.id.resCalculateBmi);
        mBackground = findViewById(R.id.imageChange);

        height= intent.getStringExtra("height");
        weight= intent.getStringExtra("weight");

        intHeight= Float.parseFloat(height);
        intWeight= Float.parseFloat(weight);

        intHeight = intHeight/100;
        intBMI = intWeight/(intHeight*intHeight);

        //convert to string
        mBMI= Float.toString(intBMI);

        if (intBMI<16){
            mBMICatagory.setText("Severe Thinness");
            mBackground.setBackgroundColor(Color.RED);
            mImageView.setImageResource(R.drawable.remove);
        }
         else if (intBMI<16.9&& intBMI>16){
            mBMICatagory.setText("Moderate Thinness");
            mBackground.setBackgroundColor(Color.RED);
            mImageView.setImageResource(R.drawable.warning);
        }
        else if (intBMI<18.4 && intBMI>16.9){
            mBMICatagory.setText("Mild Thinness");
            mBackground.setBackgroundColor(Color.RED);
            mImageView.setImageResource(R.drawable.warning);
        }
        else if (intBMI<25 && intBMI>18.4){
            mBMICatagory.setText("Normal");
            mImageView.setImageResource(R.drawable.ok);
        }
        else if (intBMI<29.4 && intBMI>25){
            mBMICatagory.setText("OverWeight");
            mBackground.setBackgroundColor(Color.RED);
            mImageView.setImageResource(R.drawable.warning);
        }
        else{
            mBMICatagory.setText("Obese");
            mBackground.setBackgroundColor(Color.RED);
            mImageView.setImageResource(R.drawable.warning);
        }

        mgender.setText(intent.getStringExtra("gender"));
        mBMIDisplay.setText(mBMI);

        mResCalculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}