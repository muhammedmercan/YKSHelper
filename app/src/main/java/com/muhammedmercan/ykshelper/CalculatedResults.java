package com.muhammedmercan.ykshelper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


public class CalculatedResults extends AppCompatActivity {

    private Intent intent;
    private TextView txtClearTurkishCorrect,txtClearSocialStudiesCorrect, txtClearBasicMathCorrect,txtClearScienceCorrect, txtRawScore, txtPlacementScore, txtRawRanking, txtPlacementRanking;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private static final String TAG = "DocSnippets";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculated_results);

        initViews();
        setDataFromIntent();
        setDataFromFirebase();



    }



    private void initViews() {
        txtClearTurkishCorrect = findViewById(R.id.txtClearTurkishCorrect);
        txtClearSocialStudiesCorrect = findViewById(R.id.txtClearSocialStudiesCorrect);
        txtClearBasicMathCorrect = findViewById(R.id.txtClearBasicMathCorrect);
        txtClearScienceCorrect = findViewById(R.id.txtClearScienceCorrect);
        txtRawScore = findViewById(R.id.txtRawScore);
        txtPlacementScore = findViewById(R.id.txtPlacementScore);
        txtRawRanking = findViewById(R.id.txtRawRanking);
        txtPlacementRanking = findViewById(R.id.txtPlacementRanking);


    }

    private void setDataFromFirebase() {
        DocumentReference docRef = db.collection("rawRankings").document(String.valueOf((int)intent.getDoubleExtra("rawScore",0)));
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                        txtRawRanking.setText(String.valueOf(document.getData().get("tyt")));
                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
    }

    private void setDataFromIntent() {
        intent = getIntent();
        txtClearTurkishCorrect.setText(String.valueOf(intent.getFloatExtra("clearTurkishCorrect",0)));
        txtClearSocialStudiesCorrect.setText(String.valueOf(intent.getFloatExtra("clearSocialStudiesCorrect",0)));
        txtClearBasicMathCorrect.setText(String.valueOf(intent.getFloatExtra("clearBasicMathCorrect",0)));
        txtClearScienceCorrect.setText(String.valueOf(intent.getFloatExtra("clearScienceCorrect",0)));
        txtRawScore.setText(String.format("%.2f",intent.getDoubleExtra("rawTytScore",0)));
        txtPlacementScore.setText(String.format("%.2f",intent.getDoubleExtra("rawTytScore",0)+((intent.getDoubleExtra("diplomaGrade",0)*0.6) )));





    }


}