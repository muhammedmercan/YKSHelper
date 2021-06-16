    package com.muhammedmercan.ykshelper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.Source;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView txtCounterDays, txtCounterHours,txtCounterMinutes, txtCounterSeconds;
    private CardView  robotCardView, subjectCardView, calculateCardView, examCardView;
    private ProgressBar progressBarDays, progressBarHours,progressBarMinutes,progressBarSeconds;

      private Map<String, Object> city;
      FirebaseFirestore db = FirebaseFirestore.getInstance();




    private static final String TAG = "DocSnippets";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        city = new HashMap<>();
        db = FirebaseFirestore.getInstance();


        initViews();
        long differentBetween= calculateDate();
        countDownTimer(differentBetween,1000);






    }

    private void setArray(int puan,int tyt, int sayısal,int sözel,int eşitAğırlık, int dil) {


        city.put("tyt", tyt);
        city.put("sayısal", sayısal);
        city.put("sözel", sözel);
        city.put("eşitAğırlık", eşitAğırlık);
        city.put("dil", dil);


        db.collection("placementRankings").document(String.valueOf(puan))
                .set(city)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot successfully written!");

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error writing document", e);
                    }
                });


    }


    public void onClick(View view) {

        switch(view.getId()){

            case R.id.calculateCardView:
                Intent intent = new Intent(this, CalculateActivity.class);
                this.startActivity(intent);
                break;

            case R.id.robotCardView:
                Intent intent2 = new Intent(this, RobotActivity.class);
                this.startActivity(intent2);
                break;

            case R.id.examCardView:
                Intent intent3 = new Intent(this, ExamActivity.class);
                this.startActivity(intent3);
                break;

            case R.id.subjectCardView:
                Intent intent4 = new Intent(this, SubjectActivity.class);
                this.startActivity(intent4);
                break;


        }
    }

    private void initViews() {
        txtCounterDays = findViewById(R.id.txtCounterDays);
        txtCounterHours = findViewById(R.id.txtCounterHours);
        txtCounterMinutes = findViewById(R.id.txtCounterMinutes);
        txtCounterSeconds = findViewById(R.id.txtCounterSeconds);
        progressBarDays = findViewById(R.id.progressBarDay);
        progressBarHours = findViewById(R.id.progressBarHours);
        progressBarMinutes = findViewById(R.id.progressBarMinutes);
        progressBarSeconds = findViewById(R.id.progressBarSeconds);
        robotCardView = findViewById(R.id.robotCardView);
        subjectCardView = findViewById(R.id.subjectCardView);
        calculateCardView = findViewById(R.id.calculateCardView);
        examCardView = findViewById(R.id.examCardView);

        robotCardView.setOnClickListener(this);
        subjectCardView.setOnClickListener(this);
        calculateCardView.setOnClickListener(this);
        examCardView.setOnClickListener(this);


    }


    //TODO veritabanı eklendiğinde sınav tarihini veritabanından çek
    private long calculateDate() {

        long currentTime = Instant.now().toEpochMilli() + 10800000;
        long examDate = Instant.parse("2021-06-27T10:15:00.00Z").toEpochMilli();
        return examDate - currentTime;
    }

    private void countDownTimer(long fark, int countDownInterval) {
        new CountDownTimer(fark, countDownInterval) {
            public void onTick(long millisUntilFinished) {
                txtCounterDays.setText("" + String.format("%d\nGün",TimeUnit.MILLISECONDS.toDays(millisUntilFinished)));
                txtCounterHours.setText("" + String.format("%d\nSaat",TimeUnit.MILLISECONDS.toHours(millisUntilFinished) -
                        TimeUnit.MILLISECONDS.toDays(millisUntilFinished) * 24));
                txtCounterMinutes.setText("" + String.format("%d\nDakika",TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                toHours(millisUntilFinished))));
                txtCounterSeconds.setText(""+String.format("%d\nSaniye",TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                toMinutes(millisUntilFinished))));

                setStatusBarProgress();
            }
            public void onFinish() {
            }
        }.start();
    }

    private void setStatusBarProgress() {
        LocalDateTime CurrentDate = LocalDateTime.now();
        progressBarDays.setProgress(100 - (CurrentDate.getDayOfYear() * 100 / 177));
        progressBarHours.setProgress(100 - (Math.abs(CurrentDate.getHour() + 3 - 10) * 100 / 24));
        progressBarMinutes.setProgress(100 - (Math.abs(CurrentDate.getMinute() - 15) * 100 / 60));
        progressBarSeconds.setProgress(100 - (CurrentDate.getSecond() * 100 / 60));

    }

}