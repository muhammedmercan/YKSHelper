package com.muhammedmercan.ykshelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.muhammedmercan.ykshelper.R;

public class CalculatedResults extends AppCompatActivity {

    private float clearTurkıshCorrect, clearSocialStudiesCorrect, clearBasicMathCorrect, clearScienceCorrect;
    private TextView txtClearTurkishCorrect,txtClearSocialStudiesCorrect, txtClearBasicMathCorrect,txtClearScienceCorrect, txtRawScore, txtPlacementScore, txtRawRanking, txtPlacementRanking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculated_results);

        initViews();
        getDataFromIntent();
        setData();


    }



    private void initViews() {
        txtClearTurkishCorrect = findViewById(R.id.txtClearTurkishCorrect);
        txtClearSocialStudiesCorrect = findViewById(R.id.txtClearSocialStudiesCorrect);
        txtClearBasicMathCorrect = findViewById(R.id.txtClearBasicMathCorrect);
        txtClearScienceCorrect = findViewById(R.id.txtClearScienceCorrect);
        txtRawScore = findViewById(R.id.txtRawScore);

    }
    private void getDataFromIntent() {
        Intent intent = getIntent();
        clearTurkıshCorrect = intent.getFloatExtra("clearTurkishCorrect",0);
        clearSocialStudiesCorrect = intent.getFloatExtra("clearSocialStudiesCorrect",0);
        clearBasicMathCorrect = intent.getFloatExtra("clearBasicMathCorrect",0);
        clearScienceCorrect = intent.getFloatExtra("clearScienceCorrect",0);
        System.out.println(clearTurkıshCorrect * 3.3 + clearSocialStudiesCorrect * 3.4 + clearBasicMathCorrect * 3.3 + clearScienceCorrect * 3.4);
    }

    private void setData() {

        txtClearTurkishCorrect.setText(String.valueOf(clearTurkıshCorrect));
        txtClearSocialStudiesCorrect.setText(String.valueOf(clearSocialStudiesCorrect));
        txtClearBasicMathCorrect.setText(String.valueOf(clearBasicMathCorrect));
        txtClearScienceCorrect.setText(String.valueOf(clearScienceCorrect));

        txtRawScore.setText(String.valueOf(clearTurkıshCorrect * 3.3 + clearSocialStudiesCorrect * 3.4 + clearBasicMathCorrect * 3.3 + clearScienceCorrect * 3.4 + 100 ));

    }
}