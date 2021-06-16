package com.muhammedmercan.ykshelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.material.textfield.TextInputLayout;

public class CalculateActivity extends AppCompatActivity implements View.OnClickListener,View.OnFocusChangeListener  {

    private TextInputLayout inputLayoutTurkishCorrect, inputLayoutTurkishWrong, inputLayoutSocialStudiesCorrect, inputLayoutSocialStudiesWrong, inputLayoutBasicMathCorrect, inputLayoutBasicMathWrong, inputLayoutScienceCorrect, inputLayoutScienceWrong, inputLayoutDiplomaGrade, inputLayoutTurkishLanguageAndLiteratureCorrect, inputLayoutTurkishLanguageAndLiteratureWrong, inputLayoutHistoryCorrect, inputLayoutHistoryWrong, inputLayoutGeographyCorrect, inputLayoutGeographyWrong, inputLayoutHistory2Correct, inputLayoutHistory2Wrong, inputLayoutGeography2Correct, inputLayoutGeography2Wrong, inputLayoutPhilosophyCorrect, inputLayoutPhilosophyWrong, inputLayoutReligionCultureCorrect, inputLayoutReligionCultureWrong, inputLayoutMathCorrect, inputLayoutMathWrong, inputLayoutPhysicsCorrect, inputLayoutPhysicsWrong, inputLayoutChemistryCorrect, inputLayoutChemistryWrong, inputLayoutBiologyCorrect, inputLayoutBiologyWrong, inputLayoutForeignLanguageCorrect, inputLayoutForeignLanguageWrong;
    private Button btnCalculate;
    private float clearTurkıshCorrect, clearSocialStudiesCorrect, clearBasicMathCorrect, clearScienceCorrect, clearTurkishLanguageAndLiteratureCorrect, clearHistoryCorrect, clearGeographyCorrect, clearHistory2Correct, clearGeography2Correct, clearPhilosophyorrect, clearReligionCultureCorrect, clearMathCorrect, clearPhysicsCorrect, clearChemistryCorrect, clearBiologyCorrect, clearForeignLanguage ;
    private double rawTytScore, rawEsitAgirlikScore, rawSozelScore, rawSayisalScore, rawForeignLanguageScore;
    private Intent intent;

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
                checkValue(inputLayoutTurkishLanguageAndLiteratureCorrect,b,24, "100'den büyük");

            case R.id.txtInputEditTextTurkishLanguageAndLiteratureWrong:
                checkValue(inputLayoutTurkishLanguageAndLiteratureWrong,b,24, "100'den büyük");

            case R.id.txtInputEditTextHistoryCorrect:
                checkValue(inputLayoutHistoryCorrect,b,10, "100'den büyük");

            case R.id.txtInputEditTextHistoryWrong:
                checkValue(inputLayoutHistoryWrong,b,10, "100'den büyük");

            case R.id.txtInputEditTextGeographyCorrect:
                checkValue(inputLayoutGeographyCorrect,b,6, "100'den büyük");

            case R.id.txtInputEditTextGeographyWrong:
                checkValue(inputLayoutGeographyWrong,b,6, "100'den büyük");

            case R.id.txtInputEditTextHistory2Correct:
                checkValue(inputLayoutHistory2Correct,b,11, "100'den büyük");

            case R.id.txtInputEditTextHistory2Wrong:
                checkValue(inputLayoutHistory2Wrong,b,11, "100'den büyük");

            case R.id.txtInputEditTextGeography2Correct:
                checkValue(inputLayoutGeography2Correct,b,11, "100'den büyük");

            case R.id.txtInputEditTextGeography2Wrong:
                checkValue(inputLayoutGeography2Wrong,b,11, "100'den büyük");

            case R.id.txtInputEditTextPhilosophyCorrect:
                checkValue(inputLayoutPhilosophyCorrect,b,12, "100'den büyük");

            case R.id.txtInputEditTextPhilosophyWrong:
                checkValue(inputLayoutPhilosophyWrong,b,12, "100'den büyük");

            case R.id.txtInputEditTextReligionCultureCorrect:
                checkValue(inputLayoutReligionCultureCorrect,b,6, "100'den büyük");

            case R.id.txtInputEditTextReligionCultureWrong:
                checkValue(inputLayoutReligionCultureWrong,b,6, "100'den büyük");

            case R.id.txtInputEditTextMathCorrect:
                checkValue(inputLayoutMathCorrect,b,40, "100'den büyük");

            case R.id.txtInputEditMathWrong:
                checkValue(inputLayoutMathWrong,b,40, "100'den büyük");

            case R.id.txtInputEditTextPhysicsCorrect:
                checkValue(inputLayoutPhysicsCorrect,b,14, "100'den büyük");

            case R.id.txtInputEditTextPhysicsWrong:
                checkValue(inputLayoutPhysicsWrong,b,14, "100'den büyük");

            case R.id.txtInputEditTextChemistryCorrect:
                checkValue(inputLayoutChemistryCorrect,b,13, "100'den büyük");

            case R.id.txtInputEditTextChemistryWrong:
                checkValue(inputLayoutChemistryWrong,b,13, "100'den büyük");

            case R.id.txtInputEditTextBiologyCorrect:
                checkValue(inputLayoutBiologyCorrect,b,13, "100'den büyük");

