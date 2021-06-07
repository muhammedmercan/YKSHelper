package com.muhammedmercan.ykshelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.muhammedmercan.ykshelper.R;

import static java.lang.String.valueOf;

public class CalculateActivity extends AppCompatActivity implements View.OnClickListener,View.OnFocusChangeListener  {

    private TextInputLayout inputLayoutTurkıshCorrect, inputLayoutTurkıshWrong, inputLayoutSocialStudiesCorrect, inputLayoutSocialStudiesWrong, inputLayoutBasicMathCorrect, inputLayoutBasicMathWrong, inputLayoutScienceCorrect, inputLayoutScienceWrong;
    private Button btnCalculate;
    private float clearTurkıshCorrect, clearSocialStudiesCorrect, clearBasicMathCorrect, clearScienceCorrect;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);


        initViews();

        btnCalculate.setOnClickListener(this);

        inputLayoutTurkıshCorrect.getEditText().setOnFocusChangeListener(this);
        inputLayoutTurkıshWrong.getEditText().setOnFocusChangeListener(this);
        inputLayoutSocialStudiesCorrect.getEditText().setOnFocusChangeListener(this);
        inputLayoutSocialStudiesWrong.getEditText().setOnFocusChangeListener(this);
        inputLayoutBasicMathCorrect.getEditText().setOnFocusChangeListener(this);
        inputLayoutBasicMathWrong.getEditText().setOnFocusChangeListener(this);
        inputLayoutScienceCorrect.getEditText().setOnFocusChangeListener(this);
        inputLayoutScienceWrong.getEditText().setOnFocusChangeListener(this);






    }

//TODO onfocuslistener i araştır

    public void onFocusChange(View view, boolean b) {

        switch (view.getId()) {
            case R.id.txtInputEditTextTurkıshCorrect:
                checkValue(inputLayoutTurkıshCorrect,b,40, "40'tan büyük");

            case R.id.txtInputEditTextTurkıshWrong:
                checkValue(inputLayoutTurkıshWrong,b,40, "40'tan büyük");

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
                    calculatePoint();

                    Intent intent = new Intent(this,CalculatedResults.class);
                    intent.putExtra("clearTurkishCorrect",clearTurkıshCorrect);
                    intent.putExtra("clearSocialStudiesCorrect",clearTurkıshCorrect);
                    intent.putExtra("clearBasicMathCorrect",clearTurkıshCorrect);
                    intent.putExtra("clearScienceCorrect",clearTurkıshCorrect);
                    this.startActivity(intent);
                    break;

        }
    }
    //TODO Kullanıcı girdilerini kontrol et



    private void calculatePoint() {

         clearTurkıshCorrect = Float.valueOf(inputLayoutTurkıshCorrect.getEditText().getText().toString()) - Float.valueOf(inputLayoutTurkıshWrong.getEditText().getText().toString()) / 4;
         clearSocialStudiesCorrect = Float.valueOf(inputLayoutSocialStudiesCorrect.getEditText().getText().toString()) - Float.valueOf(inputLayoutSocialStudiesWrong.getEditText().getText().toString()) / 4;
         clearBasicMathCorrect = Float.valueOf(inputLayoutBasicMathCorrect.getEditText().getText().toString()) - Float.valueOf(inputLayoutBasicMathWrong.getEditText().getText().toString()) / 4;
         clearScienceCorrect = Float.valueOf(inputLayoutScienceCorrect.getEditText().getText().toString()) - Float.valueOf(inputLayoutScienceWrong.getEditText().getText().toString()) / 4;

        System.out.println(String.format("Türkçe net = %.2f\nSosyal net = %.2f\nTemel Matematik net = %.2f\nFen Bilimleri net=%.2f",clearTurkıshCorrect,clearSocialStudiesCorrect,clearBasicMathCorrect,clearScienceCorrect));






    }
    private void initViews() {

        btnCalculate = findViewById(R.id.btnCalculate);

        inputLayoutTurkıshCorrect = findViewById(R.id.inputLayoutTurkıshCorrect);
        inputLayoutTurkıshWrong = findViewById(R.id.inputLayoutTurkıshWrong);
        inputLayoutSocialStudiesCorrect = findViewById(R.id.inputLayoutSocialStudiesCorrect);
        inputLayoutSocialStudiesWrong = findViewById(R.id.inputLayoutSocialStudiesWrong);
        inputLayoutBasicMathCorrect = findViewById(R.id.inputLayoutBasicMathCorrect);
        inputLayoutBasicMathWrong = findViewById(R.id.inputLayoutBasicMathWrong);
        inputLayoutScienceCorrect = findViewById(R.id.inputLayoutScienceCorrect);
        inputLayoutScienceWrong = findViewById(R.id.inputLayoutScienceWrong);



    }
}