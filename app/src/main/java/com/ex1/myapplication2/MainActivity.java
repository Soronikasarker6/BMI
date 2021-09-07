package com.ex1.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    android.widget.Button mcalculateBMI;
    TextView mCurrentHeight,mCurrentAge,mCurrentWeight;
    ImageView mIncrementWeight,mIncrementAge,mdecrementWeight,mdecrementAge;
    LinearLayout mMale,mFemale;
    SeekBar mSeekbar;

    int intWeight = 55;
    int intAge = 23;
    int currentProgress;
    String mintProgress = "170";
    String typeofUser="0";
    String weight2 = "55";
    String age2 = "23";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

       mcalculateBMI = findViewById(R.id.calculateBMI);
       mCurrentHeight= findViewById(R.id.currentHeight);
       mCurrentAge = findViewById(R.id.currentAge);
       mCurrentWeight = findViewById(R.id.currentWeight);
       mIncrementWeight = findViewById(R.id.weightInc);
       mdecrementWeight = findViewById(R.id.weightDec);
        mIncrementAge = findViewById(R.id.ageInc);
        mdecrementAge = findViewById(R.id.ageDec);
        mMale = findViewById(R.id.male);
        mFemale = findViewById(R.id.female);

        mMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalefocus));
                mFemale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalenotfocus));
                typeofUser ="male";
            }
        });
        mFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFemale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalefocus));
                mMale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalenotfocus));
                typeofUser ="Female";
            }
        });
        mSeekbar.setMax(300);
        mSeekbar.setProgress(170);
        mSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentProgress=progress;
                mintProgress = String.valueOf(currentProgress);
                mCurrentHeight.setText(mintProgress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mIncrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intAge= intAge+1;
                age2 = String.valueOf(intAge);
                mCurrentAge.setText(age2);
            }
        });
        mIncrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intWeight= intWeight+1;
                weight2 = String.valueOf(intWeight);
                mCurrentWeight.setText(weight2);
            }
        });
        mdecrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intAge= intAge-1;
                age2 = String.valueOf(intAge);
                mCurrentAge.setText(age2);
            }
        });
        mdecrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intWeight= intWeight-1;
                weight2 = String.valueOf(intWeight);
                mCurrentWeight.setText(weight2);
            }
        });

        mcalculateBMI.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               if(typeofUser.equals("0")){
                   Toast.makeText(getApplicationContext(),"Select Your Gender",Toast.LENGTH_SHORT).show();
               }
               else if (mintProgress.equals("0")){
                   Toast.makeText(getApplicationContext(),"Select Your Height",Toast.LENGTH_SHORT).show();
               }
               else if (intAge==0 || intAge<0){
                   Toast.makeText(getApplicationContext(),"Age is incorrect",Toast.LENGTH_SHORT).show();
               }
               else if (intWeight==0 || intWeight<0){
                   Toast.makeText(getApplicationContext(),"Weight is incorrect",Toast.LENGTH_SHORT).show();
               }
               else{
                   Intent intent = new Intent(MainActivity.this,BMICalculate.class);
                   intent.putExtra("gender",typeofUser);
                   intent.putExtra("height",mintProgress);
                   intent.putExtra("weight",weight2);
                   intent.putExtra("age",age2);

                   startActivity(intent);
               }

           }
       });

    }

    }