package com.muhammedmercan.ykshelper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import static com.google.firestore.v1.StructuredQuery.CompositeFilter.Operator.AND;


public class CalculatedResults extends AppCompatActivity {

    private Intent intent;
    private TextView txtClearTurkishCorrect,txtClearSocialStudiesCorrect, txtClearBasicMathCorrect,txtClearScienceCorrect, txtRawTytScore,
            txtPlacementTytScore, txtRawTytRanking, txtPlacementTytRanking, txtClearSayisalMathCorrect,txtClearSayisalPhysicsCorrect,txtClearSayisalChemistryCorrect,
            txtClearSayisalBiologyCorrect, txtRawSayisalScore, txtPlacementSayisalScore, txtRawSayisalRanking, txtPlacementSayisalRanking,
            txtClearEsitAgirlikMathCorrect, txtClearEsitAgirlikTurkishLanguageAndLiteratureCorrect, txtClearEsitAgirlikHistoryCorrect, txtClearEsitAgirlikGeographyCorrect,
            txtRawEsitAgirlikScore, txtPlacementEsitAgirlikScore, txtRawEsitAgirlikRanking, txtPlacementEsitAgirlikRanking, txtClearSozelTurkishLanguageAndLiteratureCorrect,
            txtClearSozelHistoryCorrect, txtClearSozelGeographyCorrect, txtClearSozelReligionCultureCorrect, txtClearSozelHistory2Correct, txtClearSozelGeography2Correct,
            txtClearSozelPhilosophyCorrect, txtRawSozelScore, txtPlacementSozelScore, txtRawSozelRanking, txtPlacementSozelRanking, txtClearDilCorrect,
            txtRawDilScore,txtPlacementDilScore, txtRawDilRanking, txtPlacementDilRanking;
    ;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private static final String TAG = "DocSnippets";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculated_results);

        initViews();
        setData();




    }


    private void initViews() {
        txtClearTurkishCorrect = findViewById(R.id.txtClearTurkishCorrect);
        txtClearSocialStudiesCorrect = findViewById(R.id.txtClearSocialStudiesCorrect);
        txtClearBasicMathCorrect = findViewById(R.id.txtClearBasicMathCorrect);
        txtClearScienceCorrect = findViewById(R.id.txtClearScienceCorrect);
        txtRawTytScore = findViewById(R.id.txtRawTytScore);
        txtPlacementTytScore = findViewById(R.id.txtPlacementTytScore);
        txtRawTytRanking = findViewById(R.id.txtRawTytRanking);
        txtPlacementTytRanking = findViewById(R.id.txtPlacementTytRanking);

        txtClearSayisalMathCorrect = findViewById(R.id.txtClearSayisalMathCorrect);
        txtClearSayisalPhysicsCorrect = findViewById(R.id.txtClearSayisalPhysicsCorrect);
        txtClearSayisalChemistryCorrect = findViewById(R.id.txtClearSayisalChemistryCorrect);
        txtClearSayisalBiologyCorrect = findViewById(R.id.txtClearSayisalBiologyCorrect);
        txtRawSayisalScore = findViewById(R.id.txtRawSayisalScore);
        txtPlacementSayisalScore = findViewById(R.id.txtPlacementSayisalScore);
        txtRawSayisalRanking = findViewById(R.id.txtRawSayisalRanking);
        txtPlacementSayisalRanking = findViewById(R.id.txtPlacementSayisalRanking);

        txtClearEsitAgirlikMathCorrect = findViewById(R.id.txtClearEsitAgirlikMathCorrect);
        txtClearEsitAgirlikTurkishLanguageAndLiteratureCorrect = findViewById(R.id.txtClearEsitAgirlikTurkishLanguageAndLiteratureCorrect);
        txtClearEsitAgirlikHistoryCorrect = findViewById(R.id.txtClearEsitAgirlikHistoryCorrect);
        txtClearEsitAgirlikGeographyCorrect = findViewById(R.id.txtClearEsitAgirlikGeographyCorrect);
        txtRawEsitAgirlikScore = findViewById(R.id.txtRawEsitAgirlikScore);
        txtPlacementEsitAgirlikScore = findViewById(R.id.txtPlacementEsitAgirlikScore);
        txtRawEsitAgirlikRanking = findViewById(R.id.txtRawEsitAgirlikRanking);
        txtPlacementEsitAgirlikRanking = findViewById(R.id.txtPlacementEsitAgirlikRanking);

        txtClearSozelTurkishLanguageAndLiteratureCorrect = findViewById(R.id.txtClearSozelTurkishLanguageAndLiteratureCorrect);
        txtClearSozelHistoryCorrect = findViewById(R.id.txtClearSozelHistoryCorrect);
        txtClearSozelGeographyCorrect = findViewById(R.id.txtClearSozelGeographyCorrect);
        txtClearSozelReligionCultureCorrect = findViewById(R.id.txtClearSozelReligionCultureCorrect);
        txtClearSozelHistory2Correct = findViewById(R.id.txtClearSozelHistory2Correct);
        txtClearSozelGeography2Correct = findViewById(R.id.txtClearSozelGeography2Correct);
        txtClearSozelPhilosophyCorrect = findViewById(R.id.txtClearSozelPhilosophyCorrect);
        txtRawSozelScore = findViewById(R.id.txtRawSozelScore);
        txtPlacementSozelScore = findViewById(R.id.txtPlacementSozelScore);
        txtRawSozelRanking = findViewById(R.id.txtRawSozelRanking);
        txtPlacementSozelRanking = findViewById(R.id.txtPlacementSozelRanking);

        txtClearDilCorrect = findViewById(R.id.txtClearDilCorrect);
        txtRawDilScore = findViewById(R.id.txtRawDilScore);
        txtPlacementDilScore = findViewById(R.id.txtPlacementDilScore);
        txtRawDilRanking = findViewById(R.id.txtRawDilRanking);
        txtPlacementDilRanking = findViewById(R.id.txtPlacementDilRanking);


    }

    private void setDataFromDatabase(String typeOfRanking, String typeOfPoint, int point, TextView textView ) {

        Database vt = new Database(this);
        String data = "";
        String query = "SELECT * FROM rankings WHERE type_of_rankings = '" + typeOfRanking + "' AND point = " + point ;
        //String query = "SELECT * FROM rankings";

        System.out.println(query);

        if (typeOfRanking.equals("Raw")) {

                data = data + vt.GetAllDataFromRankings(query);
        }

        if (typeOfRanking.equals("Placement")) {

            if (point >= 150) {
                data = data + vt.GetAllDataFromRankings(query);

            }

            else {
                data = data + "-- -- --";
            }
        }


        textView.setText(data);


    }

    private void setData() {
        intent = getIntent();

        txtClearTurkishCorrect.setText(String.valueOf(intent.getFloatExtra("clearTurkishCorrect",0)));
        txtClearSocialStudiesCorrect.setText(String.valueOf(intent.getFloatExtra("clearSocialStudiesCorrect",0)));
        txtClearBasicMathCorrect.setText(String.valueOf(intent.getFloatExtra("clearBasicMathCorrect",0)));
        txtClearScienceCorrect.setText(String.valueOf(intent.getFloatExtra("clearScienceCorrect",0)));

        txtClearSayisalMathCorrect.setText(String.valueOf(intent.getFloatExtra("clearMathCorrect",0)));
        txtClearSayisalPhysicsCorrect.setText(String.valueOf(intent.getFloatExtra("clearPhysicsCorrect",0)));
        txtClearSayisalChemistryCorrect.setText(String.valueOf(intent.getFloatExtra("clearChemistryCorrect",0)));
        txtClearSayisalBiologyCorrect.setText(String.valueOf(intent.getFloatExtra("clearBiologyCorrect",0)));

        txtClearEsitAgirlikMathCorrect.setText(String.valueOf(intent.getFloatExtra("clearMathCorrect",0)));
        txtClearEsitAgirlikTurkishLanguageAndLiteratureCorrect.setText(String.valueOf(intent.getFloatExtra("clearTurkishLanguageAndLiteratureCorrect",0)));
        txtClearEsitAgirlikHistoryCorrect.setText(String.valueOf(intent.getFloatExtra("clearHistoryCorrect",0)));
        txtClearEsitAgirlikGeographyCorrect.setText(String.valueOf(intent.getFloatExtra("clearGeographyCorrect",0)));

        txtClearSozelTurkishLanguageAndLiteratureCorrect.setText(String.valueOf(intent.getFloatExtra("clearTurkishLanguageAndLiteratureCorrect",0)));
        txtClearSozelHistoryCorrect.setText(String.valueOf(intent.getFloatExtra("clearHistoryCorrect",0)));
        txtClearSozelGeographyCorrect.setText(String.valueOf(intent.getFloatExtra("clearGeographyCorrect",0)));
        txtClearSozelReligionCultureCorrect.setText(String.valueOf(intent.getFloatExtra("clearReligionCultureCorrect",0)));
        txtClearSozelHistory2Correct.setText(String.valueOf(intent.getFloatExtra("clearHistory2Correct",0)));
        txtClearSozelGeography2Correct.setText(String.valueOf(intent.getFloatExtra("clearGeography2Correct",0)));
        txtClearSozelPhilosophyCorrect.setText(String.valueOf(intent.getFloatExtra("clearPhilosophyorrect",0)));

        txtClearDilCorrect.setText(String.valueOf(intent.getFloatExtra("clearForeignLanguageCorrect",0)));


        if (intent.getFloatExtra("clearTurkishCorrect",0) == 0 &&
                intent.getFloatExtra("clearSocialStudiesCorrect",0) == 0 &&
                intent.getFloatExtra("clearBasicMathCorrect",0) == 0 &&
                intent.getFloatExtra("clearScienceCorrect",0) == 0)
        {
                    txtRawTytScore.setText("-- -- --");
                    txtPlacementTytScore.setText("-- -- --");
                    txtRawTytRanking.setText("-- -- --");
                    txtPlacementTytRanking.setText("-- -- --");
                }

                else {
                      txtRawTytScore.setText(String.format("%.2f",intent.getDoubleExtra("rawTytScore",0)));
                      txtPlacementTytScore.setText(String.format("%.2f",intent.getDoubleExtra("placementTytScore",0)));
                      setDataFromDatabase("Raw","tyt",(int)intent.getDoubleExtra("rawTytScore",0),txtRawTytRanking);
                      setDataFromDatabase("Placement","tyt",(int)intent.getDoubleExtra("placementTytScore",0),txtPlacementTytRanking);
                }


                if (intent.getFloatExtra("clearMathCorrect",0) == 0 &&
                    intent.getFloatExtra("clearPhysicsCorrect",0) == 0 &&
                    intent.getFloatExtra("clearChemistryCorrect",0) == 0 &&
                    intent.getFloatExtra("clearBiologyCorrect",0) == 0) {
                txtRawSayisalScore.setText("-- -- -- ");
                txtPlacementSayisalScore.setText("-- -- -- ");
                txtRawSayisalRanking.setText("-- -- --");
                txtPlacementSayisalRanking.setText("-- -- --");
                }

                else {
                      txtRawSayisalScore.setText(String.format("%.2f",intent.getDoubleExtra("rawSayisalScore",0)));
                      txtPlacementSayisalScore.setText(String.format("%.2f",intent.getDoubleExtra("placementSayisalScore",0)));

                    setDataFromDatabase("Raw","sayisal",(int)intent.getDoubleExtra("rawSayisalScore",0),txtRawSayisalRanking);
                    setDataFromDatabase("Placement","sayisal",(int)intent.getDoubleExtra("placementSayisalScore",0),txtPlacementSayisalRanking);

                }

                if (intent.getFloatExtra("clearMathCorrect",0) == 0 &&
                    intent.getFloatExtra("clearTurkishLanguageAndLiteratureCorrect",0) == 0 &&
                    intent.getFloatExtra("clearHistoryCorrect",0) == 0 &&
                    intent.getFloatExtra("clearGeographyCorrect",0) == 0) {
                txtRawEsitAgirlikScore.setText("-- -- -- ");
                txtPlacementEsitAgirlikScore.setText("-- -- -- ");
                txtRawEsitAgirlikRanking.setText("-- -- --");
                txtPlacementEsitAgirlikRanking.setText("-- -- --");
                }

                else {
                    txtRawEsitAgirlikScore.setText(String.format("%.2f",intent.getDoubleExtra("rawEsitAgirlikScore",0)));
                    txtPlacementEsitAgirlikScore.setText(String.format("%.2f",intent.getDoubleExtra("placementEsitAgirlikScore",0)));
                    setDataFromDatabase("Raw","esit_agirlik",(int)intent.getDoubleExtra("rawEsitAgirlikScore",0),txtRawEsitAgirlikRanking);
                    setDataFromDatabase("Placement","esit_agirlik",(int)intent.getDoubleExtra("placementEsitAgirlikScore",0),txtPlacementEsitAgirlikRanking);

                }

                if (intent.getFloatExtra("clearTurkishLanguageAndLiteratureCorrect",0) == 0 &&
                    intent.getFloatExtra("clearHistoryCorrect",0) == 0 &&
                    intent.getFloatExtra("clearGeographyCorrect",0) == 0 &&
                    intent.getFloatExtra("clearReligionCultureCorrect",0) == 0 &&
                    intent.getFloatExtra("clearHistory2Correct",0) == 0 &&
                    intent.getFloatExtra("clearGeography2Correct",0) == 0 &&
                    intent.getFloatExtra("clearPhilosophyorrect",0) == 0) {
                txtRawSozelScore.setText("-- -- -- ");
                txtPlacementSozelScore.setText("-- -- -- ");
                txtRawSozelRanking.setText("-- -- --");
                txtPlacementSozelRanking.setText("-- -- --");
                }

                else {
                    txtRawSozelScore.setText(String.format("%.2f",intent.getDoubleExtra("rawSozelScore",0)));
                    txtPlacementSozelScore.setText(String.format("%.2f",intent.getDoubleExtra("placementSozelScore",0)));
                    setDataFromDatabase("Raw","sozel",(int)intent.getDoubleExtra("rawSozelScore",0),txtRawSozelRanking);
                    setDataFromDatabase("Placement","sozel",(int)intent.getDoubleExtra("placementSozelScore",0),txtPlacementSozelRanking);
                }

                if (intent.getFloatExtra("clearForeignLanguageCorrect",0) == 0) {
                txtRawDilScore.setText("-- -- -- ");
                txtPlacementDilScore.setText("-- -- -- ");
                txtRawDilRanking.setText("-- -- --");
                txtPlacementDilRanking.setText("-- -- --");
                }

                else {
                    txtRawDilScore.setText(String.format("%.2f",intent.getDoubleExtra("rawForeignLanguageScore",0)));
                    txtPlacementDilScore.setText(String.format("%.2f",intent.getDoubleExtra("placementForeignLanguageScore",0)));
                  //  setDataFromFirebase("rawRankings","rawForeignLanguageScore",txtRawDilRanking,"dil");
                 //   setDataFromFirebase("placementRankings","placementForeignLanguageScore",txtPlacementDilRanking,"dil");
                }


         }







}