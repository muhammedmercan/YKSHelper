package com.muhammedmercan.ykshelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.google.android.material.textfield.TextInputLayout;

import org.w3c.dom.Text;

public class CalculateActivity extends AppCompatActivity implements View.OnClickListener,View.OnFocusChangeListener  {

    private TextInputLayout inputLayoutTurkishCorrect, inputLayoutTurkishWrong, inputLayoutSocialStudiesCorrect, inputLayoutSocialStudiesWrong, inputLayoutBasicMathCorrect, inputLayoutBasicMathWrong, inputLayoutScienceCorrect, inputLayoutScienceWrong, inputLayoutDiplomaGrade, inputLayoutTurkishLanguageAndLiteratureCorrect, inputLayoutTurkishLanguageAndLiteratureWrong, inputLayoutHistoryCorrect, inputLayoutHistoryWrong, inputLayoutGeographyCorrect, inputLayoutGeographyWrong, inputLayoutHistory2Correct, inputLayoutHistory2Wrong, inputLayoutGeography2Correct, inputLayoutGeography2Wrong, inputLayoutPhilosophyCorrect, inputLayoutPhilosophyWrong, inputLayoutReligionCultureCorrect, inputLayoutReligionCultureWrong, inputLayoutMathCorrect, inputLayoutMathWrong, inputLayoutPhysicsCorrect, inputLayoutPhysicsWrong, inputLayoutChemistryCorrect, inputLayoutChemistryWrong, inputLayoutBiologyCorrect, inputLayoutBiologyWrong, inputLayoutForeignLanguageCorrect, inputLayoutForeignLanguageWrong;
    private Button btnCalculate;
    private float clearTurkıshCorrect, clearSocialStudiesCorrect, clearBasicMathCorrect, clearScienceCorrect, clearTurkishLanguageAndLiteratureCorrect, clearHistoryCorrect, clearGeographyCorrect, clearHistory2Correct, clearGeography2Correct, clearPhilosophyorrect, clearReligionCultureCorrect, clearMathCorrect, clearPhysicsCorrect, clearChemistryCorrect, clearBiologyCorrect, clearForeignLanguageCorrect, diplomaGrade ;
    private double rawTytScore, rawEsitAgirlikScore, rawSozelScore, rawSayisalScore, rawForeignLanguageScore, placementTytScore, placementSayisalScore, placementEsitAgirlikScore, placementForeignLanguageScore, placementSozelScore;
    private Intent intent;
    private CheckBox checkBoxIWonBefore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);



        initViews();
        btnCalculate.setOnClickListener(this);
        setOnFocus();

    }

    private void setOnFocus() {
        inputLayoutTurkishCorrect.getEditText().setOnFocusChangeListener(this);
        inputLayoutTurkishWrong.getEditText().setOnFocusChangeListener(this);
        inputLayoutSocialStudiesCorrect.getEditText().setOnFocusChangeListener(this);
        inputLayoutSocialStudiesWrong.getEditText().setOnFocusChangeListener(this);
        inputLayoutBasicMathCorrect.getEditText().setOnFocusChangeListener(this);
        inputLayoutBasicMathWrong.getEditText().setOnFocusChangeListener(this);
        inputLayoutScienceCorrect.getEditText().setOnFocusChangeListener(this);
        inputLayoutScienceWrong.getEditText().setOnFocusChangeListener(this);
        inputLayoutDiplomaGrade.getEditText().setOnFocusChangeListener(this);
        inputLayoutTurkishLanguageAndLiteratureCorrect.getEditText().setOnFocusChangeListener(this);
        inputLayoutTurkishLanguageAndLiteratureWrong.getEditText().setOnFocusChangeListener(this);
        inputLayoutHistoryCorrect.getEditText().setOnFocusChangeListener(this);
        inputLayoutHistoryWrong.getEditText().setOnFocusChangeListener(this);
        inputLayoutGeographyCorrect.getEditText().setOnFocusChangeListener(this);
        inputLayoutGeographyWrong.getEditText().setOnFocusChangeListener(this);
        inputLayoutHistory2Correct.getEditText().setOnFocusChangeListener(this);
        inputLayoutHistory2Wrong.getEditText().setOnFocusChangeListener(this);
        inputLayoutGeography2Correct.getEditText().setOnFocusChangeListener(this);
        inputLayoutGeography2Wrong.getEditText().setOnFocusChangeListener(this);
        inputLayoutPhilosophyCorrect.getEditText().setOnFocusChangeListener(this);
        inputLayoutPhilosophyWrong.getEditText().setOnFocusChangeListener(this);
        inputLayoutReligionCultureCorrect.getEditText().setOnFocusChangeListener(this);
        inputLayoutReligionCultureWrong.getEditText().setOnFocusChangeListener(this);
        inputLayoutMathCorrect.getEditText().setOnFocusChangeListener(this);
        inputLayoutMathWrong.getEditText().setOnFocusChangeListener(this);
        inputLayoutPhysicsCorrect.getEditText().setOnFocusChangeListener(this);
        inputLayoutPhysicsWrong.getEditText().setOnFocusChangeListener(this);
        inputLayoutChemistryCorrect.getEditText().setOnFocusChangeListener(this);
        inputLayoutChemistryWrong.getEditText().setOnFocusChangeListener(this);
        inputLayoutBiologyCorrect.getEditText().setOnFocusChangeListener(this);
        inputLayoutBiologyWrong.getEditText().setOnFocusChangeListener(this);
        inputLayoutForeignLanguageCorrect.getEditText().setOnFocusChangeListener(this);
        inputLayoutForeignLanguageWrong.getEditText().setOnFocusChangeListener(this);
    }

    public void onFocusChange(View view, boolean b) {

        switch (view.getId()) {
            case R.id.txtInputEditTextTurkishCorrect:
                checkValue(inputLayoutTurkishCorrect,b,40, "40'tan büyük");

            case R.id.txtInputEditTextTurkishWrong:
                checkValue(inputLayoutTurkishWrong,b,40, "40'tan büyük");

            case R.id.txtInputEditTextSocialStudiesCorrect:
                checkValue(inputLayoutSocialStudiesCorrect,b,20, "20'den büyük");

            case R.id.txtInputEditTextSocialStudiesWrong:
                checkValue(inputLayoutSocialStudiesWrong,b,20, "20'den büyük");

            case R.id.txtInputEditTextBasicMathCorrect:
                checkValue(inputLayoutBasicMathCorrect,b,40, "40'tan büyük");

            case R.id.txtInputEditTextBasicMathWrong:
                checkValue(inputLayoutBasicMathWrong,b,40, "40'tan büyük");

            case R.id.txtInputEditTextScienceCorrect:
                checkValue(inputLayoutScienceCorrect,b,20, "20'den büyük");

            case R.id.txtInputEditTextScienceWrong:
                checkValue(inputLayoutScienceWrong,b,20, "20'den büyük");

            case R.id.txtInputEditTextDiplomaGrade:
                checkValue(inputLayoutDiplomaGrade,b,100, "100'den büyük");

            case R.id.txtInputEditTextTurkishLanguageAndLiteratureCorrect:
                checkValue(inputLayoutTurkishLanguageAndLiteratureCorrect,b,24, "24'den büyük");

            case R.id.txtInputEditTextTurkishLanguageAndLiteratureWrong:
                checkValue(inputLayoutTurkishLanguageAndLiteratureWrong,b,24, "24'den büyük");

            case R.id.txtInputEditTextHistoryCorrect:
                checkValue(inputLayoutHistoryCorrect,b,10, "10'den büyük");

            case R.id.txtInputEditTextHistoryWrong:
                checkValue(inputLayoutHistoryWrong,b,10, "10'den büyük");

            case R.id.txtInputEditTextGeographyCorrect:
                checkValue(inputLayoutGeographyCorrect,b,6, "6'den büyük");

            case R.id.txtInputEditTextGeographyWrong:
                checkValue(inputLayoutGeographyWrong,b,6, "6'den büyük");

            case R.id.txtInputEditTextHistory2Correct:
                checkValue(inputLayoutHistory2Correct,b,11, "11'den büyük");

            case R.id.txtInputEditTextHistory2Wrong:
                checkValue(inputLayoutHistory2Wrong,b,11, "11'den büyük");

            case R.id.txtInputEditTextGeography2Correct:
                checkValue(inputLayoutGeography2Correct,b,11, "11'den büyük");

            case R.id.txtInputEditTextGeography2Wrong:
                checkValue(inputLayoutGeography2Wrong,b,11, "11'den büyük");

            case R.id.txtInputEditTextPhilosophyCorrect:
                checkValue(inputLayoutPhilosophyCorrect,b,12, "12'den büyük");

            case R.id.txtInputEditTextPhilosophyWrong:
                checkValue(inputLayoutPhilosophyWrong,b,12, "12'den büyük");

            case R.id.txtInputEditTextReligionCultureCorrect:
                checkValue(inputLayoutReligionCultureCorrect,b,6, "6'den büyük");

            case R.id.txtInputEditTextReligionCultureWrong:
                checkValue(inputLayoutReligionCultureWrong,b,6, "6'den büyük");

            case R.id.txtInputEditTextMathCorrect:
                checkValue(inputLayoutMathCorrect,b,40, "40'den büyük");

            case R.id.txtInputEditMathWrong:
                checkValue(inputLayoutMathWrong,b,40, "40'den büyük");

            case R.id.txtInputEditTextPhysicsCorrect:
                checkValue(inputLayoutPhysicsCorrect,b,14, "14'den büyük");

            case R.id.txtInputEditTextPhysicsWrong:
                checkValue(inputLayoutPhysicsWrong,b,14, "14'den büyük");

            case R.id.txtInputEditTextChemistryCorrect:
                checkValue(inputLayoutChemistryCorrect,b,13, "13'den büyük");

            case R.id.txtInputEditTextChemistryWrong:
                checkValue(inputLayoutChemistryWrong,b,13, "13'den büyük");

            case R.id.txtInputEditTextBiologyCorrect:
                checkValue(inputLayoutBiologyCorrect,b,13, "13'den büyük");

            case R.id.txtInputEditTextBiologyWrong:
                checkValue(inputLayoutBiologyWrong,b,13, "13'den büyük");

            case R.id.txtInputEditTextForeignLanguageCorrect:
                checkValue(inputLayoutForeignLanguageCorrect,b,80, "80'den büyük");

            case R.id.txtInputEditTextForeignLanguageWrong:
                checkValue(inputLayoutForeignLanguageWrong,b,80, "80'den büyük");



        }
    }

    private void checkValue(TextInputLayout layout, boolean b, int maxValue, String error) {

        if (!b && layout.getEditText().getText().toString().equals("")) {
            layout.setErrorEnabled(false);
        }

        else if (!b && Integer.valueOf(layout.getEditText().getText().toString()) > maxValue) {
            layout.setErrorEnabled(true);
            layout.setError(error);
        }

        else if (!b && Integer.valueOf(layout.getEditText().getText().toString()) <= maxValue) {
            layout.setErrorEnabled(false);
        }

    }

    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnCalculate:
                    calculateResults();

                    intent = new Intent(this,CalculatedResults.class);
                    intent.putExtra("diplomaGrade",diplomaGrade);
                    intent.putExtra("clearTurkishCorrect",clearTurkıshCorrect);

                    intent.putExtra("clearSocialStudiesCorrect",clearSocialStudiesCorrect);
                    intent.putExtra("clearBasicMathCorrect",clearBasicMathCorrect);
                    intent.putExtra("clearScienceCorrect",clearScienceCorrect);
                    intent.putExtra("rawTytScore",rawTytScore);
                    intent.putExtra("placementTytScore",placementTytScore);

                    intent.putExtra("clearMathCorrect",clearMathCorrect);
                    intent.putExtra("clearPhysicsCorrect",clearPhysicsCorrect);
                    intent.putExtra("clearChemistryCorrect",clearChemistryCorrect);
                    intent.putExtra("clearBiologyCorrect",clearBiologyCorrect);
                    intent.putExtra("rawSayisalScore",rawSayisalScore);
                    intent.putExtra("placementSayisalScore",placementSayisalScore);

                    intent.putExtra("clearTurkishLanguageAndLiteratureCorrect",clearTurkishLanguageAndLiteratureCorrect);
                    intent.putExtra("clearHistoryCorrect",clearHistoryCorrect);
                    intent.putExtra("clearGeographyCorrect",clearGeographyCorrect);
                    intent.putExtra("rawEsitAgirlikScore",rawEsitAgirlikScore);
                    intent.putExtra("placementEsitAgirlikScore",placementEsitAgirlikScore);

                    intent.putExtra("clearHistory2Correct",clearHistory2Correct);
                    intent.putExtra("clearGeography2Correct",clearGeography2Correct);
                    intent.putExtra("clearPhilosophyorrect",clearPhilosophyorrect);
                    intent.putExtra("clearReligionCultureCorrect",clearReligionCultureCorrect);
                    intent.putExtra("rawSozelScore",rawSozelScore);
                    intent.putExtra("placementSozelScore",placementSozelScore);

                    intent.putExtra("clearForeignLanguageCorrect",clearForeignLanguageCorrect);
                    intent.putExtra("rawForeignLanguageScore",rawForeignLanguageScore);
                    intent.putExtra("placementForeignLanguageScore",placementForeignLanguageScore);

                this.startActivity(intent);
                    break;

        }
    }
    //TODO Kullanıcı girdilerini kontrol et


    private float calculateClearCorrect(TextInputLayout correctLayout, TextInputLayout wrongLayout) {

        if (correctLayout.getEditText().getText().toString().isEmpty() && wrongLayout.getEditText().getText().toString().isEmpty()) {
            return 0.0f;

        }

        else if (wrongLayout.getEditText().getText().toString().isEmpty()) {
            return Float.valueOf(correctLayout.getEditText().getText().toString());
        }

        else if (correctLayout.getEditText().getText().toString().isEmpty()) {
            return -(Float.valueOf(wrongLayout.getEditText().getText().toString()))/4;
        }



        else {
            return Float.valueOf(correctLayout.getEditText().getText().toString()) - Float.valueOf(wrongLayout.getEditText().getText().toString()) / 4;
        }
    }




    private void calculateResults() {



        if (inputLayoutDiplomaGrade.getEditText().getText().toString().isEmpty()) {
            diplomaGrade = 0;
        }

        else {
            diplomaGrade = Float.valueOf(inputLayoutDiplomaGrade.getEditText().getText().toString());
        }

        clearTurkıshCorrect = calculateClearCorrect(inputLayoutTurkishCorrect,inputLayoutTurkishWrong);
        clearSocialStudiesCorrect = calculateClearCorrect(inputLayoutSocialStudiesCorrect,inputLayoutSocialStudiesWrong);
        clearBasicMathCorrect = calculateClearCorrect(inputLayoutBasicMathCorrect,inputLayoutBasicMathWrong);
        clearScienceCorrect = calculateClearCorrect(inputLayoutScienceCorrect,inputLayoutScienceWrong);
        rawTytScore = (clearTurkıshCorrect * 3.2 + clearSocialStudiesCorrect * 3.6 + clearBasicMathCorrect * 3.2  + clearScienceCorrect * 3.6 + 100);
        placementTytScore = rawTytScore + diplomaGrade * 0.6;

        clearMathCorrect = calculateClearCorrect(inputLayoutMathCorrect,inputLayoutMathWrong);
        clearPhysicsCorrect = calculateClearCorrect(inputLayoutPhysicsCorrect,inputLayoutPhysicsWrong);
        clearChemistryCorrect = calculateClearCorrect(inputLayoutChemistryCorrect,inputLayoutChemistryWrong);
        clearBiologyCorrect = calculateClearCorrect(inputLayoutBiologyCorrect,inputLayoutBiologyWrong);
        rawSayisalScore = ((rawTytScore - 100) * 0.4 + clearMathCorrect * 3 + clearPhysicsCorrect * 2.857142857142857 + clearChemistryCorrect * 3.076923076923077  + clearBiologyCorrect * 3.076923076923077 + 100);
        placementSayisalScore = rawSayisalScore + diplomaGrade * 0.6;

        clearTurkishLanguageAndLiteratureCorrect = calculateClearCorrect(inputLayoutTurkishLanguageAndLiteratureCorrect,inputLayoutTurkishLanguageAndLiteratureWrong);
        clearHistoryCorrect = calculateClearCorrect(inputLayoutHistoryCorrect,inputLayoutHistoryWrong);
        clearGeographyCorrect = calculateClearCorrect(inputLayoutGeographyCorrect,inputLayoutGeographyWrong);
        rawEsitAgirlikScore = ((rawTytScore - 100) * 0.4 + clearMathCorrect * 3 + clearTurkishLanguageAndLiteratureCorrect * 3 + clearHistoryCorrect * 2.8  + clearGeographyCorrect * 3.333333333333333 + 100);
        placementEsitAgirlikScore = rawEsitAgirlikScore + diplomaGrade * 0.6;

        clearHistory2Correct = calculateClearCorrect(inputLayoutHistory2Correct,inputLayoutHistory2Wrong);
        clearGeography2Correct = calculateClearCorrect(inputLayoutGeography2Correct,inputLayoutGeography2Wrong);
        clearPhilosophyorrect = calculateClearCorrect(inputLayoutPhilosophyCorrect,inputLayoutPhilosophyWrong);
        clearReligionCultureCorrect = calculateClearCorrect(inputLayoutReligionCultureCorrect,inputLayoutReligionCultureWrong);
        rawSozelScore = ((rawTytScore - 100) * 0.4 + clearTurkishLanguageAndLiteratureCorrect * 3 + clearHistoryCorrect * 2.8 + clearGeographyCorrect * 3.333333  + clearHistory2Correct * 2.9091 + clearGeography2Correct * 2.9091 + clearPhilosophyorrect * 3 + clearReligionCultureCorrect * 3.333333 + 100);
        placementSozelScore = rawSozelScore + diplomaGrade * 0.6;

        clearForeignLanguageCorrect = calculateClearCorrect(inputLayoutForeignLanguageCorrect,inputLayoutForeignLanguageWrong);
        rawForeignLanguageScore = ((rawTytScore - 100) * 0.4 + clearForeignLanguageCorrect * 3 + 100);
        placementForeignLanguageScore = rawForeignLanguageScore + diplomaGrade * 0.6;

        if (checkBoxIWonBefore.isChecked()) {
            placementTytScore -= diplomaGrade * 0.6* 0.5;
            placementSayisalScore -= diplomaGrade * 0.6* 0.5;
            placementEsitAgirlikScore -= diplomaGrade * 0.6* 0.5;
            placementSozelScore -= diplomaGrade * 0.6* 0.5;
            placementForeignLanguageScore -= diplomaGrade * 0.6* 0.5;
        }
    }

    private void initViews() {

        btnCalculate = findViewById(R.id.btnCalculate);

        inputLayoutTurkishCorrect = findViewById(R.id.inputLayoutTurkishCorrect);
        inputLayoutTurkishWrong = findViewById(R.id.inputLayoutTurkishWrong);
        inputLayoutSocialStudiesCorrect = findViewById(R.id.inputLayoutSocialStudiesCorrect);
        inputLayoutSocialStudiesWrong = findViewById(R.id.inputLayoutSocialStudiesWrong);
        inputLayoutBasicMathCorrect = findViewById(R.id.inputLayoutBasicMathCorrect);
        inputLayoutBasicMathWrong = findViewById(R.id.inputLayoutBasicMathWrong);
        inputLayoutScienceCorrect = findViewById(R.id.inputLayoutScienceCorrect);
        inputLayoutScienceWrong = findViewById(R.id.inputLayoutScienceWrong);
        inputLayoutDiplomaGrade = findViewById(R.id.inputLayoutDiplomaGrade);
        inputLayoutTurkishLanguageAndLiteratureCorrect = findViewById(R.id.inputLayoutTurkishLanguageAndLiteratureCorrect);
        inputLayoutTurkishLanguageAndLiteratureWrong = findViewById(R.id.inputLayoutTurkishLanguageAndLiteratureWrong);
        inputLayoutHistoryCorrect = findViewById(R.id.inputLayoutHistoryCorrect);
        inputLayoutHistoryWrong = findViewById(R.id.inputLayoutHistoryWrong);
        inputLayoutGeographyCorrect = findViewById(R.id.inputLayoutGeographyCorrect);
        inputLayoutGeographyWrong = findViewById(R.id.inputLayoutGeographyWrong);
        inputLayoutHistory2Correct = findViewById(R.id.inputLayoutHistory2Correct);
        inputLayoutHistory2Wrong = findViewById(R.id.inputLayoutHistory2Wrong);
        inputLayoutGeography2Correct = findViewById(R.id.inputLayoutGeography2Correct);
        inputLayoutGeography2Wrong = findViewById(R.id.inputLayoutGeography2Wrong);
        inputLayoutPhilosophyCorrect = findViewById(R.id.inputLayoutPhilosophyCorrect);
        inputLayoutPhilosophyWrong = findViewById(R.id.inputLayoutPhilosophyWrong);
        inputLayoutReligionCultureCorrect = findViewById(R.id.inputLayoutReligionCultureCorrect);
        inputLayoutReligionCultureWrong = findViewById(R.id.inputLayoutReligionCultureWrong);
        inputLayoutMathCorrect = findViewById(R.id.inputLayoutMathCorrect);
        inputLayoutMathWrong = findViewById(R.id.inputLayoutMathWrong);
        inputLayoutPhysicsCorrect = findViewById(R.id.inputLayoutPhysicsCorrect);
        inputLayoutPhysicsWrong = findViewById(R.id.inputLayoutPhysicsWrong);
        inputLayoutChemistryCorrect = findViewById(R.id.inputLayoutChemistryCorrect);
        inputLayoutChemistryWrong = findViewById(R.id.inputLayoutChemistryWrong);
        inputLayoutBiologyCorrect = findViewById(R.id.inputLayoutBiologyCorrect);
        inputLayoutBiologyWrong = findViewById(R.id.inputLayoutBiologyWrong);
        inputLayoutForeignLanguageCorrect = findViewById(R.id.inputLayoutForeignLanguageCorrect);
        inputLayoutForeignLanguageWrong = findViewById(R.id.inputLayoutForeignLanguageWrong);

        checkBoxIWonBefore = findViewById(R.id.checkBoxIWonBefore);





    }
}