            case R.id.txtInputEditTextBiologyWrong:
                checkValue(inputLayoutBiologyWrong,b,13, "100'den büyük");

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
                    intent.putExtra("diplomaGrade",Double.valueOf(inputLayoutDiplomaGrade.getEditText().getText().toString()));
                    intent.putExtra("clearTurkishCorrect",clearTurkıshCorrect);
                    intent.putExtra("clearSocialStudiesCorrect",clearSocialStudiesCorrect);
                    intent.putExtra("clearBasicMathCorrect",clearBasicMathCorrect);
                    intent.putExtra("clearScienceCorrect",clearScienceCorrect);
                    intent.putExtra("rawTytScore",rawTytScore);



                this.startActivity(intent);
                    break;

        }
    }
    //TODO Kullanıcı girdilerini kontrol et



    private void calculateResults() {

         clearTurkıshCorrect = Float.valueOf(inputLayoutTurkishCorrect.getEditText().getText().toString()) - Float.valueOf(inputLayoutTurkishWrong.getEditText().getText().toString()) / 4;
         clearSocialStudiesCorrect = Float.valueOf(inputLayoutSocialStudiesCorrect.getEditText().getText().toString()) - Float.valueOf(inputLayoutSocialStudiesWrong.getEditText().getText().toString()) / 4;
         clearBasicMathCorrect = Float.valueOf(inputLayoutBasicMathCorrect.getEditText().getText().toString()) - Float.valueOf(inputLayoutBasicMathWrong.getEditText().getText().toString()) / 4;
         clearScienceCorrect = Float.valueOf(inputLayoutScienceCorrect.getEditText().getText().toString()) - Float.valueOf(inputLayoutScienceWrong.getEditText().getText().toString()) / 4;

         rawTytScore = (clearTurkıshCorrect * 3.2 + clearSocialStudiesCorrect * 3.6 + clearBasicMathCorrect * 3.2  + clearScienceCorrect * 3.6 + 100);

        clearTurkishLanguageAndLiteratureCorrect = Float.valueOf(inputLayoutTurkishLanguageAndLiteratureCorrect.getEditText().getText().toString()) - Float.valueOf(inputLayoutTurkishLanguageAndLiteratureWrong.getEditText().getText().toString()) / 4;
        clearHistoryCorrect = Float.valueOf(inputLayoutHistoryCorrect.getEditText().getText().toString()) - Float.valueOf(inputLayoutHistoryWrong.getEditText().getText().toString()) / 4;
        clearGeographyCorrect = Float.valueOf(inputLayoutGeographyCorrect.getEditText().getText().toString()) - Float.valueOf(inputLayoutGeographyWrong.getEditText().getText().toString()) / 4;
        clearHistory2Correct = Float.valueOf(inputLayoutHistory2Correct.getEditText().getText().toString()) - Float.valueOf(inputLayoutHistory2Wrong.getEditText().getText().toString()) / 4;
        clearGeography2Correct = Float.valueOf(inputLayoutGeography2Correct.getEditText().getText().toString()) - Float.valueOf(inputLayoutGeography2Wrong.getEditText().getText().toString()) / 4;
        clearPhilosophyorrect = Float.valueOf(inputLayoutPhilosophyCorrect.getEditText().getText().toString()) - Float.valueOf(inputLayoutPhilosophyWrong.getEditText().getText().toString()) / 4;
        clearReligionCultureCorrect = Float.valueOf(inputLayoutReligionCultureCorrect.getEditText().getText().toString()) - Float.valueOf(inputLayoutReligionCultureWrong.getEditText().getText().toString()) / 4;
        clearMathCorrect = Float.valueOf(inputLayoutMathCorrect.getEditText().getText().toString()) - Float.valueOf(inputLayoutMathWrong.getEditText().getText().toString()) / 4;
        clearPhysicsCorrect = Float.valueOf(inputLayoutPhysicsCorrect.getEditText().getText().toString()) - Float.valueOf(inputLayoutPhysicsWrong.getEditText().getText().toString()) / 4;
        clearChemistryCorrect = Float.valueOf(inputLayoutChemistryCorrect.getEditText().getText().toString()) - Float.valueOf(inputLayoutChemistryWrong.getEditText().getText().toString()) / 4;
        clearBiologyCorrect = Float.valueOf(inputLayoutBiologyCorrect.getEditText().getText().toString()) - Float.valueOf(inputLayoutBiologyWrong.getEditText().getText().toString()) / 4;
        clearForeignLanguage = Float.valueOf(inputLayoutForeignLanguageCorrect.getEditText().getText().toString()) - Float.valueOf(inputLayoutForeignLanguageWrong.getEditText().getText().toString()) / 4;

        rawEsitAgirlikScore = (clearMathCorrect * 3 + clearTurkishLanguageAndLiteratureCorrect * 3 + clearHistoryCorrect * 2.8  + clearGeographyCorrect * 3.33 + 100);
        rawSozelScore = (clearTurkishLanguageAndLiteratureCorrect * 3 + clearHistoryCorrect * 2.8 + clearGeographyCorrect * 3.33  + clearHistory2Correct * 2.91 + clearGeography2Correct * 2.91 + clearPhilosophyorrect * 3 + clearReligionCultureCorrect * 3.33 + 100);
        rawSayisalScore = (clearMathCorrect * 3 + clearPhysicsCorrect * 2.85 + clearChemistryCorrect * 3.07  + clearBiologyCorrect * 3.07 + 100);
        rawForeignLanguageScore = (clearForeignLanguage * 3 + 100);


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



    }
}